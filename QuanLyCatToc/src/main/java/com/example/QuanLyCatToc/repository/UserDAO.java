package com.example.QuanLyCatToc.repository;

import com.example.QuanLyCatToc.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Repository
public class UserDAO {

    public UserDAO() {
    }

    // Sửa user
    public boolean updateUser(User user) {
        String sql = "UPDATE user SET fullName=?, phoneNumber=?, userName=?, password=? WHERE id=?";
        try (Connection conn = ConnectDB.connectDB();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getPhoneNumber());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa user
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        try (Connection conn = ConnectDB.connectDB();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách user
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection conn = ConnectDB.connectDB();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("phoneNumber"),
                        rs.getString("userName"),
                        rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Add user / Register
    public boolean addUser(User user) {
        String sql = "INSERT INTO user (id, fullName, phoneNumber, userName, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.connectDB();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getPhoneNumber());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Login
    public User login(String username, String password) {
        String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
        try (Connection conn = ConnectDB.connectDB();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("fullName"),
                            rs.getString("phoneNumber"),
                            rs.getString("userName"),
                            rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Login failed
    }
}
