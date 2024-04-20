package ru.hogwarts.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

    public Faculty(String faculty, String color) {
    }


    public String getName() {
        return name;
    }

}




