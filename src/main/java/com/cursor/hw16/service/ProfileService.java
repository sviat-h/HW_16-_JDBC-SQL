package com.cursor.hw16.service;

import com.cursor.hw16.entity.Profile;
import com.cursor.hw16.model.Model;
import com.cursor.hw16.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileService extends DbUtil implements Model {

    private Connection connection = getConnection();

    @Override
    public void insert(Model model) throws SQLException {
        Profile profile = new Profile();

        String sql = "INSERT INTO profiles (id, username, job_title, department, company, skill) VALUES (?, ?, ?, ?, ?, ?) ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, profile.getId());
            preparedStatement.setString(2, profile.getUsername());
            preparedStatement.setString(3, profile.getJobTitle());
            preparedStatement.setString(4, profile.getDepartment());
            preparedStatement.setString(5, profile.getCompany());
            preparedStatement.setString(6, profile.getSkill());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Model> getAll() throws SQLException {

        List<Model> modelList = new ArrayList<>();

        String sql = "SELECT * FROM profiles";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Profile profile = new Profile();

                profile.setId(resultSet.getInt("id"));
                profile.setUsername(resultSet.getString("username"));
                profile.setJobTitle(resultSet.getString("job_title"));
                profile.setDepartment(resultSet.getString("department"));
                profile.setCompany(resultSet.getString("company"));
                profile.setSkill(resultSet.getString("skill"));

                modelList.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    @Override
    public Profile getById(int id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM profiles WHERE id=?";

        Profile profile = new Profile();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                profile.setId(resultSet.getInt("id"));
                profile.setUsername(resultSet.getString("username"));
                profile.setJobTitle(resultSet.getString("job_title"));
                profile.setDepartment(resultSet.getString("department"));
                profile.setCompany(resultSet.getString("company"));
                profile.setSkill(resultSet.getString("skill"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return profile;
    }

    @Override
    public void update(Model model) throws SQLException {

        Profile profile = new Profile();

        String sql = "UPDATE profiles SET username=?, job_title=?, department=?, company=?, skill=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, profile.getUsername());
            preparedStatement.setString(2, profile.getJobTitle());
            preparedStatement.setString(3, profile.getDepartment());
            preparedStatement.setString(4, profile.getCompany());
            preparedStatement.setString(5, profile.getSkill());
            preparedStatement.setInt(6, profile.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM profiles WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
