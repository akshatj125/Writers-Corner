package com.crudProject.springbootbackend.model;

import com.crudProject.springbootbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {



    private final UserRepository userRepository;
    private User user;
    public void saveUser(@RequestBody User user)
    {
        userRepository.save(user);
    }

}
