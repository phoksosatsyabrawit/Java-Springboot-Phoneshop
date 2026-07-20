package com.psb.coding.phoneshop.service;

import java.util.Optional;

import com.psb.coding.phoneshop.configuration.security.jwt.UserAuth;
import com.psb.coding.phoneshop.entity.User;

public interface UserService {
	Optional<UserAuth> findUserByUsername(String username);
	User createUser(User user);
}
