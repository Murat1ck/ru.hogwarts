package ru.hogwarts.school.controller;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("/by-age")
    public Collection<Student> getByAge(@RequestParam int age) {
        return studentService.getByAge(age);
    }

    @GetMapping("/all")
    public Collection<Student> getAll() {
        return studentService.findAll();
    }
    @GetMapping("/by-age-between")
    public List<Student> getByAgeBetween(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeBetween(min, max);
    }
    @GetMapping("/faculty-by-id")
    public Faculty getFaculty(@RequestParam long id) {
        return studentService.getFaculty(id);
    }
//    @PostMapping(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> uploadAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar) throws IOException {
//        if (avatar.getSize() > 1024 * 300) {
//            return ResponseEntity.badRequest().body("File is too big");
//        }
//
//        studentService.uploadAvatar(id, avatar);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping(value = "/{id}/avatar/preview")
//    public ResponseEntity<byte[]> downloadAvatar(@PathVariable Long id) {
//        Avatar avatar = studentService.findAvatar(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
//        headers.setContentLength(avatar.getData().length);
//
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
//    }
//
//    @GetMapping(value = "/{id}/avatar")
//    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
//        Avatar avatar = studentService.findAvatar(id);
//
//        Path path = Path.of(avatar.getFilePath());
//
//        try (InputStream is = Files.newInputStream(path);
//             OutputStream os = response.getOutputStream();) {
//            response.setStatus(200);
//            response.setContentType(avatar.getMediaType());
//            response.setContentLength((int) avatar.getFileSize());
//            is.transferTo(os);
//        }
//    }
//    @GetMapping("/count")
//    public Integer getCount(){
//        return studentService.getCount();
//    }
//    @GetMapping("/avg-age")
//    public Double getAvgAge(){
//        return studentService.getAvgAge();
//    }
//    @GetMapping("/last-five-student")
//    public List<Student> getLastFiveStudent() {
//        return studentService.getLastFiveStudent();
//    }
}
