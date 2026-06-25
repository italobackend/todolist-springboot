package com.italobackend.todolistspringboot.service;

import com.italobackend.todolistspringboot.dtos.UserRequestDTO;
import com.italobackend.todolistspringboot.entity.User;
import com.italobackend.todolistspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User userCreate(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use.");
        }

        return userRepository.save(user);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        User userFind = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userRepository.delete(userFind);
    }

    public void updateEmail(String email, UserRequestDTO userRequestDTO) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        if (userRepository.findByEmail(userRequestDTO.email()).isPresent()) {
            throw new RuntimeException("That email adress already exists.");
        }

        user.setEmail(userRequestDTO.email());
        userRepository.save(user);
    }

    public void updatePassword(String email, UserRequestDTO userRequestDTO) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email"));

        if (user.getPassword().equals(userRequestDTO.password())) {
            throw new RuntimeException("New password must be different from the current.");
        }

        user.setPassword(userRequestDTO.password());
        userRepository.save(user);
    }

    public void updateName(String email, UserRequestDTO userRequestDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email"));

        if (user.getName().equals(userRequestDTO.name())) {
            throw new RuntimeException("New name must be different from the current");
        }
        user.setName(userRequestDTO.name());
        userRepository.save(user);
    }
}
