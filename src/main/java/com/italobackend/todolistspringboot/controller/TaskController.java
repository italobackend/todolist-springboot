package com.italobackend.todolistspringboot.controller;

import com.italobackend.todolistspringboot.dtos.TaskRequestDTO;
import com.italobackend.todolistspringboot.entity.Task;
import com.italobackend.todolistspringboot.service.TaskService;
import com.italobackend.todolistspringboot.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService service) {
        this.taskService = service;
    }

    // GET - Listar usuários
    @GetMapping
    public ResponseEntity<List<Task>> listAllTasks() {
        return ResponseEntity.ok(taskService.listAllTasks());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskRequestDTO));
    }


}
