package com.gbueno.app.mappers;

import com.gbueno.app.dtos.RegisterUserRequest;
import com.gbueno.app.dtos.UserDto;
import com.gbueno.app.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
}
