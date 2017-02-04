package model;

import helpers.Consts;

/**
 * Created by brian on 12/12/16.
 */
public class ChildFlight extends Flight implements IFlight {

    private double price;
    public double departPrice;
    public double returnPrice;



    public ChildFlight() {}

    public ChildFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                       String flightTime, String returnTime, String departDate, String returnDate) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime, departDate, returnDate);
        setPrice(price);
        this.departPrice = Consts.CHILD_PRICE;
        this.returnPrice = Consts.CHILD_PRICE;
        this.price = Consts.CHILD_PRICE * 2;

    }


    @Override
    public Double getDepartPrice() {
        return this.departPrice;
    }

    @Override
    public Double getReturnPrice() { return this.returnPrice; }

    @Override
    public double getPrice() {
        return this.price;
    }


    @Override
    public double setPriceSingle() {
        return this.departPrice = Consts.CHILD_PRICE;
    }


    @Override
    public double setPriceReturn() { return this.returnPrice = Consts.CHILD_PRICE; }



    @Override
    public String printChildReturnFlightDetails() {
        return "\tDepart: \t\t\t" + getOrigin() +" > "+ getDestination() +" = €"+ this.departPrice +
                "\n\tReturn: \t\t\t"+ getDestination() +" > "+ getOrigin() +" = €"+ this.returnPrice +
                "\n\tDepart Time: \t\t"+ getDepartTime();
    }


    @Override
    public String printChildSingleFlightDetails() {
        return "\tDepart: \t\t\t" + getOrigin() +" > "+ getDestination() +" = €"+ this.departPrice +
                "\n\tDepart Time: \t\t"+ getDepartTime();
    }




}