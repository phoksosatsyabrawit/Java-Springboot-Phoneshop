package com.psb.coding.phoneshop.configuration.security;

import static com.psb.coding.phoneshop.configuration.security.PermissionConfig.BRAND_READ;
import static com.psb.coding.phoneshop.configuration.security.PermissionConfig.BRAND_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleConfig {

	ADMIN(Set.of(BRAND_READ, BRAND_WRITE)),
	SALE(Set.of(BRAND_READ));
	
	private Set<PermissionConfig> permission;
	
	public Set<SimpleGrantedAuthority> getAuthorities(){
		Set<SimpleGrantedAuthority> authorizes = this.permission.stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getDescription())).collect(Collectors.toSet());
		SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + this.name());
		authorizes.add(role);
		return authorizes;
	}

}
