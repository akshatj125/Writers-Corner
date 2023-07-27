package com.writerscorner.jwt.jwtbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    @Size(max = 100)
    private String username;

    @Column(name = "name", nullable = false)
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String emailId;

    @Size(max = 255)
    private String password;

    public User(String username, String name, String emailId, String password) {
        this.username = username;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
    }

    public User(String username, String name, String emailId) {
        this.username = username;
        this.name = name;
        this.emailId = emailId;
    }

    

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}