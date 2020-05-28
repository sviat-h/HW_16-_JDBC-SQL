package com.cursor.hw16.entity;

import com.cursor.hw16.model.Model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Account implements Model {

    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String gender;
    private String username;
}
