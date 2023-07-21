package com.crudProject.springbootbackend.controller;

import com.crudProject.springbootbackend.model.Blogs;
import com.crudProject.springbootbackend.repository.BlogsRepository;
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
public class BlogsController {
    @Autowired
    private BlogsRepository BlogsRepository;

    @CrossOrigin()
    @GetMapping("/blogs")
    public List<Blogs> Blogs(){
        return this.BlogsRepository.findAll();
    }

    @CrossOrigin()
    @PostMapping("/createblog")
    public void CreateBlog(@RequestBody Blogs blog)
    {
        this.BlogsRepository.save(blog);
    }

}
