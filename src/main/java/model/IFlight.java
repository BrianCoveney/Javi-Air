package model;

import java.time.LocalDate;

/**
 * Created by brian on 19/01/17.
 */
public interface IFlight {

    void setOrigin(String origin);

    void setDestination(String destination);

    void setDepartPrice(Double departPrice);

    void setReturnPrice(Double returnPrice);

    void setDepartTime(String departTime);

    void setReturnTime(String returnTime);

    void setPrice(Double price);

    double setPriceSingle();

    double setPriceReturn();

    double getPrice();

    String speak();

    String toStringSingleFlight();

    LocalDate getDateOfBirth(Passenger passenger);

    double setBagPrice(Passenger passenger);

}
