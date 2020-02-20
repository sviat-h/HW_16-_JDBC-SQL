package com.cursor.hw16.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Account {

    private int id;
    private String first_name;
    private String last_name;
    private String city;
    private String gender;
    private String username;
}
