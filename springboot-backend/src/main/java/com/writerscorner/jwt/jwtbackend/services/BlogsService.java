package com.writerscorner.jwt.jwtbackend.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.writerscorner.jwt.jwtbackend.entities.Blogs;
import com.writerscorner.jwt.jwtbackend.entities.User;
import com.writerscorner.jwt.jwtbackend.exceptions.AppException;
import com.writerscorner.jwt.jwtbackend.repositories.BlogsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogsService {
    private final BlogsRepository blogsRepository;

    public Blogs create(Blogs blog)
    {
        Blogs savedBlog=blogsRepository.save(blog);
        return savedBlog;
    }

    public Blogs findBlogs(long Id){
        Blogs blogs = blogsRepository.findById(Id)
                .orElseThrow(() -> new AppException("Blog not found", HttpStatus.NOT_FOUND));
        return blogs;
    }

    public List<Blogs> findAllBlogs()
    {
        return blogsRepository.findAll();
    }

    public Boolean deleteBlog(long id, User user) {
        Blogs blogs= blogsRepository.findById(id)
            .orElseThrow(()-> new AppException("Blog not found",HttpStatus.NOT_FOUND));
        
        if(blogs.getUserName().equals(user.getUsername())){
            blogsRepository.deleteById(id);
            return true;
        }
        throw new AppException("Not allowed",HttpStatus.NOT_ACCEPTABLE);
    }
}
