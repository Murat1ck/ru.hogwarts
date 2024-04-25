package ru.hogwarts.school.model;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
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

