package com.writerscorner.jwt.jwtbackend.repositories;

import com.writerscorner.jwt.jwtbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String Username);

}