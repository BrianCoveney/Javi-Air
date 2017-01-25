package model;

/**
 * Created by brian on 25/01/17.
 */
public interface IAirportType {

    abstract boolean selectedFlightsParisOrStansted(String origin, String destination);

    abstract boolean selectedFlightsStBrieucOrStansted(String origin, String destination);
}
