package jlaat.kalakaverispring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catch")
public class Catch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fish fish;

    @ManyToOne
    private Lake lake;

    @ManyToOne
    private Lure lure;

    public Catch(Fish fish, Lake lake, Lure lure) {
        this.fish = fish;
        this.lake = lake;
        this.lure = lure;
    }

    public Catch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        this.lake = lake;
    }

    public Lure getLure() {
        return lure;
    }

    public void setLure(Lure lure) {
        this.lure = lure;
    }
}
