package ru.hogwarts.school.service;

import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;
@AllArgsConstructor

@Service
public class FacultyService {
    @Autowired
    private final FacultyRepository facultyRepository;
    private final StudentService studentService;
    public Faculty findFaculty(long id) {
        return facultyRepository.getById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
    return facultyRepository.save(faculty);
    }

    public void  deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {

        return facultyRepository.findAllByColor(color);
    }

    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}

