package model;

/**
 * Created by brian on 12/12/16.
 */
public class AdultFlight extends Flight {

    private double price;

    public AdultFlight() {}

    public AdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                       String flightTime, String returnTime) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
        setPrice(price);
    }

    public static AdultFlight createAdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime)  {
        return new AdultFlight(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime);
    }

    @Override
    public double setPriceSingle() {
        return this.price = price;
    }

    @Override
    public double setPriceReturn() {
        return this.price = price;
    }


}
