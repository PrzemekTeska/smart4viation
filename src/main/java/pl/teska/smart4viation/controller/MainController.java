package pl.teska.smart4viation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.teska.smart4viation.service.FlightService;

@RestController
public class MainController {

    private FlightService flightService;

    @Autowired
    public MainController(FlightService flightService) {
        this.flightService = flightService;
    }


    @GetMapping("/weight/{flightNumber}/{date}")
    public String getWeight(@PathVariable int flightNumber, @PathVariable String date) {

        int cargoWeight = flightService.getCargoWeight(flightNumber, date);
        int baggageWeight = flightService.getBaggageWeight(flightNumber, date);

        return "Cargo weight in kg: " + cargoWeight +
                "\nBaggage weight in kg: " + baggageWeight +
                "\nTotal weight in kg: " + (cargoWeight + baggageWeight);

    }

    @GetMapping("/info/{IATA}/{date}")
    public String getInfo(@PathVariable String IATA, @PathVariable String date) {

        int numberOfFlightsDeparting = flightService.getNumberOfFlightsDeparting(IATA,date);
        int numberOfFlightsArriving = flightService.getNumberOfFlightsArriving(IATA,date);
        int piecesOfBaggageDeparting = flightService.getNumberOfBaggagesDeparting(IATA, date);
        int piecesOfBaggageArriving = flightService.getNumberOfBaggagesArriving(IATA,date);

        return "Number of flights departing: " + numberOfFlightsDeparting +
                "\nNumber of flights arriving: " + numberOfFlightsArriving +
                "\nPieces of baggage departing: " + piecesOfBaggageDeparting +
                "\nPieces of baggage arriving: " + piecesOfBaggageArriving;
    }
}
