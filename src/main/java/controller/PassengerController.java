package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Passenger;
import persistors.IPersistor;

/**
 * Created by brian on 31/12/16.
 */
public class PassengerController {

    private static PassengerController instance;
    private IPersistor persistor;
    private ObservableList<Passenger> passengerList = FXCollections.observableArrayList();



    private PassengerController() {
    }

    public static PassengerController getInstance() {
        if (instance == null) {
            instance = new PassengerController();
        }
        return instance;
    }


    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }

    public void setPersistor(IPersistor persistor) {
        this.persistor = persistor;
    }

    public ObservableList<Passenger> getPassengers() {
        return this.passengerList;
    }

    public void savePassenger() { this.persistor.writePassengers(this.passengerList); }


}

