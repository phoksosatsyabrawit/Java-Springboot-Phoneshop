package com.psb.coding.phoneshop.entity;

import java.time.LocalDate;

import com.psb.coding.phoneshop.configuration.security.RoleConfig;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	private String firstName;
	private String LastName;
	private String username;
	private String password;
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private RoleConfig role;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;
	private Boolean isEnabled;
}
