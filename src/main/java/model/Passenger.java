package model;

import helpers.Consts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

/**
 * Created by brian on 11/11/16.
 */
public class Passenger {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean baggageSelected;
    private boolean spanishSelected;
    private double baggagePrice;
    private String numberDNI;
    private double spaRebate;
    private double dptPrice;
    private double rtnPrice;
    private double flightPrice;


    public Passenger(){}

    public Passenger(String numberDNI){
        this.numberDNI = numberDNI;
    }

    public Passenger(String firstName, String lastName, String numberDNI, LocalDate dateOfBirth,
                     boolean baggageSelect, boolean spanishSelected) {
        this.firstName = firstName;
        this.lastName = lastName;
        setNumberDNI(numberDNI);
        setDateOfBirth(dateOfBirth);
        this.baggageSelected = baggageSelect;
        this.spanishSelected = spanishSelected;

    }

    public double getBaggagePrice() {
        return baggagePrice;
    }

    public double getSpaRebate() { return spaRebate; }

    public double setSpaRebate(String origin, String destination) {

        // set spanish rebate value, based on the criteria of flights being to or from MAD / AGP

        if (isSpanishSelected()) {
            if (origin.equals(Consts.MADRID) && destination.equals(Consts.MALAGA)) {
                spaRebate = Consts.SPANISH_REBATE_DOUBLED;
            } else if (origin.equals(Consts.MALAGA) && destination.equals(Consts.MADRID)) {
                spaRebate = Consts.SPANISH_REBATE;
            } else {
                spaRebate = Consts.ZERO;
            }
        }
        return spaRebate;
    }


    // referenced Colin Manning's code here:
    // http://mcom.cit.ie/staff/Computing/CManning/soft6008-2015/js09/js-09-dni.html
    public boolean validateDNINumber() {
        String dniCopy = this.numberDNI;
        String madString = Consts.DNI_LETTERS;
        String dniLetter = "";
        char dniLetter2;
        int dniNum;
        int dniMod;

        if (dniCopy != null) {

            if (!((dniCopy.length() == 9) || dniCopy.length() == 10)) {
                return false;
            }

            if (dniCopy.length() == 10) {

                if (this.numberDNI.charAt(8) == '-') {
                    dniCopy = this.numberDNI.replace("-", "");

                } else {
                    return false;
                }
            }

            dniNum = parseInt(dniCopy.substring(0, 8), 10);
            dniLetter = dniCopy.substring(8, 9).toUpperCase();
            dniMod = dniNum % 23;
            dniLetter2 = madString.charAt(dniMod);

            if (!dniLetter.matches(String.valueOf(dniLetter2))) {
                return false;
            }
        }
        return true;
    }


    public boolean validateFirstName(String fName) {
        if (getFirstName().matches(Consts.LAST_NAME_VALID)) {
            return true;
        }
        return false;
    }


    public boolean validateLastName(String lName) {
        if (getLastName().matches(Consts.FIRST_NAME_VALID)) {
            return true;
        }
        return false;
    }


    public boolean isSpanishSelected() {
        return spanishSelected;
    }


    public void setSpanishSelected(boolean spanishSelected) {
        this.spanishSelected = spanishSelected;
    }


    public boolean isBaggageSelected() {
        return baggageSelected;
    }




    public double setBaggagePriceSingle() {
        if(isBaggageSelected()) {
            baggagePrice = Consts.BAGGAGE_PRICE;
        }
        return baggagePrice;
    }


    public double setBaggagePriceReturn() {
        if(isBaggageSelected()) {
            baggagePrice = Consts.BAGGAGE_PRICE * 2;
        }
        return baggagePrice;
    }



    public boolean isPassengerInfant() {
        if (this.getDateOfBirth() != null) {
            if (this.getDateOfBirth().isAfter(LocalDate.now().minusYears(1))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPassengerAChild() {
        if(this.getDateOfBirth() != null) {
            if (this.getDateOfBirth().isAfter(LocalDate.now().minusYears(5)) &&
                    this.getDateOfBirth().isBefore(LocalDate.now().minusYears(1))) {
                return true;
            }
        }
        return false;
    }


    public boolean isPassengerOver18() {
        if(this.getDateOfBirth() != null) {
            if (this.getDateOfBirth().isBefore(LocalDate.now().minusYears(18))) {
                return true;
            }
        }
        return false;
    }



    public boolean isPassengerOver5() {
        if(this.getDateOfBirth() != null) {
            if (this.getDateOfBirth().isBefore(LocalDate.now().minusYears(5))) {
                return true;
            }
        }
        return false;
    }


    public void setNumberDNI(String numberDNI) {
        validateDNINumber();
        this.numberDNI = numberDNI;
    }

    public String getNumberDNI() {
        return numberDNI;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

    }

    public double spanishRebateValue() {
        double value = 0;
        if (isSpanishSelected()) {
            value = Consts.SPANISH_REBATE;
        }
        return value;
    }



    public double getFlightPrice(Flight flight) {
        dptPrice = flight.getDepartPrice();
        rtnPrice = flight.getReturnPrice();
        flightPrice = dptPrice + rtnPrice;

        return flightPrice;
    }



    @Override
    public String toString() {

        LocalDate date = this.dateOfBirth;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDob = date.format(formatter);

        return  " Details:"+
                "\n\n\tFirst name:\t\t " + this.firstName +
                "\n" +
                "\tLast name:\t\t " + this.lastName +
                "\n" +
                "\tDate of birth:\t\t " + formattedDob +
                "\n\t" + "Baggage: \t\t €" + setBaggagePriceReturn();
    }



    public String toStringSingleFlight() {

        LocalDate date = this.dateOfBirth;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDob = date.format(formatter);

        return  " Details:"+
                "\n\n\tFirst name:\t\t " + this.firstName +
                "\n" +
                "\tLast name:\t\t " + this.lastName +
                "\n" +
                "\tDate of birth:\t\t " + formattedDob +
                "\n\t" + "Baggage: \t\t €" + setBaggagePriceSingle();
    }


}
