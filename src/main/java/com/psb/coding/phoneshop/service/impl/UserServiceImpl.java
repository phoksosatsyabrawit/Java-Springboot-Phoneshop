package com.psb.coding.phoneshop.service.impl;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.configuration.security.jwt.UserAuth;
import com.psb.coding.phoneshop.entity.User;
import com.psb.coding.phoneshop.exception.ApiException;
import com.psb.coding.phoneshop.repository.UserRepository;
import com.psb.coding.phoneshop.service.UserService;
import com.psb.coding.phoneshop.service.impl.helper.UserServiceImplHelper;

import lombok.RequiredArgsConstructor;

@Primary
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public Optional<UserAuth> findUserByUsername(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User [%s] not found".formatted(username)));
		UserAuth userAuth = UserAuth.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(UserServiceImplHelper.getAuthority(user.getRoles()))
				.isAccountNonExpired(true)
				.isAccountNonLocked(true)
				.isCredentialsNonExpired(true)
				.isEnabled(true)
				.build();
		return Optional.of(userAuth);
	}

	@Override
	public User createUser(User user) {
		String username = "%s".formatted(user.getFirstName());
		user.setUsername(username);
		return userRepository.save(user);
	}
}
