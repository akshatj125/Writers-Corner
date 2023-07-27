package com.writerscorner.jwt.jwtbackend.controllers;

import java.util.List;

import com.writerscorner.jwt.jwtbackend.config.UserAuthProvider;
import com.writerscorner.jwt.jwtbackend.entities.Blogs;
import com.writerscorner.jwt.jwtbackend.entities.User;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.writerscorner.jwt.jwtbackend.services.BlogsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BlogsController {
    
    private final BlogsService blogsService;
    private final UserAuthProvider userAuthProvider;


    @GetMapping("/allblogs")
    public ResponseEntity<List<Blogs>> AllBLogs(){
        List<Blogs> allBlogs = blogsService.findAllBlogs();

        return ResponseEntity.ok(allBlogs);
    }

    @PostMapping("/createBlog")
    public ResponseEntity<Blogs> createBlog(@RequestBody Blogs blogs, @RequestHeader("Authorization") String token){
        token= token.split("\\s+")[1];
        User user= (User) userAuthProvider.validateToken(token).getPrincipal();
        blogs.setUserName(user.getUsername());
        Blogs createdBlog = blogsService.create(blogs);
        return ResponseEntity.ok(createdBlog);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blogs> getBlog(@PathVariable long id){
        Blogs blog = blogsService.findBlogs(id);
        return ResponseEntity.ok(blog);
        
    }

    @DeleteMapping("/deleteblog/{id}")
    public ResponseEntity<Boolean> deleteBlog(@PathVariable long id, @RequestHeader("Authorization") String token){
        token= token.split("\\s+")[1];
        User user= (User) userAuthProvider.validateToken(token).getPrincipal();
        return ResponseEntity.ok( blogsService.deleteBlog(id,user));
        


    }

}
