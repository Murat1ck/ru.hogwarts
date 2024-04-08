package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    static List<Student> findByAgeBetween(Integer min, Integer max) {
        return StudentRepository.findByAgeBetween(min,max);
    }
    Collection<Student> findAllByAge(int age);

    List<Student> findByFacultyId(Long id);
}