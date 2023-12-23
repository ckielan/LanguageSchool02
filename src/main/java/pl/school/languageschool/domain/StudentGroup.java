package pl.school.languageschool.domain;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class  StudentGroup {

    public StudentGroup() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String name_shortcut;
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_shortcut() {
        return name_shortcut;
    }

    public void setName_shortcut(String name_shortcut) {
        this.name_shortcut = name_shortcut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
