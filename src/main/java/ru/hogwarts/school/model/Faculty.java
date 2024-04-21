package ru.hogwarts.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@EqualsAndHashCode
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Faculty {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, color;

    public Faculty() {
    }

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    private List<Student> students;
    public String getName() {
        return name;
    }

}




