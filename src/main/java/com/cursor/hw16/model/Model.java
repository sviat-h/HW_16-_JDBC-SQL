package com.cursor.hw16.model;

import java.sql.SQLException;
import java.util.List;

public interface Model {
    default void insert(Model model) throws SQLException {
    }

    default List<Model> getAll() throws SQLException {
        return null;
    }

    default Model getById(int id) throws SQLException {
        return null;
    }

    default void update(Model model) throws SQLException {

    }

    default void delete(int id) throws SQLException {

    }

}
