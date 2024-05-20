package ru.hogwarts.school.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;
//@AllArgsConstructor
@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;
    private final StudentService studentService;

    public FacultyService(FacultyRepository facultyRepository, StudentService studentService) {
        this.facultyRepository = facultyRepository;
        this.studentService = studentService;
    }

    public Faculty findFaculty(long id) {
        logger.info("вызван метод findFaculty");

        return facultyRepository.findById(id).orElseThrow();
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("вызван метод editFaculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("вызван метод deleteFaculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {
        logger.info("вызван метод findByColor");

        return facultyRepository.findAllByColor(color);
    }

    public Faculty get(Long id) {
        logger.info("вызван метод get");
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty add(Faculty faculty) {
        logger.info("вызван метод add");
        return facultyRepository.save(faculty);
    }

    public Collection<Faculty> getByColor(String color) {
        logger.info("вызван метод getByColor");
        return facultyRepository.findAllByColor(color);
    }

    public List<Faculty> getByColorOrName(String param) {
        logger.info("вызван метод getByColorOrName");
        return facultyRepository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(param, param);
    }

    public List<Student> getStudents(Long id) {
        logger.info("вызван метод getStudents");
        return studentService.findByFacultyId(id);
    }

    public String getLongNameFaculty() {
        return facultyRepository.findAll()
                .stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .get();
    }
}

