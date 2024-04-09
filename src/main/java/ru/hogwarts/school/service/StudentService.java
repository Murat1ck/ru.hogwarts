package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static java.lang.reflect.Array.get;

@Service
@AllArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

  

    public Student findStudent(long id) {
        return studentRepository.getById(id);
    }

    public Student editStudent(Student student) {
       return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
    public Collection<Student> findByAge(int age) {

        return studentRepository.findAllByAge(age);
}
    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    public List<Student> findByFacultyId(Long facultyId) {
        return studentRepository.findByFacultyId(facultyId);
    }

    public Collection<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);
    }




    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFaculty(long studentId) {
        return studentRepository.findById(studentId).get().getFaculty();
    }
    public List<Student> findByFacultyId(long facultyId) {
        return studentRepository.findByFacultyId(facultyId);
    }
}
