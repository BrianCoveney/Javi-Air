package model;

/**
 * Created by brian on 12/12/16.
 */
public class AdultFlight extends Flight implements IFlight{


    public double departPrice;
    public double returnPrice;


    public AdultFlight() {}

    public AdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                       String flightTime, String returnTime, String departDate, String returnDate) {
        super(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime, departDate, returnDate);
        setPrice(price);


    }

    @Override
    public double setPriceSingle() {
        return this.departPrice;
    }

    @Override
    public double setPriceReturn() {
        return this.returnPrice;
    }

    public static AdultFlight createAdultFlight(String origin, String destination, Double deapartPrice, Double returnPrice,
                                                Double price, String flightTime, String returnTime, String departDate, String returnDate)  {

        return new AdultFlight(origin, destination, deapartPrice, returnPrice, price, flightTime, returnTime, departDate, returnDate);
    }



    @Override
    public String printAdultSingleFlightDetails() {
        return "\tDepart: \t\t\t" + this.setPriceSingle() +
                "\n\tDepart Time: \t\t"+ getDepartTime();
    }


    @Override
    public String printAdultReturnFlightDetails() {
        return  this.departPrice +
                this.returnPrice +
                getDepartTime() + "\n";
    }

}