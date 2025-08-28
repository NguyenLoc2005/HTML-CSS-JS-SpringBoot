package com.example.quan_ly_cat_toc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection ConnectDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/quanlycattoc";
            String user = "root";
            String password = "2005";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("False connect: " + e.getMessage());
            return null;
        }
    }
}
