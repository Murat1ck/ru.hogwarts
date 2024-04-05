package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
