package com.example.quan_ly_cat_toc.DTO;

public class LoginRequest {
    private String userName;
    private String password;

    public LoginRequest() {

    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
