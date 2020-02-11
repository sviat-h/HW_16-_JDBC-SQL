package com.cursor.hw16.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class DbUtil {
    private static DbUtil instance;
    private static final String URL = "jdbc:postgresql://localhost:5432/dev_profiles_db";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private Connection connection;

    private DbUtil() {
    }

    public static DbUtil getDb() {
        if (Objects.isNull(instance)) {
            instance = new DbUtil();
        }
        return instance;
    }

    public void connect() throws SQLException, ClassNotFoundException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Class.forName(DRIVER);
    }

    public void showTables() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM pg_catalog.pg_tables " +
                "WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema';");
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nHere are your tables:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
    }

    public void showColumns(String tableName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT column_name FROM information_schema.columns " +
                "WHERE TABLE_NAME = '" + tableName + "';");
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nHere are columns of table " + tableName + ":");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }

    public void select(String nameOfTable, String nameOfColumn) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT " + nameOfColumn + " FROM " + nameOfTable);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nColumn " + nameOfColumn + ":");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(nameOfColumn));
        }
    }

    public void insert(String nameOfTable, String nameOfColumn, Integer id, String addValue) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO " + nameOfTable + " (id," + nameOfColumn + ") " +
                    "VALUES ('" + id + "','" + addValue + "');");

            int resultSet = statement.executeUpdate();

            System.out.println("\nYou are successfully entered - " + addValue + ", in the table - " + nameOfTable + ", with id - " + id);

        } catch (SQLException e) {
            System.err.println("\nError: Key (id)=(" + id + ") already exists");
        }
    }

    public void delete(String nameOfTable, Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM " + nameOfTable + " " +
                "WHERE id = " + id + ";");

        int resultSet = statement.executeUpdate();

        System.out.println("\nYou are successfully delete row in table - " + nameOfTable + ", with id - " + id);
    }

    public void update(String nameOfTable, String nameOfColumn, Integer id, String setValue) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE " + nameOfTable + " " +
                "SET " + nameOfColumn + " = '" + setValue + "' WHERE id = " + id + ";");

        int resultSet = statement.executeUpdate();

        System.out.println("\nYou are successfully update - " + setValue + ", in the table - " + nameOfTable + ", with id - " + id);
    }
}