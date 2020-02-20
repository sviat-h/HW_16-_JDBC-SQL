package com.cursor.hw16.controller;

import com.cursor.hw16.entity.Account;
import com.cursor.hw16.entity.Profile;
import com.cursor.hw16.service.AccountService;
import com.cursor.hw16.service.ProfileService;

import java.sql.SQLException;
import java.util.List;

public class AppExecutor {

    private AccountService accountService = new AccountService();
    private ProfileService profileService = new ProfileService();
    private Account account = new Account();
    private Profile profile = new Profile();

    public void runApp() {

        try {

//            addAccountToTable(1001,"Sviatoslav", "Hrynyk", "Warszawa", "Male", "Sviat-h");
//            showAllAccounts();
//            updateAccount(1001, "Blah", "Blah", "Blah", "Blah", "Blah");
//            deleteAccountById(1001);
            findAccountById(1001);

//            addProfileToTable(1001, "Sviat-h", "Developer", "Engineering", "Cursor", "Java");
//            showAllProfiles();
//            updateProfile(1, "Blah", "Blah", "Blah", "Blah", "Blah");
//            deleteAccountById(1001);
            findProfileById(1001);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAccountToTable(int id, String firstName, String lastName, String city, String gender, String username) throws SQLException {

        account.setId(id);
        account.setFirst_name(firstName);
        account.setLast_name(lastName);
        account.setCity(city);
        account.setGender(gender);
        account.setUsername(username);

        accountService.insert(account);
    }

    private void showAllAccounts() throws SQLException {

        List<Account> accountList = accountService.getAll();

        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    private void findAccountById(int id) throws SQLException {
        System.out.println(accountService.getById(id));
    }

    private void updateAccount(int id, String firstName, String lastName, String city, String gender, String username) throws SQLException {
        Account account = new Account();

        account.setId(id);
        account.setFirst_name(firstName);
        account.setLast_name(lastName);
        account.setCity(city);
        account.setGender(gender);
        account.setUsername(username);

        accountService.update(account);
    }

    private void deleteAccountById(int id) throws SQLException {
        accountService.delete(id);
    }


    private void addProfileToTable(int id, String username, String jobTitle, String department, String company, String skill) throws SQLException {

        profile.setId(id);
        profile.setUsername(username);
        profile.setJob_title(jobTitle);
        profile.setDepartment(department);
        profile.setCompany(company);
        profile.setSkill(skill);

        profileService.insert(profile);
    }

    private void showAllProfiles() throws SQLException {

        List<Profile> profileList = profileService.getAll();

        for (Profile profile : profileList) {
            System.out.println(profile);
        }
    }

    private void findProfileById(int id) throws SQLException {
        System.out.println(profileService.getById(id));
    }

    private void updateProfile(int id, String username, String jobTitle, String department, String company, String skill) throws SQLException {
        Account account = new Account();

        profile.setId(id);
        profile.setUsername(username);
        profile.setJob_title(jobTitle);
        profile.setDepartment(department);
        profile.setCompany(company);
        profile.setSkill(skill);

        profileService.update(profile);
    }

    private void deleteProfileById(int id) throws SQLException {
        profileService.delete(id);
    }
}