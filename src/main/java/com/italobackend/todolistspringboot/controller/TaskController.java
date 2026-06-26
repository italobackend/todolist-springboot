package com.italobackend.todolistspringboot.controller;

import com.italobackend.todolistspringboot.dtos.TaskRequestDTO;
import com.italobackend.todolistspringboot.entity.Task;
import com.italobackend.todolistspringboot.service.TaskService;
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

    // POST - Criar tarefa
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(dto));
    }

    // DELETE - Deletar tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // PATCH - Atualizar nome
    @PatchMapping("/{id}/title")
    public ResponseEntity<Void> editTitle(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        taskService.editTitleTask(id, dto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
