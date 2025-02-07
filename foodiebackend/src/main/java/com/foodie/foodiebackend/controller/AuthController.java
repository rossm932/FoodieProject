package com.foodie.foodiebackend.controller;

import com.foodie.foodiebackend.model.User;
import com.foodie.foodiebackend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return "Invalid request! Username and password must be provided.";
        }

        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser == null) {
            return "User not found!";
        }

        if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return "Login successful!";
        }

        return "Invalid credentials";
    }
}
