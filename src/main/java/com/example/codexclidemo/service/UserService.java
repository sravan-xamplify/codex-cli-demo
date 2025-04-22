package com.example.codexclidemo.service;

import com.example.codexclidemo.model.User;
import com.example.codexclidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create or update a user.
     * @param user the user to save
     * @return saved user entity
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieve user by ID.
     * @param id user identifier
     * @return optional containing user if found
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Retrieve all users.
     * @return list of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Delete a user by ID.
     * @param id identifier of the user to delete
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}