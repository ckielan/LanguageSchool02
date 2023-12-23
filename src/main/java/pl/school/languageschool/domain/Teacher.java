package pl.school.languageschool.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 2, max = 100)
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "W polu można umieszczać tylko litery")
    private String firstName;

    @Size(min = 2, max = 200)
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "W polu można umieszczać tylko litery")
    private String lastName;

    @Size(max = 250)
    private String description;

    @DateTimeFormat
    private LocalDateTime date_created;
    @DateTimeFormat
    private LocalDateTime date_modified;

    @PrePersist
    public void prePersists(){
        date_created= LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        date_modified=LocalDateTime.now();
    }


}
