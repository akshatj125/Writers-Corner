package com.crudProject.springbootbackend.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudProject.jwt.UserAuthProvider;
import com.crudProject.springbootbackend.model.User;
import com.crudProject.springbootbackend.model.UserService;


@RestController
public class AuthController {
    private UserAuthProvider userAuthProvider;
    private  UserService userService;

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<User> register(@RequestBody User user)
    {
        User createdUser = userService.register(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    
}
