package ru.hogwarts.school.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Entity

public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;
    public Student(){
    }

    public Student(String student, int i) {
        this.name = student;
        this.age = i;
    }

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId(){
        return id;
    }



    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}



