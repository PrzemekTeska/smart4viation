package pl.teska.smart4viation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teska.smart4viation.model.Airfreight;
import pl.teska.smart4viation.model.Flight;

@Repository
public interface AirfreightRepo extends JpaRepository<Airfreight, Long> {

    Airfreight getByFlight(Flight flight);
}
