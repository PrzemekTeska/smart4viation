package pl.teska.smart4viation.service;

public interface FlightService {

    int getCargoWeight(int flightNumber, String date);

    int getBaggageWeight(int flightNumber, String date);

    int getNumberOfFlightsDeparting(String IATA, String date);

    int getNumberOfFlightsArriving(String IATA, String date);

    int getNumberOfBaggagesDeparting(String IATA, String date);

    int getNumberOfBaggagesArriving(String IATA, String date);

}
