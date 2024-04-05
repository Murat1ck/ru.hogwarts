package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;


import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Faculty get(long id);

      List<Faculty> findAllByColor(String color);
    List<Faculty> findByColor(String color, String name);
}
