package model;

import helpers.Consts;

/**
 * Created by brian on 16/12/16.
 */
public class InfantFlight extends Flight {

    private double price;

    public InfantFlight() {}

    public InfantFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
        setPrice(price);
    }


    public double setInfantPrice() {
        return this.price = Consts.INFANT_PRICE;
    }

    public double setTotalInfantPrice() {
        return this.price = Consts.INFANT_PRICE;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
}
