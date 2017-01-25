package model;

/**
 * Created by brian on 25/01/17.
 */
public enum Airport {

    CDG(AirportType.NOT_OPERATING_ON_DATES),
    STN(AirportType.NOT_OPERATING_ON_DATES),
    SBK(AirportType.NOT_OPERATING_ON_DATES),

    ORK(AirportType.OPERATING_ON_ALL_DATES),
    MAD(AirportType.OPERATING_ON_ALL_DATES),
    JER(AirportType.OPERATING_ON_ALL_DATES),
    AGP(AirportType.OPERATING_ON_ALL_DATES);

    private final AirportType airportType;

    Airport(AirportType airportType) { this.airportType = airportType; }


}
