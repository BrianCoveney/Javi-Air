package model;

import java.time.LocalDate;

/**
 * Created by brian on 12/12/16.
 */
public class AdultFlight extends Flight{


    private double price;
    private LocalDate dateOfBirth;


    public AdultFlight() {}

    public AdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                       String flightTime, String returnTime) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
        setPrice(price);
    }

    @Override
    public double setPriceSingle() {
        return this.price = price;
    }

    @Override
    public double setPriceReturn() {
        return this.price = price;
    }

    public static AdultFlight createAdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime)  {
        return new AdultFlight(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
    }



    @Override
    public String speak() {
        return "Adult Flight";
    }

    @Override
    public LocalDate getDateOfBirth(Passenger passenger) {
        dateOfBirth = passenger.getDateOfBirth();
        return dateOfBirth;
    }

}
