package service;

import connection.ConnectionManager;
import dao.UserPenaltyDAO;
import entity.UserPenalty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPenaltyService implements UserPenaltyDAO {

    private static final String ADD = "INSERT INTO userPenalty(id_penalty_fk, id_user_fk, is_paid) VALUES(?,?,?)";
    private static final String DELETE = "DELETE FROM userPenalty WHERE id=?";
    private static final String UPDATE = "UPDATE userPenalty SET id_penalty_fk=?, id_user_fk=?, is_paid=? WHERE id=?";
    private static final String GET = "SELECT id, id_penalty_fk, id_user_fk, is_paid FROM userPenalty WHERE id=?";
    private static final String GET_ALL = "SELECT id, id_penalty_fk, id_user_fk, is_paid FROM userPenalty";

    @Override
    public void add(UserPenalty userPenalty) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setLong(1, userPenalty.getIdPenaltyFK());
            statement.setLong(2, userPenalty.getIdUserFK());
            statement.setBoolean(3, userPenalty.getIs_paid());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserPenalty getById(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UserPenalty userPenalty = new UserPenalty();
                userPenalty.setId(resultSet.getLong("id"));
                userPenalty.setIdPenaltyFK(resultSet.getLong("id_penalty_fk"));
                userPenalty.setIdUserFK(resultSet.getLong("id_user_fk"));
                userPenalty.setIs_paid(resultSet.getBoolean("is_paid"));
                return userPenalty;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(UserPenalty userPenalty) {
        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setLong(1, userPenalty.getIdPenaltyFK());
            statement.setLong(2, userPenalty.getIdUserFK());
            statement.setBoolean(3, userPenalty.getIs_paid());
            statement.setLong(4, userPenalty.getId());
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
    public List<UserPenalty> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<UserPenalty> res = new ArrayList<>();
            while (resultSet.next()) {
                UserPenalty userPenalty = new UserPenalty();
                userPenalty.setId(resultSet.getLong("id"));
                userPenalty.setIdPenaltyFK(resultSet.getLong("id_penalty_fk"));
                userPenalty.setIdUserFK(resultSet.getLong("id_user_fk"));
                userPenalty.setIs_paid(resultSet.getBoolean("is_paid"));
                res.add(userPenalty);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
