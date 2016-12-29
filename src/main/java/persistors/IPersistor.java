package persistors;

import javafx.collections.ObservableList;
import model.Flight;

/**
 * Created by brian on 28/12/16.
 */
public interface IPersistor {

    void write(ObservableList<Flight> flight);


}
