package com.psb.coding.phoneshop.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private String email;
	private LocalDate dateOfBirth;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	@Column(name = "is_account_non_expired")
	private Boolean isAccountNonExpired;
	@Column(name = "is_account_non_locked")
	private Boolean isAccountNonLocked;
	@Column(name = "is_credentials_non_expired")
	private Boolean isCredentialsNonExpired;
	@Column(name = "is_enabled")
	private Boolean isEnabled;
}
