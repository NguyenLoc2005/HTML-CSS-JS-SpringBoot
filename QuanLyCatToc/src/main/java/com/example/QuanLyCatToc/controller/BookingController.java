package com.example.QuanLyCatToc.controller;

import com.example.QuanLyCatToc.model.Booking;
import com.example.QuanLyCatToc.service.BookingService;
import com.example.QuanLyCatToc.repository.ConnectDB;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController() {
        Connection conn = ConnectDB.connectDB();
        this.bookingService = new BookingService(conn);
    }

    // Thêm booking mới
    @PostMapping
    public boolean addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    // Cập nhật booking
    @PutMapping
    public boolean updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    // Xóa booking theo id
    @DeleteMapping("/{id}")
    public boolean deleteBooking(@PathVariable int id) {
        return bookingService.deleteBooking(id);
    }

    // Lấy tất cả booking
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Lấy booking theo id
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }
}
