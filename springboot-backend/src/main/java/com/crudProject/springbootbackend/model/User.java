package com.crudProject.springbootbackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Builder
@Component
@Getter
@Setter

public class User {
    
//    @SequenceGenerator(
//            name = "test",
//            sequenceName = "test",
//            allocationSize = 1
//    )

//    @GeneratedValue(
//        strategy = GenerationType.SEQUENCE,
//        generator = "user_sequence"
//    )

    @Id
    @GeneratedValue()
    private long id ;
    private String username;
    private String name;
    private String emailId;
    private String password;

    public User(){

    }

    public User(long id, String username, String name,
                String emailId, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.emailId = emailId;
        this.password= password;
    }


    public User(String username, String name,
                String emailId, String password) {
        this.username = username;
        this.name = name;
        this.emailId = emailId;
        this.password= password;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
