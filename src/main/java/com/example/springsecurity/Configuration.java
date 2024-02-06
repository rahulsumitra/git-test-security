/*
 * package com.example.springsecurity;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configurers.
 * AbstractHttpConfigurer; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @org.springframework.context.annotation.Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableMethodSecurity public class Configuration {
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { return http.csrf() .disable() .authorizeHttpRequests()
 * .requestMatchers("/products/welcome") .permitAll() .and()
 * .authorizeHttpRequests() .requestMatchers("/products/**") .authenticated()
 * .and() .formLogin() .and().build();
 * 
 * }
 * 
 * @Bean public UserDetailsService userDetailsService(PasswordEncoder encoder) {
 * UserDetails admin =
 * User.withUsername("Rahul").password(encoder.encode("pass1")).roles("ADMIN").
 * build(); UserDetails user =
 * User.withUsername("Neha").password(encoder.encode("pass2")).roles("USER").
 * build();
 * 
 * return new InMemoryUserDetailsManager(admin, user); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); } }
 */