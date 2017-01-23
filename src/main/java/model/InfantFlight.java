package model;

import helpers.Consts;

import java.time.LocalDate;

/**
 * Created by brian on 16/12/16.
 */
public class InfantFlight extends Flight  {

    private double price;
    private LocalDate dateOfBirth;

    public InfantFlight() {}

    public InfantFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
        setPrice(price);
    }

    @Override
    public double setPriceSingle() {
        return this.price = Consts.INFANT_PRICE;
    }

    @Override
    public double setPriceReturn() {
        return this.price = Consts.INFANT_PRICE;
    }


    @Override
    public String speak() {
        return "Infant Flight";
    }


    @Override
    public LocalDate getDateOfBirth(Passenger passenger) {
        dateOfBirth = passenger.getDateOfBirth();
        return dateOfBirth;
    }

}
