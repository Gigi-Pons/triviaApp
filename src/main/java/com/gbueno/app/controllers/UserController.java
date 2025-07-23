package com.gbueno.app.controllers;
import com.gbueno.app.dtos.RegisterUserRequest;
import com.gbueno.app.mappers.UserMapper;
import com.gbueno.app.repositories.UserRepository;
import com.gbueno.app.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserService userService;

    //Going to do a simple test to register a user for now.
    //Not checking for duplicates yet

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
    ) {

        return userService.registerUser(request, uriBuilder);
    }
}
