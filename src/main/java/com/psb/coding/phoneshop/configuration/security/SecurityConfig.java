package com.psb.coding.phoneshop.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

import com.psb.coding.phoneshop.configuration.security.jwt.JwtLoginFilter;
import com.psb.coding.phoneshop.configuration.security.jwt.TokenVerifyFilter;


@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}

	@Bean
	public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
		http.csrf(csrf -> csrf.disable())
			.addFilter(new JwtLoginFilter(authManager))
			.addFilterAfter(new TokenVerifyFilter(), JwtLoginFilter.class)
			.sessionManagement(session -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(authz -> authz
					.requestMatchers("/login", "/welcome.html", "/css/**", "/js/**", "/swagger-ui/**", "/v3/api-docs*/**").permitAll()
				//.requestMatchers(HttpMethod.GET, "/brands").hasAnyRole(RoleConfig.ADMIN.name(), RoleConfig.SALE.name()) // ROLE_ADMIN
				//.requestMatchers(HttpMethod.POST, "/brands").hasRole(RoleConfig.ADMIN.name())
			.anyRequest().authenticated());
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		UserDetails user1 = User.builder()
				.username("sam")
				.password(passwordEncoder.encode("sam123"))
				.authorities(RoleConfig.ADMIN.getAuthorities())
				.build();
		UserDetails user2 = User.builder()
				.username("tey")
				.password(passwordEncoder.encode("tey123"))
				.authorities(RoleConfig.SALE.getAuthorities())
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
