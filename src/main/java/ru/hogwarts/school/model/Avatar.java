package ru.hogwarts.school.model;
import lombok.*;

import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
@Getter
@EqualsAndHashCode
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Avatar {
    @Id
    @GeneratedValue
    private Long id;

    private String filePath, mediaType;
    private long fileSize;

    @Lob
    private byte[] data;

    @OneToOne
    private Student student;

    public Avatar() {
    }

}

