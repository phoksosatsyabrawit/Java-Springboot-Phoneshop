package com.psb.coding.phoneshop.configuration.security.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
	
	private final AuthenticationManager authenticationManager; // authenticationManager will check up with SecurityConfig
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			//deserialize json to object
			LoginRequestDto loginRequestDto = mapper.readValue(request.getInputStream(), LoginRequestDto.class);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authentication);
			return authenticate;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		List<@Nullable String> authoritiesList = authResult.getAuthorities().stream()
		.map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		String key = "asdfghkl;asdfghkl;asdfghkl;asdfghkl;asdfghkl;";
		String token = Jwts.builder()
				//header
				.subject(authResult.getName())
				.issuedAt(new Date())			
				//payload
				.claim("Authorities", authoritiesList)
				.expiration(java.sql.Date.valueOf(LocalDate.now().plusDays(7)))
				.issuer("psb.com")
				//sign
				.signWith(Keys.hmacShaKeyFor(key.getBytes()))
				.compact();
		response.setHeader("Authorization", "Bearer " + token);
	}
}
