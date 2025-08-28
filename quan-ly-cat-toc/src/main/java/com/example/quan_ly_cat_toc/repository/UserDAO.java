package com.example.quan_ly_cat_toc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.quan_ly_cat_toc.model.User;

@Repository
public class UserDAO {

    public UserDAO() {

    }

    // Register
    public boolean Register(User user) {
        try {
            Connection conn = Connect.ConnectDB();
            if (conn == null) {
                System.out.println("Cant connect database");
                return false;
            }
            String checkSQL = "SELECT COUNT(*) FROM User WHERE userName=?";
            PreparedStatement stmt1 = conn.prepareStatement(checkSQL);
            stmt1.setString(1, user.getUserName());
            ResultSet rs1 = stmt1.executeQuery();

            if (rs1.next()) {
                int count = rs1.getInt(1);
                if (count > 0) {
                    System.out.println("User name exists");
                    return false;
                }
            }

            String sql = "INSERT INTO User(id,fullName,phoneNumber,userName,password,role) VALUES (?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getFullName());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getUserName());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getRole());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Register successly");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erorr register" + e.getMessage());
        }

        return false;
    }

    // Login
    public boolean Login(String userName, String password) {
        try {
            Connection conn = Connect.ConnectDB();
            if (conn == null) {
                System.out.println("Cant connect database");
                return false;
            }
            String sql = "SELECT * FROM User WHERE userName=? AND password = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successly");
                return true;
            } else {
                System.out.println("User name or Password dont correct");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error login" + e.getMessage());
        }

        return false;
    }

}
