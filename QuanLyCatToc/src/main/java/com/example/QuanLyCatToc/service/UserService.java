package com.example.QuanLyCatToc.service;

import com.example.QuanLyCatToc.model.User;
import com.example.QuanLyCatToc.repository.UserDAO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

}
