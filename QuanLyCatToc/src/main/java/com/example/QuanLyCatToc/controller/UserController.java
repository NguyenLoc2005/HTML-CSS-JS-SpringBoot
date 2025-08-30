package com.example.QuanLyCatToc.controller;

import com.example.QuanLyCatToc.model.User;
import com.example.QuanLyCatToc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        User user = userService.login(username, password);
        if (user != null) {
            return "Login successful! Welcome " + user.getFullName();
        } else {
            return "Invalid username or password!";
        }
    }
}
