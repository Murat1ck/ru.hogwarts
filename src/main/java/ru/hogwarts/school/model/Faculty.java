package ru.hogwarts.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;
@Getter
@EqualsAndHashCode
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Faculty {
   @Id
   @GeneratedValue
    private long id;
    private String name, color;

    public Faculty() {
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}




