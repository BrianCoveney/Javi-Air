package model;

import java.time.LocalDate;

/**
 * Created by brian on 22/10/16.
 */
public abstract class Flight implements IFlight{

    private String origin;
    private String destination;
    private Double departPrice;
    private Double returnPrice;
    private Double price;
    private String departTime;
    private String returnTime;
    private String departDate;
    private String returnDate;
    private double flightPrice;
    private double weekendPrice;
    private double deptPlusRtnPrice;
    private double bagPrice;
    private AirportType airportType;



    public Flight(){}


    public Flight (String origin, String destination, Double deapartPrice, Double returnPrice, Double price,
                   String flightTime, String returnTime, String departDate, String returnDate) {
        this.origin = origin;
        this.destination = destination;
        this.departPrice = deapartPrice;
        this.returnPrice = returnPrice;
        this.price = price;
        this.departTime = flightTime;
        this.returnTime = returnTime;
        this.departDate = departDate;
        this.returnDate = returnDate;
    }

    public abstract double setPriceSingle();

    public abstract double setPriceReturn();




    public final boolean dateIsInvalid(LocalDate departDate, LocalDate returnDate) {
        if (departDate != null && returnDate != null) {
            if (departDate.isAfter(returnDate)) {
                return true;
            }
        }
        return false;
    }



    public double calculateExtraForWeekend(String day, double price) {

        if(day == String.valueOf(Day.FRIDAY) || day == String.valueOf(Day.SATURDAY) || day == String.valueOf(Day.SUNDAY)) {
            price = DayType.WEEKEND.calculateExtraPrice(price);
        }
        return price;
    }


    public double setBagPrice(Passenger passenger) {
        bagPrice = passenger.getBaggagePrice();
        return this.bagPrice;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public String displayTotalPrice() {return "\t\t = €"+this.price;}

    public String displayDeptDetails()  { return this.origin +" > "+ this.destination +" = €"+ this.departPrice; }

    public String displayReturnDetails()  { return this.destination +" > "+ this.origin +" = €"+ this.returnPrice; }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDepartPrice() {
        return departPrice;
    }

    public void setDepartPrice(Double departPrice) {
        this.departPrice = departPrice;
    }

    public Double getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(Double returnPrice) {
        this.returnPrice = returnPrice;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public double flightSelection() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "\tDepart: \t\t\t" + displayDeptDetails() +
                "\n\tReturn: \t\t\t"+ displayReturnDetails() +
                "\n\tDepart Time: \t\t"+ this.departTime + "\n\tReturn Time: \t\t" + this.returnTime +
                       "\n\tFlight Price: \t\t\t"+ displayTotalPrice() + "\n";
    }

    public String toStringSingleFlight() {
        return "\tDepart: \t\t\t" + displayDeptDetails() +
                "\n\tDepart Time: \t\t"+ this.departTime +
                "\n\tFlight Price: \t\t\t"+ displayTotalPrice() + "\n";
    }


}
