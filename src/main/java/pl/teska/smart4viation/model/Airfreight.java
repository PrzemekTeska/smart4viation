package pl.teska.smart4viation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airfreight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airfreightId;
    @OneToOne
    private Flight flight;

    @OneToMany(mappedBy = "airfreight")
    private List<Baggage> baggage = new ArrayList<>();

    @OneToMany(mappedBy = "airfreight")
    private List<Cargo> cargo = new ArrayList<>();

    public Airfreight() {
    }

    public long getAirfreightId() {
        return airfreightId;
    }

    public void setAirfreightId(long airfreightId) {
        this.airfreightId = airfreightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }
}
