package pl.teska.smart4viation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.teska.smart4viation.model.Airfreight;
import pl.teska.smart4viation.model.Baggage;
import pl.teska.smart4viation.model.Cargo;
import pl.teska.smart4viation.model.Flight;
import pl.teska.smart4viation.repository.AirfreightRepo;
import pl.teska.smart4viation.repository.FlightRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImplementation implements FlightService {

    private FlightRepo flightRepo;
    private AirfreightRepo airfreightRepo;

    @Autowired
    public FlightServiceImplementation(FlightRepo flightRepo, AirfreightRepo airfreightRepo) {
        this.flightRepo = flightRepo;
        this.airfreightRepo = airfreightRepo;
    }

    @Override
    public int getCargoWeight(int flightNumber, String date) {
        Airfreight airfreight = null;
        for (Flight flight :
                flightRepo.findAll()) {
            if (flight.getDepartureDate().toString().substring(0, 10).equals(date.substring(0, 10))) {
                airfreight = airfreightRepo.getByFlight(flight);
            }

        }
        if (airfreight != null) {
            List<Cargo> cargoList = airfreight.getCargo();
            int overallWeightKg = 0;
            int overallWeightLbs = 0;

            for (Cargo cargo : cargoList
            ) {
                if (cargo.getWeightUnit().equals("kg")) overallWeightKg += cargo.getWeight();
                else overallWeightLbs += cargo.getWeight();
            }
            double overallWeight = overallWeightLbs * 0.45359237;
            overallWeight += overallWeightKg;
            return (int) overallWeight;
        }
        return 0;
    }

    @Override
    public int getBaggageWeight(int flightNumber, String date) {
        Airfreight airfreight = null;
        for (Flight flight :
                flightRepo.findAll()) {
            if (flight.getDepartureDate().toString().substring(0, 10).equals(date.substring(0, 10))) {
                airfreight = airfreightRepo.getByFlight(flight);
            }

        }
        if (airfreight != null) {
            List<Baggage> baggageList = airfreight.getBaggage();
            int overallWeightKg = 0;
            int overallWeightLbs = 0;

            for (Baggage baggage :
                    baggageList) {
                if (baggage.getWeightUnit().equals("kg")) overallWeightKg += baggage.getWeight();
                else overallWeightLbs += baggage.getWeight();
            }
            double overallWeight = overallWeightLbs * 0.45359237;
            overallWeight += overallWeightKg;
            return (int) overallWeight;
        }
        return 0;
    }

    @Override
    public int getNumberOfFlightsDeparting(String IATA, String date) {

        List<Flight> flightList = flightRepo.getAllByDepartureAirportIATACode(IATA);
        List<Flight> flightsWithDate = flightList.stream().filter(flight ->
                flight.getDepartureDate().toString().substring(0, 10).equals(date.substring(0, 10))).collect(Collectors.toList());

        return flightsWithDate.size();
    }

    @Override
    public int getNumberOfFlightsArriving(String IATA, String date) {
        List<Flight> flightList = flightRepo.getAllByArrivalAirportIATACode(IATA);
        List<Flight> flightsWithDate = flightList.stream().filter(flight ->
                flight.getDepartureDate().toString().substring(0, 10).equals(date.substring(0, 10))).collect(Collectors.toList());

        return flightsWithDate.size();
    }

    @Override
    public int getNumberOfBaggagesDeparting(String IATA, String date) {
        List<Flight> flightList = flightRepo.getAllByDepartureAirportIATACode(IATA);
        List<Flight> flightsWithDate = flightList.stream().filter(flight ->
                flight.getDepartureDate().toString().substring(0, 10).equals(date.substring(0, 10))).collect(Collectors.toList());

        int totalNumberOfPieces = 0;
        for (Flight flight :
                flightsWithDate) {
           totalNumberOfPieces += airfreightRepo.getByFlight(flight).getBaggage().get(0).getNumberOfPieces();
        }
        return totalNumberOfPieces;
    }

    @Override
    public int getNumberOfBaggagesArriving(String IATA, String date) {
        List<Flight> flightList = flightRepo.getAllByArrivalAirportIATACode(IATA);
        List<Flight> flightsWithDate = flightList.stream().filter(flight ->
                flight.getDepartureDate().toString().substring(0,10).equals(date.substring(0,10))).collect(Collectors.toList());

        int totalNumberOfPieces = 0;
        for (Flight flight :
                flightsWithDate) {
            totalNumberOfPieces += airfreightRepo.getByFlight(flight).getBaggage().get(0).getNumberOfPieces();
        }
        return totalNumberOfPieces;
    }


}
