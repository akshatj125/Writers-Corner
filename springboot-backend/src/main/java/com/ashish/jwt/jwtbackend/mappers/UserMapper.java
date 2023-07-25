package com.ashish.jwt.jwtbackend.mappers;

import com.ashish.jwt.jwtbackend.dtos.SignUpDto;
import com.ashish.jwt.jwtbackend.dtos.UserDto;
import com.ashish.jwt.jwtbackend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}