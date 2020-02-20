package com.cursor.hw16.dao;

import com.cursor.hw16.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    void insert(Account account) throws SQLException;

    List<Account> getAll() throws SQLException;

    Account getById(int id) throws SQLException;

    void update(Account account) throws SQLException;

    void delete(int id) throws SQLException;
}
