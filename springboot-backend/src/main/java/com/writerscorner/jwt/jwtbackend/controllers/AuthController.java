package com.ashish.jwt.jwtbackend.controllers;

import com.ashish.jwt.jwtbackend.config.UserAuthProvider;
import com.ashish.jwt.jwtbackend.dtos.CredentialsDto;
import com.ashish.jwt.jwtbackend.dtos.SignUpDto;
import com.ashish.jwt.jwtbackend.dtos.UserDto;
import com.ashish.jwt.jwtbackend.entities.User;
import com.ashish.jwt.jwtbackend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User credentials) {
        User user = userService.login(credentials);
        user.setPassword(userAuthenticationProvider.createToken(user.getUsername()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody  User user) {
        System.out.println("In register");
        User createdUser = userService.register(user);
        createdUser.setPassword(userAuthenticationProvider.createToken(user.getUsername()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
