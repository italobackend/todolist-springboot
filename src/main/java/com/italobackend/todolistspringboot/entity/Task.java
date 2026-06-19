package com.italobackend.todolistspringboot.entity;

import com.italobackend.todolistspringboot.enums.Priority;
import jakarta.persistence.*;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;
    private boolean completed;
    private Timestamp created_at;
    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(Long id, String title, Priority priority, boolean completed, Timestamp created_at, LocalDate dueDate, User user) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = false;
        this.created_at = created_at;
        this.dueDate = dueDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public User getUser() {
        return user;
    }
}
