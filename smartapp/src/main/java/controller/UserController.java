package com.project.smartapp.controller;

import com.project.smartapp.entity.User;
import com.project.smartapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Test API (to check controller working)
    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }

    // ✅ Register User API
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}