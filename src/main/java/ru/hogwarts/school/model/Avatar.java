package ru.hogwarts.school.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@EqualsAndHashCode
@Setter
@AllArgsConstructor
@ToString
@Entity

public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;

    private long fileSize;

    private String mediaType;

    private byte[] data;

    @OneToOne
    private Student student;
    public Avatar() {
    }



}

