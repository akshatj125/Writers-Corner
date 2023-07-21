package com.crudProject.springbootbackend.model;

import com.crudProject.springbootbackend.repository.BlogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogsService {



    private final BlogsRepository BlogsRepository;
    private Blogs blog;
    public void saveBlogs(@RequestBody Blogs blog)
    {
        BlogsRepository.save(blog);
    }

}
