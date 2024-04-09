package ru.hogwarts.school.service;

import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;
@AllArgsConstructor

@Service
public class FacultyService {
    //public FacultyService(FacultyRepository facultyRepository, StudentService studentService) {
    //    this.facultyRepository = facultyRepository;
       // this.studentService = studentService;
   // }

    @Autowired
    private final FacultyRepository facultyRepository;
    private final StudentService studentService;

    public Faculty findFaculty(long id) {
        return facultyRepository.get(id);
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
    public Faculty get(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Collection<Faculty> getByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

    public List<Faculty> getByColorOrName(String param) {
        return facultyRepository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(param, param);
    }

    public List<Student> getStudents(Long id) {
        return studentService.findByFacultyId(id);
    }
}

