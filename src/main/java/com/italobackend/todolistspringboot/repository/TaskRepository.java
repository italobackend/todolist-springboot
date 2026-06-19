package com.italobackend.todolistspringboot.repository;

import com.italobackend.todolistspringboot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
