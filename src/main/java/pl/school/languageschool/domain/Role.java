package pl.school.languageschool.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String name_shortcut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
