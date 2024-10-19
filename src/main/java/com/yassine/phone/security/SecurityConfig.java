package com.yassine.phone.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true) a la place de .requestMatchers(HttpMethod.....
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .csrf(csrf -> csrf.disable())
	        .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
	            @Override
	            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	                CorsConfiguration cors = new CorsConfiguration();
	                cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); // Autoriser votre frontend
	                cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Méthodes HTTP permises
	                cors.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With")); // En-têtes autorisés
	                cors.setExposedHeaders(Arrays.asList("Authorization")); // Exposer certains en-têtes
	                cors.setAllowCredentials(true); // Permettre les cookies si nécessaire
	                return cors;
	            }
	        }))
	        .authorizeHttpRequests(requests -> requests
	            .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER")
	            .requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
	            .requestMatchers(HttpMethod.POST, "/api/addphon/**").hasAuthority("ADMIN")
	            .requestMatchers(HttpMethod.PUT, "/api/updatephon/**").hasAuthority("ADMIN")
	            .requestMatchers(HttpMethod.DELETE, "/api/delp/**").hasAuthority("ADMIN")
	            .anyRequest().authenticated())
	        .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}

}