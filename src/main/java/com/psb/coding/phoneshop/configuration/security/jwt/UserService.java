package com.psb.coding.phoneshop.configuration.security.jwt;

import java.util.Optional;

public interface UserService {

	Optional<UserAuthService> findUserByUsername(String username);
}
