package com.italobackend.todolistspringboot.dtos;

import com.italobackend.todolistspringboot.enums.Priority;

import java.time.LocalDate;

public record TaskRequestDTO(String title, Priority priority, boolean completed, LocalDate dueDate) {
}
