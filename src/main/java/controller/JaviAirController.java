package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Flight;
import model.Passenger;
import persistors.IPersistor;

/**
 * Created by brian on 26/10/16.
 */
public class JaviAirController {

    private static JaviAirController instance;
    private IPersistor persistor;
    private ObservableList<Flight> flightList = FXCollections.observableArrayList();
    private ObservableList<Passenger> passengerList = FXCollections.observableArrayList();


    public static JaviAirController getInstance(){
        if(instance == null){
            instance = new JaviAirController();
        }
     return instance;
    }

    public void addFlight(Flight flight){
        this.flightList.add(flight);
    }

    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }

    public void setPersistor(IPersistor persistor) {
        this.persistor = persistor;
    }

    public ObservableList<Flight> getFlights(){
        return this.flightList;
    }

    public ObservableList<Passenger> getPassengers(){
        return this.passengerList;
    }

    // add Flight to database
    public void save() { this.persistor.write(this.flightList); }

}
