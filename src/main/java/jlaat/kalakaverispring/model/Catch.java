package jlaat.kalakaverispring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catch")
public class Catch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fishName;

    private String lakeName;

    private String lureName;

    private double weight;

    public Catch() {
    }

    public Catch(String fishName, String lakeName, String lureName, double weight) {
        this.fishName = fishName;
        this.lakeName = lakeName;
        this.lureName = lureName;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    public String getLureName() {
        return lureName;
    }

    public void setLureName(String lureName) {
        this.lureName = lureName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
