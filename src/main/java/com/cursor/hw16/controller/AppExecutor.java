package com.cursor.hw16.controller;

import com.cursor.hw16.model.AccountsColumns;
import com.cursor.hw16.model.ProfilesColumns;
import com.cursor.hw16.model.Tables;
import com.cursor.hw16.util.DbUtil;

import java.sql.SQLException;

public class AppExecutor {
    private DbUtil db = DbUtil.getDb();

    private String tableAccount = Tables.ACCOUNTS.getTable();
    private String tableProfile = Tables.PROFILES.getTable();

    private String accountId = AccountsColumns.ID.getAccountsColumn();
    private String firstName = AccountsColumns.FIRST_NAME.getAccountsColumn();
    private String lastName = AccountsColumns.LAST_NAME.getAccountsColumn();
    private String city = AccountsColumns.CITY.getAccountsColumn();
    private String gender = AccountsColumns.GENDER.getAccountsColumn();
    private String accountUsername = AccountsColumns.USERNAME.getAccountsColumn();

    private String profileId = ProfilesColumns.ID.getProfileColumn();
    private String profileUsername = ProfilesColumns.USERNAME.getProfileColumn();
    private String jobTitle = ProfilesColumns.JOB_TITLE.getProfileColumn();
    private String department = ProfilesColumns.DEPARTMENT.getProfileColumn();
    private String company = ProfilesColumns.COMPANY.getProfileColumn();
    private String skill = ProfilesColumns.SKILL.getProfileColumn();

    public void runApp() {
        try {

            runOperationsWithProfilesTable();
//            runOperationsWithAccountsTable();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void runOperationsWithProfilesTable() throws SQLException, ClassNotFoundException {
        db.connect();
        db.showTables();
        db.showColumns(tableProfile);
//        db.select(tableProfile, profileId);
        db.insert(tableProfile, skill, 1001, "Kill");
//        db.delete(tableProfile, 1001);
//        db.update(tableProfile, skill, 1001, "Resurrect");
    }

    private void runOperationsWithAccountsTable() throws SQLException, ClassNotFoundException {
        db.connect();
        db.showTables();
        db.showColumns(tableAccount);
        db.select(tableAccount, accountId);
        db.insert(tableAccount, city, 1001, "Lviv");
        db.delete(tableAccount, 1001);
        db.update(tableAccount, city, 1001, "Kiev");
    }
}