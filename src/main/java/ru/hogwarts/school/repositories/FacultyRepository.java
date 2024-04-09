package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;
import java.util.Collection;
import java.util.List;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Faculty get(long id);
    Collection<Faculty> findAllByColor(String color);
    List<Faculty> findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(String color, String name);
}
