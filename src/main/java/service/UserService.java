package service;

import connection.ConnectionManager;
import dao.UserDAO;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO {

    private static final String ADD = "INSERT INTO user(phone_number, name, e_mail, date_of_birth, login, password, is_blocked) VALUES(?,?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String UPDATE = "UPDATE user SET phone_number=?, name=?, e_mail=?, date_of_birth=?, login=?, password=?, is_blocked=? WHERE id=?";
    private static final String GET = "SELECT id, phone_number, name, e_mail, date_of_birth, login, password, is_blocked FROM user WHERE id=?";
    private static final String GET_ALL = "SELECT id, phone_number, name, e_mail, date_of_birth, login, password, is_blocked FROM user";

    @Override
    public void add(User user) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, user.getPhoneNumber());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEMail());
            statement.setDate(4, user.getDateOfBirth());
            statement.setString(5, user.getLogin());
            statement.setString(6, user.getPassword());
            statement.setBoolean(7, user.getIsBlocked());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getById(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setEMail(resultSet.getString("e_mail"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setIsBlocked(resultSet.getBoolean("is_blocked"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getPhoneNumber());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEMail());
            statement.setDate(4, user.getDateOfBirth());
            statement.setString(5, user.getLogin());
            statement.setString(6, user.getPassword());
            statement.setBoolean(7, user.getIsBlocked());
            statement.setLong(8, user.getId());
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
    public List<User> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<User> res = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setName(resultSet.getString("name"));
                user.setEMail(resultSet.getString("e_mail"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setIsBlocked(resultSet.getBoolean("is_blocked"));
                res.add(user);
            }
            return res;

        } catch
        (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
