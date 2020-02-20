package com.cursor.hw16.service;

import com.cursor.hw16.entity.Account;
import com.cursor.hw16.model.Model;
import com.cursor.hw16.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService extends DbUtil implements Model {

    private Connection connection = getConnection();

    @Override
    public void insert(Model model) throws SQLException {
        Account account = new Account();

        String sql = "INSERT INTO accounts (id, first_name, last_name, city, gender, username) VALUES (?, ?, ?, ?, ?, ?) ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getFirst_name());
            preparedStatement.setString(3, account.getLast_name());
            preparedStatement.setString(4, account.getCity());
            preparedStatement.setString(5, account.getGender());
            preparedStatement.setString(6, account.getUsername());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Model> getAll() throws SQLException {

        List<Model> modelList = new ArrayList<>();

        String sql = "SELECT * FROM accounts";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Account account = new Account();

                account.setId(resultSet.getInt("id"));
                account.setFirst_name(resultSet.getString("first_name"));
                account.setLast_name(resultSet.getString("last_name"));
                account.setCity(resultSet.getString("city"));
                account.setGender(resultSet.getString("gender"));
                account.setUsername(resultSet.getString("username"));

                modelList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    @Override
    public Model getById(int id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM accounts WHERE id=?";

        Account account = new Account();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account.setId(resultSet.getInt("id"));
                account.setFirst_name(resultSet.getString("first_name"));
                account.setLast_name(resultSet.getString("last_name"));
                account.setCity(resultSet.getString("city"));
                account.setGender(resultSet.getString("gender"));
                account.setUsername(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return account;
    }

    @Override
    public void update(Model model) throws SQLException {

        Account account = new Account();

        String sql = "UPDATE accounts SET first_name=?, last_name=?, city=?, gender=?, username=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, account.getFirst_name());
            preparedStatement.setString(2, account.getLast_name());
            preparedStatement.setString(3, account.getCity());
            preparedStatement.setString(4, account.getGender());
            preparedStatement.setString(5, account.getUsername());
            preparedStatement.setInt(6, account.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM accounts WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
