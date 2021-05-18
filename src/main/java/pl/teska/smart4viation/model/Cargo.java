package pl.teska.smart4viation.model;

import javax.persistence.*;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int weight;
    private String weightUnit;
    private int numberOfPieces;
    @ManyToOne(fetch = FetchType.LAZY)
    private Airfreight airfreight;


    public Cargo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public Airfreight getAirfreight() {
        return airfreight;
    }

    public void setAirfreight(Airfreight airfreight) {
        this.airfreight = airfreight;
    }
}
