package com.italobackend.todolistspringboot.service;

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
        return userRepository.save(user);
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }
}
