package com.cursor.hw16.model;

public enum AccountsColumns {
    ID("id"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    CITY("city"),
    GENDER("gender"),
    USERNAME("username");

    private String accountsColumns;

    AccountsColumns(String accountsColumns) {
        this.accountsColumns = accountsColumns;
    }

    public String getAccountsColumn() {
        return accountsColumns;
    }
}
