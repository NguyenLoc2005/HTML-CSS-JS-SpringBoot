package com.example.quan_ly_cat_toc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quan_ly_cat_toc.DTO.LoginRequest;
import com.example.quan_ly_cat_toc.model.User;
import com.example.quan_ly_cat_toc.repository.UserDAO;

@RestController
@RequestMapping("/HungTheBlues")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/test")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return userDAO.Login(loginRequest.getUserName(), loginRequest.getPassword()) ? "Login successly"
                : "Login false";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userDAO.Register(user) ? "Register succesly" : "Register false";
    }
}
