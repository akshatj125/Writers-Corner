package com.crudProject.springbootbackend.repository;

import com.crudProject.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long >{
        Optional<User> findByEmailId(String emailId);
        Optional<User> findByUsername(String username);
}
