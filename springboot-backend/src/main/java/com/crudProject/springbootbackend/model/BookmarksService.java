package com.crudProject.springbootbackend.model;

import com.crudProject.springbootbackend.repository.BookmarksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookmarksService {



    private final BookmarksRepository bookmarksRepository;
    private Bookmarks bookmarks;
    public void saveBookmark(@RequestBody Bookmarks bookmarks)
    {
        bookmarksRepository.save(bookmarks);
    }

}
