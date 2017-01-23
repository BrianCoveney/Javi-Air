package model;

import java.time.LocalDate;

/**
 * Created by brian on 19/01/17.
 */
public class PassengerFactory  {


    public static IPassenger getPassenger(LocalDate date) {

        if(date == null) {
            return null;
        }
        if(date.isAfter(LocalDate.now().minusYears(1))) {
            return new PassengerInfant();
        }
        else if (date.isAfter(LocalDate.now().minusYears(5)) && date.isBefore(LocalDate.now().minusYears(1))) {
            return new PassengerChild();
        }
        else if (date.isBefore(LocalDate.now().minusYears(18))) {
            return new PassengerAdult();
        }

        return null;

    }
}
