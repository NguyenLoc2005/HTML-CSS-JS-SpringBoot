package com.example.QuanLyCatToc.repository;

import com.example.QuanLyCatToc.model.Booking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private Connection conn;

    public BookingDAO(Connection conn) {
        this.conn = conn;
    }

    // Thêm booking
    public boolean addBooking(Booking b) {
        String sql = "INSERT INTO Booking (user_id, booking_date, booking_time, service, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, b.getUserId());
            ps.setDate(2, Date.valueOf(b.getBookingDate()));
            ps.setTime(3, Time.valueOf(b.getBookingTime()));
            ps.setString(4, b.getService());
            ps.setString(5, b.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật booking
    public boolean updateBooking(Booking b) {
        String sql = "UPDATE Booking SET booking_date=?, booking_time=?, service=?, status=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(b.getBookingDate()));
            ps.setTime(2, Time.valueOf(b.getBookingTime()));
            ps.setString(3, b.getService());
            ps.setString(4, b.getStatus());
            ps.setInt(5, b.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xoá booking theo id
    public boolean deleteBooking(int id) {
        String sql = "DELETE FROM Booking WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy tất cả booking
    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getInt("id"));
                b.setUserId(rs.getInt("user_id"));
                b.setBookingDate(rs.getDate("booking_date").toLocalDate());
                b.setBookingTime(rs.getTime("booking_time").toLocalTime());
                b.setService(rs.getString("service"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy booking theo id
    public Booking getBookingById(int id) {
        String sql = "SELECT * FROM Booking WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getInt("id"));
                b.setUserId(rs.getInt("user_id"));
                b.setBookingDate(rs.getDate("booking_date").toLocalDate());
                b.setBookingTime(rs.getTime("booking_time").toLocalTime());
                b.setService(rs.getString("service"));
                b.setStatus(rs.getString("status"));
                return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
