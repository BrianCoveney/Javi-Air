package model;

/**
 * Created by brian on 02/02/17.
 */
public class Booking {

    private double dptPrice;
    private double rtnPrice;
    private double flightPrice;

    public Booking() {}


    public double getFlightPrice(Flight flight) {
        dptPrice = flight.getDepartPrice();
        rtnPrice = flight.getReturnPrice();
        flightPrice = dptPrice + rtnPrice;

        return flightPrice;
    }

}
