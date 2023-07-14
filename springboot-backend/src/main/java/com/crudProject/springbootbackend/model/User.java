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
    private long id;
    private String firstname;
    private String lastname;
    private String emailId;

    public User(){

    }

    public User(long id, String firstname, String lastname,
                String emailId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
    }

    public User(String firstname, String lastname,
                String emailId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
