package com.writerscorner.jwt.jwtbackend.controllers;

import java.util.List;
import com.writerscorner.jwt.jwtbackend.entities.Blogs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.writerscorner.jwt.jwtbackend.services.BlogsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BlogsController {
    
    private final BlogsService blogsService;

    @GetMapping("/allblogs")
    public ResponseEntity<List<Blogs>> AllBLogs(){
        List<Blogs> allBlogs = blogsService.findAllBlogs();

        return ResponseEntity.ok(allBlogs);
    }

    @PostMapping("/createBlog")
    public ResponseEntity<Blogs> createBlog(@RequestBody Blogs blogs){
        Blogs createdBlog = blogsService.create(blogs);
        return ResponseEntity.ok(createdBlog);
    }

}
