package com.example.codexclidemo.controller;

import com.example.codexclidemo.model.User;
import com.example.codexclidemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for User operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get a user by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new user.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = userService.saveUser(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Update an existing user (full update).
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {
        return userService.getUserById(id)
                .map(existing -> {
                    existing.setName(user.getName());
                    existing.setEmail(user.getEmail());
                    User updated = userService.saveUser(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Partially update a user.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return userService.getUserById(id)
                .map(existing -> {
                    if (updates.containsKey("name")) {
                        existing.setName((String) updates.get("name"));
                    }
                    if (updates.containsKey("email")) {
                        existing.setEmail((String) updates.get("email"));
                    }
                    User updated = userService.saveUser(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete a user by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(existing -> {
                    userService.deleteUser(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}