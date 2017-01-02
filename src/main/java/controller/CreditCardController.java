package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CreditCard;
import persistors.IPersistor;

/**
 * Created by brian on 26/10/16.
 */
public class CreditCardController {

    private static CreditCardController instance;
    private IPersistor persistor;
    private ObservableList<CreditCard> creditCardList = FXCollections.observableArrayList();


    private CreditCardController(){}

    public static CreditCardController getInstance(){
        if(instance == null){
            instance = new CreditCardController();
        }
        return instance;
    }

    public void addCreditCard(CreditCard creditCard){
        this.creditCardList.add(creditCard);
    }

    public ObservableList<CreditCard> getcreditCard(){
        return this.creditCardList;
    }

    public void saveCreditCard() { this.persistor.writeCreditCard(this.creditCardList); }

    public void setPersistor(IPersistor persistor) {
        this.persistor = persistor;
    }


}
