package com.writerscorner.jwt.jwtbackend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.writerscorner.jwt.jwtbackend.entities.Blogs;

public interface BlogsRepository extends JpaRepository<Blogs, Long>{

    public Optional<Blogs> findById(long Id);
    public Optional<List<Blogs>> findByUserName(String username);
}
