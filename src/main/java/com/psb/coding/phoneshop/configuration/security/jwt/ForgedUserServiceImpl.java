package com.psb.coding.phoneshop.configuration.security.jwt;

/*@RequiredArgsConstructor
@Service
public class ForgedUserServiceImpl implements UserService {

	private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<UserAuth> findUserByUsername(String username) {
		List<UserAuth> userAuthServices = List.of(
				new UserAuth("steve", passwordEncoder.encode("steve123"), RoleConfig.ADMIN.getAuthorities(),
						true, true, true, true),
				new UserAuth("votey", passwordEncoder.encode("votey123"), RoleConfig.SALE.getAuthorities(), 
						true, true, true, true));
		return userAuthServices.stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}
}*/
