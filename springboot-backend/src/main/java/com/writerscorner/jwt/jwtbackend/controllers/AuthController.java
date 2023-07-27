package com.writerscorner.jwt.jwtbackend.controllers;

import com.writerscorner.jwt.jwtbackend.config.UserAuthProvider;
import com.writerscorner.jwt.jwtbackend.entities.User;
import com.writerscorner.jwt.jwtbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        
        User createdUser = userService.register(user);
        createdUser.setPassword(userAuthenticationProvider.createToken(user.getUsername()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @GetMapping("/u/{username}")
    public ResponseEntity<User> getUserDetails(@RequestBody String username){
        return ResponseEntity.ok(userService.restrictedFind(username));
    }

}
