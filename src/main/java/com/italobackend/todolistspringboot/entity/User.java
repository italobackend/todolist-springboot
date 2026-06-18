package com.italobackend.todolistspringboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Email
    private String email;
    private String password;
    @Column(name = "created_at")
    private Timestamp createdAt;

    public User() {
    }

    public User(Long id, Timestamp createdAt, String password, String email, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
