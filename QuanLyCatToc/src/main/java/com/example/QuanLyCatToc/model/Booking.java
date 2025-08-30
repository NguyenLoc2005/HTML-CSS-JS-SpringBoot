package com.example.QuanLyCatToc.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int id;
    private int userId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String service;
    private String status;

    public Booking() {
    }

    public Booking(int id, int userId, LocalDate bookingDate, LocalTime bookingTime, String service, String status) {
        this.id = id;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.service = service;
        this.status = status;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
