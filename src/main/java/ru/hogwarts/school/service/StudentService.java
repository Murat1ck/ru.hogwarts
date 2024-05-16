package ru.hogwarts.school.service;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.AvatarRepository;
import ru.hogwarts.school.repositories.StudentRepository;
@Service
//@AllArgsConstructor
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Value("${avatars.dir.path}")
    private final String avatarsDir;
    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;
    public StudentService(@Value("${avatars.dir.path}")String avatarsDir, StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.avatarsDir = avatarsDir;
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }



    public Student findStudent(long id) {
        logger.info("Вызван метод findStudent");
        return studentRepository.findById(id).orElseThrow();
    }

    public Student editStudent(Student student) {
        logger.info("Вызван метод editStudent");
       return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Вызван метод deleteStudent");
        studentRepository.deleteById(id);
    }
    public Collection<Student> findByAge(int age) {
        logger.info("Вызван метод findByAge");
        return studentRepository.findAllByAge(age);
}
    public Student get(Long id) {
        logger.info("Вызван метод get");
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        logger.info("Вызван метод addStudent");
        return studentRepository.save(student);
    }


    public List<Student> findByFacultyId(Long facultyId) {
        logger.info("Вызван метод findByFacultyId");
        return studentRepository.findByFacultyId(facultyId);
    }

    public Collection<Student> getByAge(int age) {
        logger.info("Вызван метод getByAge");
        return studentRepository.findAllByAge(age);
    }




    public Collection<Student> findAll() {
        logger.info("Вызван метод findAll");
        return studentRepository.findAll();
    }

    public List<Student> findByAgeBetween(int min, int max) {
        logger.info("Вызван метод findByAgeBetween");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFaculty(long studentId) {
        logger.info("Вызван метод getFaculty");
        return studentRepository.findById(studentId).get().getFaculty();
    }
    public List<Student> findByFacultyId(long facultyId) {
        logger.info("Вызван метод findByFacultyId");
        return studentRepository.findByFacultyId(facultyId);
    }



    public Avatar findAvatar(long studentId) {
        logger.info("Вызван метод findAvatar");
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        logger.info("Вызван метод uploadAvatar");
        Student student = findStudent(studentId);

        Path filePath = Path.of(avatarsDir, studentId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        Avatar avatar = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(file.getBytes());

        avatarRepository.save(avatar);
    }

    private String getExtension(String fileName) {
        logger.info("Вызван метод getExtension");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
