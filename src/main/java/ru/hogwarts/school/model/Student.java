package ru.hogwarts.school.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Student {
    private long id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;
    public Student(){
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



