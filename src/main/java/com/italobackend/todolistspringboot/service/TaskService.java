package com.italobackend.todolistspringboot.service;

import com.italobackend.todolistspringboot.dtos.TaskRequestDTO;
import com.italobackend.todolistspringboot.entity.Task;
import com.italobackend.todolistspringboot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskRequestDTO dto) {
        Task task = new Task();

        task.setTitle(dto.title());
        task.setPriority(dto.priority());
        task.setDueDate(dto.dueDate());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void editTitleTask(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(dto.title());
        taskRepository.save(task);
    }

    public void editPriority(Long id, TaskRequestDTO dto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setPriority(dto.priority());
        taskRepository.save(task);
    }

    public void changeStatus(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(dto.completed());
        taskRepository.save(task);
    }

    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }
}
