package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.dto.AuthRequest;
import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.service.JwtService;
import com.example.springsecurity.service.ProductService;

@RestController
@RequestMapping("/products")
public class SecurityController {

	@Autowired
	private ProductService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome User";
	}

	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAllUsers() {
		return "All the users";
	}

	@GetMapping("/specific")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getUser() {
		return "One User";
	}

	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

	@PostMapping("/authenticate")
	public String authenticateAndGettoken(@RequestBody AuthRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(request.getUserName());
		}else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

}
