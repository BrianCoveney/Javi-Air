package model;

/**
 * Created by brian on 25/01/17.
 */
public interface IAirportType {

    boolean selectedFlightsParisOrStansted(String origin, String destination);

    boolean selectedFlightsStBrieucOrStansted(String origin, String destination);

    double flightSelection(String dptFlight, String rtnFlight);

}
