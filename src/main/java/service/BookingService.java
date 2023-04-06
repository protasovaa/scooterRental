package service;

import connection.ConnectionManager;
import dao.BookingDAO;
import entity.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingService implements BookingDAO {

    private static final String ADD = "INSERT INTO booking(id_scooter_fk, id_user_fk, time_of_booking, time_of_start, time_of_finish) VALUES(?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM booking WHERE id=?";
    private static final String UPDATE = "UPDATE booking SET id_scooter_fk=?, id_user_fk=?, time_of_booking=?, time_of_start=?, time_of_finish=? WHERE id=?";
    private static final String GET = "SELECT id, id_scooter_fk, id_user_fk, time_of_booking, time_of_start, time_of_finish FROM booking WHERE id=?";
    private static final String GET_ALL = "SELECT id, id_scooter_fk, id_user_fk, time_of_booking, time_of_start, time_of_finish FROM booking";

    @Override
    public void add(Booking booking) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setLong(1, booking.getIdScooterFK());
            statement.setLong(2, booking.getIdUserFK());
            statement.setTimestamp(3, booking.getTimeOfBooking());
            statement.setTimestamp(4, booking.getTimeOfStart());
            statement.setTimestamp(5, booking.getTimeOfFinish());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Booking getById(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Booking booking = new Booking();
                booking.setId(resultSet.getLong("id"));
                booking.setIdScooterFK(resultSet.getLong("id_scooter_fk"));
                booking.setIdUserFK(resultSet.getLong("id_user_fk"));
                booking.setTimeOfBooking(resultSet.getTimestamp("time_of_booking"));
                booking.setTimeOfStart(resultSet.getTimestamp("time_of_start"));
                booking.setTimeOfFinish(resultSet.getTimestamp("time_of_finish"));
                return booking;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking booking) {
        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setLong(1, booking.getIdScooterFK());
            statement.setLong(2, booking.getIdUserFK());
            statement.setTimestamp(3, booking.getTimeOfBooking());
            statement.setTimestamp(4, booking.getTimeOfStart());
            statement.setTimestamp(5, booking.getTimeOfFinish());
            statement.setLong(6, booking.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<Booking> res = new ArrayList<>();
            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setId(resultSet.getLong("id"));
                booking.setIdScooterFK(resultSet.getLong("id_scooter_fk"));
                booking.setIdScooterFK(resultSet.getLong("id_scooter_fk"));
                booking.setTimeOfBooking(resultSet.getTimestamp("time_of_booking"));
                booking.setTimeOfStart(resultSet.getTimestamp("type_of_start"));
                booking.setTimeOfFinish(resultSet.getTimestamp("type_of_finish"));
                res.add(booking);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
