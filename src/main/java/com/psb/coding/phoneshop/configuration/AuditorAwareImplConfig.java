package com.psb.coding.phoneshop.configuration;

import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImplConfig implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		@Nullable
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.ofNullable(username);
	}

}
