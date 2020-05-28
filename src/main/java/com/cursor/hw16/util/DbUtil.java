package com.cursor.hw16.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dev_profiles_db";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    protected Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            System.out.println("Successfully connected to database.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            System.err.println("Connection ERROR!");
        }
        return connection;
    }
}