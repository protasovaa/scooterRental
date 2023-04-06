package service;

import connection.ConnectionManager;
import dao.ScooterDAO;
import entity.Scooter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScooterService implements ScooterDAO {

    private static final String ADD = "INSERT INTO scooter(location, is_blocked, price_for_min) VALUES(?,?,?)";
    private static final String DELETE = "DELETE FROM scooter WHERE id=?";
    private static final String UPDATE = "UPDATE scooter SET location=?, is_blocked=?, price_for_min=? WHERE id=?";
    private static final String GET = "SELECT id, location, is_blocked, price_for_min FROM scooter WHERE id=?";
    private static final String GET_ALL = "SELECT id, location, is_blocked, price_for_min FROM scooter";

    @Override
    public void add(Scooter scooter) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, scooter.getLocation());
            statement.setBoolean(2, scooter.getIs_blocked());
            statement.setDouble(3, scooter.getPrice_for_min());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Scooter getById(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Scooter scooter = new Scooter();
                scooter.setId(resultSet.getLong("id"));
                scooter.setLocation(resultSet.getString("location"));
                scooter.setIs_blocked(resultSet.getBoolean("is_blocked"));
                scooter.setPrice_for_min(resultSet.getDouble("price_for_min"));
                return scooter;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Scooter scooter) {
        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, scooter.getLocation());
            statement.setBoolean(2, scooter.getIs_blocked());
            statement.setDouble(3, scooter.getPrice_for_min());
            statement.setLong(4, scooter.getId());
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
    public List<Scooter> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<Scooter> res = new ArrayList<>();
            while (resultSet.next()) {
                Scooter scooter = new Scooter();
                scooter.setId(resultSet.getLong("id"));
                scooter.setLocation(resultSet.getString("location"));
                scooter.setIs_blocked(resultSet.getBoolean("is_blocked"));
                scooter.setPrice_for_min(resultSet.getDouble("price_for_min"));
                res.add(scooter);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
