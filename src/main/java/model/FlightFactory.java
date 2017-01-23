package model;

/**
 * Created by brian on 19/01/17.
 */
public class FlightFactory {


    public static IFlight getFlightType(Passenger passenger) {

        if(passenger == null) {
            return null;
        }
        else if(passenger.isPassengerInfant()) {
            System.out.println("Infant Flight");
            return new InfantFlight();
        }
        else if(passenger.isPassengerAChild()) {
            System.out.println("Child Flight");
            return new ChildFlight();
        }
        else if(passenger.isPassengerOver18()) {
            System.out.println("Adult Flight");
            return new AdultFlight();
        }

        return null;
    }

}
