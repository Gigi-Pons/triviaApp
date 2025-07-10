package com.gbueno.app.controllers;

import com.gbueno.app.dtos.RegisterUserRequest;
import com.gbueno.app.entities.UserDto;
import com.gbueno.app.mappers.UserMapper;
import com.gbueno.app.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    //Going to do a simple test to register a user for now.
    //Not checking for duplicates yet

    @PostMapping
    public ResponseEntity<UserDto> registerUser(
            @Valid @RequestBody RegisterUserRequest request
    ) {

        System.out.println("Check after validation and before mapping");
        //Need to create a userMapper for better readability
        var user = userMapper.toEntity(request);
        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }
}
