package com.psb.coding.phoneshop.configuration.security.jwt;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenVerifyFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		if(Objects.isNull(header) || !header.contains("Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
		String token = header.replace("Bearer ", "");
		String key = "asdfghjkl;asdfghjkl;asdfghjkl;asdfghjkl;asdfghjkl;";
		Claims payload = Jwts.parser()
			.verifyWith(Keys.hmacShaKeyFor(key.getBytes())) // set the signed key
			.build() 										// build actual parser
			.parseSignedClaims(token)						// parse & verify
			.getPayload();									// get claims
		String username = payload.getSubject();
		List<String> authorities = (List<String>) payload.get("Authorities");
		List<SimpleGrantedAuthority> authzList = authorities.stream()
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authzList);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}
}
