package com.cursor.hw16.model;

public enum ProfilesColumns {
    ID("id"),
    USERNAME("username"),
    JOB_TITLE("job_title"),
    DEPARTMENT("department"),
    COMPANY("company"),
    SKILL("skill");

    private String profileColumns;

    ProfilesColumns(String profileColumns) {
        this.profileColumns = profileColumns;
    }

    public String getProfileColumn() {
        return profileColumns;
    }
}
