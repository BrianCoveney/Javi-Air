package model;

import java.util.ArrayList;

/**
 * Created by brian on 12/12/16.
 */
public class AdultFlight extends Flight {

    private double price;
    private ArrayList<Flight> flights;

    public AdultFlight() {}

    public AdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
        setPrice(price);
    }


    public static AdultFlight createFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime)  {
        return new AdultFlight(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
    }



    public ArrayList<Flight> getFlights() {return this.flights;}

    @Override
    public double setPriceSingle() {
        return this.price = price;
    }

    @Override
    public double setPriceReturn() {
        return this.price = price;
    }

}
