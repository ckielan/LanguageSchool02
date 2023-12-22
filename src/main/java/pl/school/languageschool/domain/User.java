package pl.school.languageschool.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;


@Table(name = "user")
@Entity
//@SQLInsert(sql = "CREATE TRIGGER before_insert_trigger BEFORE INSERT " +
//        "ON language_school.user FOR EACH ROW BEGIN SET ne = NOW(); END;")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{1,59}$",message = "Nazwa musi się składać z conajmniej dwóch znaków, zaczynać się literą")
    private String username;

    private String firstname;
    private String lastname;

    @Pattern(regexp = "^(?=.*[A-Za-z].*[A-Za-z])(?=.*[^A-Za-z0-9]).{8,}$", message = "Hasło musi mieć długość 8 znaków, zawierać cyfrę, znak specjalny")
    private String password;
    @Email
    private String email;

    private int enabled;
    @DateTimeFormat
    private LocalDate date_created;
    @DateTimeFormat
    @Column
    private LocalDate date_modified;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_group", joinColumns = @JoinColumn (name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<StudentGroup> groups;






    //********************************************************************
    @PrePersist
    public void prePersists(){
        date_created= LocalDate.now();
    }
    @PreUpdate
    public void preUpdate(){
        date_modified=LocalDate.now();
    }

    public Set<StudentGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<StudentGroup> groups) {
        this.groups = groups;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public LocalDate getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(LocalDate date_modified) {
        this.date_modified = date_modified;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}