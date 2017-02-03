package model;

/**
 * Created by brian on 19/01/17.
 */
public class FlightFactory {


    public static IFlight getInstance(Passenger passenger, String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                                      String flightTime, String returnTime, String departDate, String returnDate) {

        if (passenger == null) {
            return null;
        }

        else if (passenger.isPassengerInfant()) {
            return new InfantFlight();
        }

        else if (passenger.isPassengerAChild()) {

            return new ChildFlight(
                    origin, destination, deapartPrice, returnPrice,
                    price, flightTime, returnTime, departDate, returnDate
            );
        }

        else if (passenger.isPassengerOver18()) {
            return new AdultFlight(
                    origin, destination, deapartPrice, returnPrice,
                    price, flightTime, returnTime, departDate, returnDate
            );
        }

        return null;
    }

}
