package jlaat.kalakaverispring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lake")
public class Lake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    public Lake(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Lake(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Lake() {

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
