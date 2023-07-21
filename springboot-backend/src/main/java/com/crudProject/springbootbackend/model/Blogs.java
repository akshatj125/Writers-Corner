package com.crudProject.springbootbackend.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

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
    @Column(columnDefinition = "TEXT")
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date datetime = new Date();

    private long userId;
    @Builder.Default
    private long views = 0;

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
