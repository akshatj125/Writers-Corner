package com.ashish.jwt.jwtbackend.repositories;

import com.ashish.jwt.jwtbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String Username);

}