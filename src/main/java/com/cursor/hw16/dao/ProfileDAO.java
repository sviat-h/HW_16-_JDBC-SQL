package com.cursor.hw16.dao;

import com.cursor.hw16.entity.Profile;

import java.sql.SQLException;
import java.util.List;

public interface ProfileDAO {

    void insert(Profile profile) throws SQLException;

    List<Profile> getAll() throws SQLException;

    Profile getById(int id) throws SQLException;

    void update(Profile profile) throws SQLException;

    void delete(int id) throws SQLException;
}
