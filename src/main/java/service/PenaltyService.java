package service;

import connection.ConnectionManager;
import dao.PenaltyDAO;
import entity.Penalty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PenaltyService implements PenaltyDAO {

    private static final String ADD = "INSERT INTO penalty(type, amount) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM penalty WHERE id=?";
    private static final String UPDATE = "UPDATE penalty SET type=?, amount=? WHERE id=?";
    private static final String GET = "SELECT id, type, amount FROM penalty WHERE id=?";
    private static final String GET_ALL = "SELECT id, type, amount FROM penalty";

    @Override
    public void add(Penalty penalty) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, penalty.getType());
            statement.setInt(2,penalty.getAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Penalty getById(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Penalty penalty = new Penalty();
                penalty.setId(resultSet.getLong("id"));
                penalty.setType(resultSet.getString("type"));
                penalty.setAmount(resultSet.getInt("amount"));
                return penalty;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Penalty penalty) {
        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, penalty.getType());
            statement.setInt(2, penalty.getAmount());
            statement.setLong(3, penalty.getId());
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
    public List<Penalty> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<Penalty> res = new ArrayList<>();
            while (resultSet.next()) {
                Penalty penalty = new Penalty();
                penalty.setId(resultSet.getLong("id"));
                penalty.setType(resultSet.getString("type"));
                penalty.setAmount(resultSet.getInt("amount"));
                res.add(penalty);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
