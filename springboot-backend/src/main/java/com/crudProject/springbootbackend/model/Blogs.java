package com.crudProject.springbootbackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "blogs")
@Builder
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blogs {
    @Id
    @GeneratedValue()
    private long blogId;
    private String title;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate datetime;
    private long userId;
    @Builder.Default
    private long views = 0;

    // public Blogs() {

    // }

    // public Blogs(long blogId, String title, String content, long userId, long views) {
    //     this.blogId = blogId;
    //     this.title = title;
    //     this.content = content;
    //     this.datetime = LocalDate.now();
    //     System.out.println(" s " + LocalDateTime.now());
    //     this.userId = userId;
    //     this.views = views;
    // }

    // public Blogs(String title, String content, long userId, long views) {
    //     this.title = title;
    //     this.content = content;
    //     this.datetime = LocalDate.now();
    //     System.out.println(" s " + LocalDateTime.now());
    //     this.userId = userId;
    //     this.views = views;
    // }


    // public Blogs(long blogId, String title, String content, LocalDate datetime, long userId, long views) {
    //     this.blogId = blogId;
    //     this.title = title;
    //     this.content = content;
    //     this.datetime = LocalDate.now();
    //     this.userId = userId;
    //     this.views = views;
    // }

    @Override
    public String toString() {
        return "User{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", datetime='" + datetime + '\'' +
                ", views='" + views + '\'' +
                '}';
    }

}
