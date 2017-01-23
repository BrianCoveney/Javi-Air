package model;

import java.time.LocalDate;

/**
 * Created by brian on 19/01/17.
 */
public class PassengerChild implements IPassenger {

    private LocalDate dateOfBirth;

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
        return "I'm a child";
    }


}
