package com.psb.coding.phoneshop.dto;

import java.time.LocalDate;

import com.psb.coding.phoneshop.configuration.security.RoleEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDTO {

	private String firstName;
	private String LastName;
	private String password;
	private LocalDate dateOfBirth;
	
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;
	private Boolean isEnabled;
}
