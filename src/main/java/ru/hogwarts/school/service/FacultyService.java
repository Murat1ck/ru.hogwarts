package ru.hogwarts.school.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;
@AllArgsConstructor

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public Faculty read(Long id) {
        return facultyRepository.findById(id);
    }


    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long count = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (!faculties.containsKey(faculty.getId())) {
            return null;
        }
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}

