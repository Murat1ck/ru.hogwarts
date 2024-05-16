package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.AvatarRepository;
import ru.hogwarts.school.repositories.StudentRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
//@AllArgsConstructor
public class AvatarService {
    Logger logger = LoggerFactory.getLogger(AvatarService.class);
    @Value("${avatars.dir.path}")
    private final String avatarsDir;
    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;
    public  AvatarService(@Value("${avatars.dir.path}")String avatarsDir, StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.avatarsDir = avatarsDir;
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
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

    public Student findStudent(long id) {
        return studentRepository.getById(id);
    }


    public Page <Avatar> getWithPageAvatar(Integer page, Integer count) {
        logger.info("Вызван метод getWithPageAvatar");
        return avatarRepository.findAll(PageRequest.of(page-1, count));
    }

    private String getExtension(String fileName) {
        logger.info("Вызван метод getExtensions");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public Integer getCount(){
        logger.info("Вызван метод getCount");
        return studentRepository.getCount();
    }
    public Double getAvgAge(){
        logger.info("Вызван метод getAvgAge");
        return studentRepository.getAvgAge();
    }
    public List<Student> getLastFiveStudent(){
        logger.info("Вызван метод getLastFiveStudent");
        return studentRepository.getLastFiveStudent();
    }

}
