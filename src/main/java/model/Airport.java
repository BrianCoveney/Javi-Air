package model;

/**
 * Created by brian on 25/01/17.
 */
public enum Airport {

    CDG(AirportType.AIRPORT_LOCATION),
    STN(AirportType.AIRPORT_LOCATION),
    SBK(AirportType.AIRPORT_LOCATION),
    ORK(AirportType.AIRPORT_LOCATION),
    MAD(AirportType.AIRPORT_LOCATION),
    JER(AirportType.AIRPORT_LOCATION),
    AGP(AirportType.AIRPORT_LOCATION);

    private final AirportType airportType;

    Airport(AirportType airportType) { this.airportType = airportType; }


}
