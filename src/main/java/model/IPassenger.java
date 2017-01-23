package model;

import java.time.LocalDate;

/**
 * Created by brian on 19/01/17.
 */
public interface IPassenger {

    void setDateOfBirth(LocalDate dateOfBirth);

    String speak();

    LocalDate getDateOfBirth();


}
