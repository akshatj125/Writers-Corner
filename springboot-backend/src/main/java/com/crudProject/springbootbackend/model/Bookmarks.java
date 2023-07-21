package com.crudProject.springbootbackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "Bookmarks")
@Builder
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bookmarks {
    @Id
    @GeneratedValue()
    private long bookmarkId;
    private long blogId;
    private long userId;



    // @Override
    // public String toString() {
    //     return "User{" +
    //             "blogId=" + blogId +
    //             ", title='" + title + '\'' +
    //             ", content='" + content + '\'' +
    //             ", userId='" + userId + '\'' +
    //             ", datetime='" + datetime + '\'' +
    //             ", views='" + views + '\'' +
    //             '}';
    // }

}
