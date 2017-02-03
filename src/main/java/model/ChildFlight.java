package model;

import helpers.Consts;

import java.time.LocalDate;

/**
 * Created by brian on 12/12/16.
 */
public class ChildFlight extends Flight implements IFlight {

    private double price;
    private LocalDate dateOfBirth;
    public double departPrice;


    public ChildFlight() {}

    public ChildFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                       String flightTime, String returnTime, String departDate, String returnDate) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime, departDate, returnDate);
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


    @Override
    public String speak() {
        return "Child Flight";
    }



    @Override
    public void setPrice(Double price) {
        this.price = Consts.CHILD_PRICE * 2;
    }


    @Override
    public LocalDate getDateOfBirth(Passenger passenger) {
        dateOfBirth = passenger.getDateOfBirth();
        return dateOfBirth;
    }



}