package persistors;

import javafx.collections.ObservableList;
import model.Flight;
import model.Passenger;

/**
 * Created by brian on 28/12/16.
 */
public interface IPersistor {

    void writeFlights(ObservableList<Flight> flight);

    void writePassengers(ObservableList<Passenger> passengers);

}
