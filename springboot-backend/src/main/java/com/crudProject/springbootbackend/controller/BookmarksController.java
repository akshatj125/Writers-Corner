package com.crudProject.springbootbackend.controller;

import com.crudProject.springbootbackend.model.Bookmarks;
import com.crudProject.springbootbackend.repository.BookmarksRepository;
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
public class BookmarksController {
    @Autowired
    private BookmarksRepository BookmarksRepository;

    @CrossOrigin()
    @GetMapping("/Bookmarks")
    public List<Bookmarks> Bookmarks(){
        return this.BookmarksRepository.findAll();
    }

    @CrossOrigin()
    @PostMapping("/addbookmark")
    public void CreateBlog(@RequestBody Bookmarks bookmark)
    {
        this.BookmarksRepository.save(bookmark);
    }

}
