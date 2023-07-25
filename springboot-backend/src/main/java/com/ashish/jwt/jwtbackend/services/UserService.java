package com.ashish.jwt.jwtbackend.services;

import com.ashish.jwt.jwtbackend.dtos.CredentialsDto;
import com.ashish.jwt.jwtbackend.dtos.SignUpDto;
import com.ashish.jwt.jwtbackend.dtos.UserDto;
import com.ashish.jwt.jwtbackend.entities.User;
import com.ashish.jwt.jwtbackend.exceptions.AppException;
import com.ashish.jwt.jwtbackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public User login(User credentials) {
        User user = userRepository.findByUsername(credentials.getUsername())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentials.getPassword()), user.getPassword())) {
            return user;
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }


    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return user;
    }

    public User register(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(user.getPassword())));

        User savedUser = userRepository.save(user);

        return savedUser;
    }
}
