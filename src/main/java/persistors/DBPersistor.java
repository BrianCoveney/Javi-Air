package persistors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by brian on 28/12/16.
 */
public class DBPersistor implements IPersistor {

    private Connection dbConnection;
    private static String DB_URL = "jdbc:mysql://localhost:3306/javiairdb?";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "<your_password>";

    public DBPersistor(){

        try {

            Class.forName("com.mysql.jdbc.Driver");

            this.dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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


}
