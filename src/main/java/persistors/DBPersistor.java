package persistors;

import javafx.collections.ObservableList;
import model.CreditCard;
import model.Flight;
import model.Passenger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by brian on 28/12/16.
 */
public class DBPersistor implements IPersistor {

    private Connection dbConnection;
    private ArrayList<AutoCloseable> dbObjects;



    public DBPersistor(){

        dbObjects = new ArrayList<AutoCloseable>();
        try {

            String db_Driver = "com.mysql.cj.jdbc.Driver";
            String db_URL = "jdbc:mysql://localhost:3306/";
            String db_Name = "javiairdb?";
            String db_User = "root";
            String db_Pass = "bossdog12";

            Class.forName(db_Driver);

            this.dbConnection = DriverManager.getConnection(
                    db_URL+db_Name, db_User, db_Pass);

            if(this.dbConnection != null) {
                System.out.println("CONNECTED TO DATABASE!! :" + this.dbConnection);
            } else {
                System.out.println("CONNECTION FAILED!!");
            }


        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void writeFlights(ObservableList<Flight> flights) {

        try {

            dbConnection.setAutoCommit(false);

            for (Flight currentFlight : flights) {

                PreparedStatement prepStatement =
                        dbConnection.prepareStatement(
                                "INSERT INTO flights " +
                                        "(Origin, Destination, DepartPrice, ReturnPrice, Price, DepartTime, ReturnTime) " +
                                        "VALUES (?, ?, ?, ?, ?, ?, ?)");

                prepStatement.setString(1, currentFlight.getOrigin());
                prepStatement.setString(2, currentFlight.getDestination());
                prepStatement.setString(3, currentFlight.getDepartPrice().toString());
                prepStatement.setString(4, currentFlight.getReturnPrice().toString());
                prepStatement.setString(5, currentFlight.getPrice().toString());
                prepStatement.setString(6, currentFlight.getDepartTime());
                prepStatement.setString(7, currentFlight.getReturnTime());

                prepStatement.executeUpdate();
                prepStatement.close();
            }

            dbConnection.commit();
            dbConnection.setAutoCommit(true);

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
    }


    @Override
    public void writeCreditCard(ObservableList<CreditCard> creditCards) {

        try{

            dbConnection.setAutoCommit(false);

            for (CreditCard currCard : creditCards) {

                PreparedStatement prepStmt =
                        dbConnection.prepareStatement(
                                "INSERT INTO creditcard " +
                                        "(OwnersName, Address1, Address2, Address3, CardType, CardNumber, ExpiryDate, CCVNumber)" +
                                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

                prepStmt.setString(1, currCard.getName());
                prepStmt.setString(2, currCard.getAddress1());
                prepStmt.setString(3, currCard.getAddress2());
                prepStmt.setString(4, currCard.getAddress3());
                prepStmt.setString(5, currCard.getCardType());
                prepStmt.setString(6, currCard.getCardNumber());
                prepStmt.setString(7, String.valueOf(currCard.getExpiryDate()));
                prepStmt.setString(8, currCard.getCcvNumber());

                prepStmt.executeUpdate();
                prepStmt.close();

            }
            dbConnection.commit();
            dbConnection.setAutoCommit(true);

        }catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }


    @Override
    public void writePassengers(ObservableList<Passenger> passengers) {

        try {
            for (Passenger currentPassenger : passengers) {

                if(currentPassenger != null) {

                    Date dateOfBirth = Date.valueOf(currentPassenger.getDateOfBirth());


                    PreparedStatement prepStmt =
                            dbConnection.prepareStatement(
                                    "INSERT INTO passenger " +
                                            "(FirstName, LastName, DateOfBirth, BaggageSelected, SpanishSelected, " +
                                            "Dni, BagPrice, SpanishRebate) " +
                                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

                    prepStmt.setString(1, currentPassenger.getFirstName());
                    prepStmt.setString(2, currentPassenger.getLastName());
                    prepStmt.setDate(3,  dateOfBirth);
                    prepStmt.setBoolean(4, currentPassenger.isBaggageSelected());
                    prepStmt.setBoolean(5, currentPassenger.isSpanishCheckboxSelected());
                    prepStmt.setString(6, currentPassenger.getNumberDNI());
                    prepStmt.setDouble(7, currentPassenger.getBaggagePrice());
                    prepStmt.setDouble(8, currentPassenger.getSpaRebate());

                    prepStmt.executeUpdate();
                    dbObjects.add(prepStmt);
                }
            }
            close();

        }catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }

    }



    public void close() {
        try{
            for(AutoCloseable curr : dbObjects) {
                curr.close();
            }
        }catch(Exception ex){
            System.out.println("ERROR 3:"+ex.getMessage());
        }
    }

}




















