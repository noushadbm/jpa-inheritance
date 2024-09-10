package com.rayshan.jpa_inheritance.service;

import com.rayshan.jpa_inheritance.Repository.UserRepository;
import com.rayshan.jpa_inheritance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to save the user to the database
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Method to fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

