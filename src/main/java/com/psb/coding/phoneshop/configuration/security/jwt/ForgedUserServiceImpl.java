package com.psb.coding.phoneshop.configuration.security.jwt;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.configuration.security.RoleConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ForgedUserServiceImpl implements UserService {

	private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<UserAuthService> findUserByUsername(String username) {
		List<UserAuthService> userAuthServices = List.of(
				new UserAuthService("steve", passwordEncoder.encode("steve123"), RoleConfig.ADMIN.getAuthorities(),
						true, true, true, true),
				new UserAuthService("votey", passwordEncoder.encode("votey123"), RoleConfig.SALE.getAuthorities(), 
						true, true, true, true));
		return userAuthServices.stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}
}
