package com.example.db_lab4.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class Scientist {
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate birthday;
    private String academicDegree;
    private String academicTitle;

    public Scientist(String lastName, String firstName, String patronymic, LocalDate birthday, String academicDegree, String academicTitle) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.academicDegree = academicDegree;
        this.academicTitle = academicTitle;
    }

}
