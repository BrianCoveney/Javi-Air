package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Flight;
import model.Passenger;
import persistors.IPersistor;

/**
 * Created by brian on 26/10/16.
 */
public class FlightController {

    private static FlightController instance;
    private IPersistor persistor;
    private ObservableList<Flight> flightList = FXCollections.observableArrayList();
    private ObservableList<Passenger> passengerList = FXCollections.observableArrayList();


    private FlightController(){}

    public static FlightController getInstance(){
        if(instance == null){
            instance = new FlightController();
        }
     return instance;
    }

    public void addFlight(Flight flight){
        this.flightList.add(flight);
    }


    public ObservableList<Flight> getFlights(){
        return this.flightList;
    }

    // add Flight to database
    public void saveFlight() { this.persistor.writeFlights(this.flightList); }


    public void setPersistor(IPersistor persistor) {
        this.persistor = persistor;
    }


}
