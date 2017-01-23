package model;

import java.time.LocalDate;

/**
 * Created by brian on 19/01/17.
 */
public class PassengerAdult implements IPassenger {

    private LocalDate dateOfBirth;
    private double flightPrice;

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String speak() {
        return "I'm an Adult";
    }



}
