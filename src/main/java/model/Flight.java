package model;

import helpers.Consts;

import java.time.LocalDate;

/**
 * Created by brian on 22/10/16.
 */
public abstract class Flight{

    private String origin;
    private String destination;
    private Double departPrice;
    private Double returnPrice;
    private Double price;
    private String departTime;
    private String returnTime;
    private double flightPrice;
    private double weekendPrice;
    private double deptPlusRtnPrice;
    private double bagPrice;



    public Flight(){}


    public Flight (String origin, String destination, Double deapartPrice, Double returnPrice, Double price, String flightTime, String returnTime) {
        this.origin = origin;
        this.destination = destination;
        this.departPrice = deapartPrice;
        this.returnPrice = returnPrice;
        this.price = price;
        this.departTime = flightTime;
        this.returnTime = returnTime;
    }

    public abstract double setPriceSingle();

    public abstract double setPriceReturn();


    public final double flightSelection(String dptFlight, String rtnFlight) {
        if (dptFlight != null && rtnFlight != null) {
            if (dptFlight.equals(Consts.CORK) && rtnFlight.equals((Consts.MADRID)) || dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.CORK)) {
                flightPrice = Consts.ONE_HND;
            } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.ST_BRIEUC) || dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.CORK)) {
                flightPrice = Consts.ONE_HND;
            } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.JERSEY) || dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.CORK)) {
                flightPrice = Consts.ONE_HND_TWENTY;
            } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.PARIS) || dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.CORK)) {
                flightPrice = Consts.EIGHTY;
            } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.CORK)) {
                flightPrice = Consts.FORTY;
            } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.MALAGA) || dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.CORK)) {
                flightPrice = Consts.TWO_HND_FORTY;
            } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.ST_BRIEUC) || dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.MADRID)) {
                flightPrice = Consts.TWO_HND;
            } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.JERSEY) || dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.MADRID)) {
                flightPrice = Consts.TWO_HND;
            } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.PARIS) || dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.MADRID)) {
                flightPrice = Consts.SIXTY;
            } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.MADRID)) {
                flightPrice = Consts.SIXTY;
            } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.MALAGA) || dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.MADRID)) {
                flightPrice = Consts.SIXTY;
            } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.JERSEY)) {
                flightPrice = Consts.ZERO;
            } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.PARIS) || dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.ST_BRIEUC)) {
                flightPrice = Consts.ONE_HND_FIFTY;
            } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.MALAGA) || dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.ST_BRIEUC)) {
                flightPrice = Consts.ONE_HND_FORTY;
            } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.PARIS) || dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.JERSEY)) {
                flightPrice = Consts.TWO_HND_FIFTY;
            } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.JERSEY)) {
                flightPrice = Consts.TWO_HND_FIFTY;
            } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.MALAGA) || dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.JERSEY)) {
                flightPrice = Consts.TWO_HND_EIGHTY;
            } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.MALAGA) || dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.PARIS)) {
                flightPrice = Consts.ONE_HND;
            } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.MALAGA) || dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.STANSTED)) {
                flightPrice = Consts.ONE_HND_TWENTY;
            } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.PARIS)) {
                flightPrice = Consts.SIXTY;
            } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.ST_BRIEUC)) {
                flightPrice = Consts.EIGHTY;
            }
        }
        return flightPrice;
    }


    public final boolean dateIsInvalid(LocalDate departDate, LocalDate returnDate) {
        if (departDate != null && returnDate != null) {
            if (departDate.isAfter(returnDate)) {
                return true;
            }
        }
        return false;
    }


    public double calculateWeekendFlightPrice(double x, double y) {
        return weekendPrice = x + y * Consts.WEEKEND_RATE;
    }

    public double calculateDepartPlusReturnPrice(double x, double y) {
        return deptPlusRtnPrice = x + y;
    }


    public boolean isWeekend(String dayOfWeek) {
        if(dayOfWeek.equals(Consts.FRI) || dayOfWeek.equals(Consts.SAT) || dayOfWeek.equals(Consts.SUN)) {
            return true;
        }
        return false;
    }


    public double getBaggagePrice(Passenger passenger) {
        bagPrice = passenger.getBaggagePrice();
        return this.bagPrice;
    }

    public double getBagPrice() { return bagPrice; }


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

    public Double getPrice() {
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
