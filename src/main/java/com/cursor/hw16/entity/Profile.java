package com.cursor.hw16.entity;

import com.cursor.hw16.model.Model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Profile implements Model {

    private int id;
    private String username;
    private String job_title;
    private String department;
    private String company;
    private String skill;
}
