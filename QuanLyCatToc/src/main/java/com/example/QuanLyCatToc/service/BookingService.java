package com.example.QuanLyCatToc.service;

import com.example.QuanLyCatToc.model.Booking;
import com.example.QuanLyCatToc.repository.BookingDAO;

import java.sql.Connection;
import java.util.List;

public class BookingService {

    private BookingDAO bookingDAO;

    // Constructor, truyền connection vào DAO
    public BookingService(Connection conn) {
        this.bookingDAO = new BookingDAO(conn);
    }

    // Thêm booking mới
    public boolean addBooking(Booking booking) {
        // Có thể thêm validate, ví dụ: thời gian không trùng lịch
        if (booking.getBookingDate() == null || booking.getBookingTime() == null) {
            return false;
        }
        return bookingDAO.addBooking(booking);
    }

    // Cập nhật booking
    public boolean updateBooking(Booking booking) {
        // Validate trước khi cập nhật
        if (booking.getId() <= 0)
            return false;
        return bookingDAO.updateBooking(booking);
    }

    // Xoá booking theo id
    public boolean deleteBooking(int id) {
        if (id <= 0)
            return false;
        return bookingDAO.deleteBooking(id);
    }

    // Lấy tất cả booking
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    // Lấy booking theo id
    public Booking getBookingById(int id) {
        if (id <= 0)
            return null;
        return bookingDAO.getBookingById(id);
    }
}
