package com.psb.coding.phoneshop.configuration.security;

import static com.psb.coding.phoneshop.configuration.security.RoleConfig.ADMIN;
import static com.psb.coding.phoneshop.configuration.security.RoleConfig.SALE;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authz -> authz
				.requestMatchers("/index.html", "/css/**", "/js/**").permitAll()
				//.requestMatchers("/brands/**").hasAuthority(ADMIN.name())
				//.requestMatchers("/brands/**").hasAllAuthorities(SALE.name())
				//.requestMatchers(HttpMethod.GET, "/brands/**").hasAuthority(BRAND_READ.getDescription())
				//.requestMatchers("/brands/**").hasRole(RoleConfig.SALE.name())
				.requestMatchers(HttpMethod.GET).hasAnyRole(ADMIN.name(), SALE.name())
				.requestMatchers(HttpMethod.POST).hasRole(ADMIN.name())
				.anyRequest().authenticated())
			.httpBasic(withDefaults());
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		UserDetails user1 = User.builder()
				.username("sam")
				.password(passwordEncoder.encode("sam123"))
				//.roles("user")
				.authorities(RoleConfig.SALE.getAuthorities())
				.build();
		UserDetails user2 = User.builder()
				.username("tey")
				.password(passwordEncoder.encode("tey123"))
				//.roles("admin")
				.authorities(RoleConfig.ADMIN.getAuthorities())
				.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
