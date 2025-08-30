package com.example.QuanLyCatToc.repository;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = ConnectDB.connectDB();
        if (conn != null) {
            System.out.println("Kết nối thành công với database!");
        } else {
            System.out.println("Kết nối thất bại. Kiểm tra lại URL, user hoặc password.");
        }
    }
}
