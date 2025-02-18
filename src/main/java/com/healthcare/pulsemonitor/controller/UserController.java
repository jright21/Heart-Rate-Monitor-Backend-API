package com.healthcare.pulsemonitor.controller;

import com.healthcare.pulsemonitor.model.User;
import com.healthcare.pulsemonitor.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}
