package jlaat.kalakaverispring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catch")
public class Catch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fishId;

    private Long lakeId;

    private Long lureId;

    private double weight;

    public Catch() {
    }

    public Catch(Long fishId, Long lakeId, Long lureId, double weight) {
        this.fishId = fishId;
        this.lakeId = lakeId;
        this.lureId = lureId;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFishId() {
        return fishId;
    }

    public void setFishId(Long fishId) {
        this.fishId = fishId;
    }

    public Long getLakeId() {
        return lakeId;
    }

    public void setLakeId(Long lakeId) {
        this.lakeId = lakeId;
    }

    public Long getLureId() {
        return lureId;
    }

    public void setLureId(Long lureId) {
        this.lureId = lureId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
