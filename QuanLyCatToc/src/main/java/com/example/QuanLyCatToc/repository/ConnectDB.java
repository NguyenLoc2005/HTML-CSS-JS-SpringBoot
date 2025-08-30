package com.example.QuanLyCatToc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection connectDB() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/QuanLyCatToc";
            String user = "root";
            String password = "2005";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
