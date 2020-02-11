package com.cursor.hw16.model;

public enum Tables {
    ACCOUNTS("accounts"),
    PROFILES("profiles");

    private String tables;

    Tables(String tables) {
        this.tables = tables;
    }

    public String getTable() {
        return tables;
    }
}