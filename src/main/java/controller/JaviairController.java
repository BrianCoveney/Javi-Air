package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CreditCard;
import model.Flight;
import model.Passenger;
import persistors.IPersistor;

/**
 * Created by brian on 26/10/16.
 */
public final class JaviairController {

    private static JaviairController instance;
    private IPersistor persistor;
    private ObservableList<Flight> flightList = FXCollections.observableArrayList();
    private ObservableList<Passenger> passengerList = FXCollections.observableArrayList();
    private ObservableList<CreditCard> creditCardList = FXCollections.observableArrayList();



    private JaviairController(){}

    public static JaviairController getInstance(){
        if(instance == null){
            instance = new JaviairController();
        }
     return instance;
    }

    public void addCreditCard(CreditCard creditCard){
        this.creditCardList.add(creditCard);
    }

    public ObservableList<CreditCard> getCreditCard(){
        return this.creditCardList;
    }

    public void saveCreditCard() { this.persistor.writeCreditCard(this.creditCardList); }

    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }

    public ObservableList<Passenger> getPassengers() {
        return this.passengerList;
    }

    public void savePassenger() { this.persistor.writePassengers(this.passengerList); }

    public void addFlight(Flight flight){
        this.flightList.add(flight);
    }

    public ObservableList<Flight> getFlights(){
        return this.flightList;
    }

    public void saveFlight() { this.persistor.writeFlights(this.flightList); }

    public void setPersistor(IPersistor persistor) {
        this.persistor = persistor;
    }


}
