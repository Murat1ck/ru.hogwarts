package ru.hogwarts.school.model;

import lombok.*;

import java.util.Objects;
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Student {
    private long id;
    private String name;
    private int age;
    public Student(){

    }


}



