package com.crudProject.springbootbackend.repository;

import com.crudProject.springbootbackend.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogsRepository extends JpaRepository <Blogs, Long >{

    Optional<Blogs> findByblogId(long blogId);
}
