package com.psb.coding.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.psb.coding.phoneshop.dto.UserDTO;
import com.psb.coding.phoneshop.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	User toUser(UserDTO dto);
	UserDTO toUserDTO(User entity);
}
