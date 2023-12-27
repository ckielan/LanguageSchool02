package pl.school.languageschool.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Students {

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
//*************************************************************


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public LocalDateTime getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(LocalDateTime date_modified) {
        this.date_modified = date_modified;
    }
}
