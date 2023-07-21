package com.crudProject.springbootbackend.repository;

import com.crudProject.springbootbackend.model.Bookmarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookmarksRepository extends JpaRepository <Bookmarks, Long >{

    Optional<Bookmarks> findByblogId(long blogId);
}
