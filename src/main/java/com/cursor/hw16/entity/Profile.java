package com.cursor.hw16.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Profile {

    private int id;
    private String username;
    private String job_title;
    private String department;
    private String company;
    private String skill;
}
