package com.example.codexclidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the new era";
    }

    /**
     * Root endpoint mapping to welcome message.
     */
    @GetMapping("/")
    public String root() {
        return "Welcome to the new era";
    }
}