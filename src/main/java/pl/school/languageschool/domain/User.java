package pl.school.languageschool.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.SQLInsert;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;
import java.util.Set;


@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{1,59}$",message = "Nazwa musi się składać z conajmniej dwóch znaków, zaczynać się literą")
    private String username;



    @Pattern(regexp = "^(?=.*[A-Za-z].*[A-Za-z])(?=.*[^A-Za-z0-9]).{8,}$", message = "Hasło musi mieć długość 8 znaków, zawierać cyfrę, znak specjalny")
    private String password;

    private int enabled;
    @DateTimeFormat
    @Column
    private Date date_created;
    @DateTimeFormat
    @Column
    private Date date_modified;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade =CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name="user_details_id",unique = true)
    private UserDetails details;







    //********************************************************************


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

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}