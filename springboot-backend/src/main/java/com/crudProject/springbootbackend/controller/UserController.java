package com.crudProject.springbootbackend.controller;

import com.crudProject.springbootbackend.model.User;
import com.crudProject.springbootbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{emailId}")
    public void findbyemail (@PathVariable String emailId){
        System.out.println(emailId);
        //return this.userRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
//        return this.userRepository.findByEmail(emailId);
        Optional<User> userByEmail = this.userRepository.findByEmailId(emailId);
        if(userByEmail.isPresent()) {
            System.out.println("user is present " + userByEmail.get());
            return;
        }
        System.out.println("not present..");
    }

    @CrossOrigin()
    @GetMapping("/")
    public List<User> user(){
        return this.userRepository.findAll();
    }

//    @RequestMapping("/user/{id}")
//    public Optional<User> us(@PathVariable long id)
//    {
//        return this.userRepository.findById(id);
//    }
//
//    @CrossOrigin()
//    @PostMapping("/user")
//    public void saveUser(@RequestBody User user)
//    {
//        userRepository.save(user);
//    }

    @CrossOrigin()
    @PostMapping("/user")
    public boolean saveUser(@RequestBody User user) {
        Optional<User> userExists = this.userRepository.findByUsername(user.getUsername());
        if(userExists.isPresent()) {
            System.out.println("user is present " + userExists.get());
            return false;
        }
        this.userRepository.save(user);
        return true;
    }


    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User existingUser = userRepository.findById(id).orElseThrow(()-> new IllegalStateException("User doesn't exist."));

        existingUser.setName(userDetails.getName());
        userRepository.save(existingUser);

        existingUser.setEmailId(userDetails.getEmailId());
        userRepository.save(existingUser);

        return ResponseEntity.ok(existingUser);

    }
}
