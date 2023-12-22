package pl.school.languageschool.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String name_shortcut;
    private String description;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
