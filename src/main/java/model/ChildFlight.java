package model;

import helpers.Consts;

/**
 * Created by brian on 12/12/16.
 */
public class ChildFlight extends Flight {

    private double price;

    public ChildFlight() {}

    public ChildFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
        setPrice(price);
    }

    @Override
    public double setPriceSingle() {
        return this.price = Consts.CHILD_PRICE;
    }

    @Override
    public double setPriceReturn() {
        return this.price = Consts.CHILD_PRICE * 2;
    }

}
