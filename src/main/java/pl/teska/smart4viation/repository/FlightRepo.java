package pl.teska.smart4viation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teska.smart4viation.model.Flight;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    List<Flight> getAllByDepartureAirportIATACode(String IATA);

    List<Flight> getAllByArrivalAirportIATACode(String IATA);
}
