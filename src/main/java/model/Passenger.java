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
    private boolean isInfant, isChild, isAdult, isOverFive;


    public Passenger(){}

    public Passenger(String numberDNI){
        this.numberDNI = numberDNI;
    }


    public Passenger(String firstName, String lastName, String numberDNI, LocalDate dateOfBirth, boolean baggageSelect, boolean spanishSelected) {
        this.firstName = firstName;
        this.lastName = lastName;
        setNumberDNI(numberDNI);
        setDateOfBirth(dateOfBirth);
        this.baggageSelected = baggageSelect;
        this.spanishSelected = spanishSelected;

    }


    // set spanish rebate value, based on the criteria of flights being to or from MAD / AGP
    public double setSpanishRebate(String origin, String destination) {

        double spaPrice = 0;
        for (int i = 0; i < Consts.MAX_PASSENGER_NO; i++) {
            if (origin.equals(Consts.MADRID) && destination.equals(Consts.MALAGA)) {
                spaPrice = Consts.SPANISH_REBATE * 2;
                return spaPrice;
            } else if (origin.equals(Consts.MALAGA) && destination.equals(Consts.MADRID)) {
                spaPrice = Consts.SPANISH_REBATE;
                return spaPrice;
            } else {
                spaPrice = Consts.ZERO;
                return spaPrice;
            }
        }
        return spaPrice;
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
        String validText = "[A-Z][a-zA-Z]*";
        if (getFirstName().matches(validText)) {
            return true;
        }
        return false;
    }


    public boolean validateLastName(String lName) {
        String validText = "[a-zA-z]+([ '-][a-zA-Z]+)*";
        if (getLastName().matches(validText)) {
            return true;
        }
        return false;
    }



    public boolean isSpanishCheckboxSelected() {
        return spanishSelected;
    }

    public boolean isBaggageSelected() {
        return baggageSelected;
    }



    public double setBaggagePriceSingle() {
        double bagPrice = 0.0;
        if(isBaggageSelected()) {
            bagPrice = Consts.BAGGAGE_PRICE;
        }
        return bagPrice;
    }


    public double setBaggagePriceReturn() {
        double bagPrice = 0.0;
        if(isBaggageSelected()) {
            bagPrice = Consts.BAGGAGE_PRICE * 2;
        }
        return bagPrice;
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
        if (isSpanishCheckboxSelected()) {
            value = Consts.SPANISH_REBATE;
        }
        return value;
    }


    public double spanishRebateValueDoubled() {
        double value = 0;
        if (isSpanishCheckboxSelected()) {
            value = Consts.SPANISH_REBATE * 2;
        }
        return value;
    }

    public double spanishRebateValueNull() {
        double value = 0;
        if (isSpanishCheckboxSelected()) {
            value = Consts.NO_SPANISH_REBATE;
        }
        return value;
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
