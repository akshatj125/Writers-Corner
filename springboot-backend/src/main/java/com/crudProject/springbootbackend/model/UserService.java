package com.crudProject.springbootbackend.model;
import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.crudProject.exceptions.AppException;
import com.crudProject.springbootbackend.repository.UserRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor

@Service
public class UserService {


    private  PasswordEncoder passwordEncoder;
    private  UserRepository userRepository;

    
    public User register(@RequestBody User user)
    {
        Optional <User> newUser= userRepository.findByUsername(user.getUsername());
        if(newUser.isPresent())
        {
            throw new AppException("User Already Exists",HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(user.getPassword())));

        user =userRepository.save(user);
        return user;
    }


    

    public User findByUsername(String Username) {
        User user = userRepository.findByUsername(Username)
              .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        return user;
                
                
    }




}
