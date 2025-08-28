package com.example.quan_ly_cat_toc.model;

public class User {
    private String id; // Can cuoc cong dan
    private String fullName;
    private String phoneNumber;
    private String userName;
    private String password;
    private String role;

    public User() {

    }

    public User(String id, String fullName, String phoneNumber, String userName, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    // Get
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Set
    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // To String
    @Override
    public String toString() {
        return "Id: " + id + " - Full Name: " + fullName + " - Phone Number: " + phoneNumber + "";
    }

}
