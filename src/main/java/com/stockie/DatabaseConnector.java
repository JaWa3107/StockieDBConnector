package com.stockie;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;




public class DatabaseConnector {

    /**
     Loginparameter for the MariaDB.
     */

    private String url = "jdbc:mysql://185.188.250.67:3306/Se2Projekt";
    private String user = "root";
    private String pass = "StefanWolf2k21";


    /**
     Constructor
     */
    public DatabaseConnector() {

    }

    /**
     *
     * Für die Methoden Daily und History gibt es bestimmt eine bessere möglichkeit zu implemntieren
     *
     * */



    /**
     Method to write the data from the API call into the MariaDB
     */

    public void uploadData(ArrayList<Map<String, String>> data,  String table_name, int assetId){

        //deleteData();

        // ArrayList with the data from the API call.
        ArrayList<Map<String, String>> stockValues = data;

        /*
            loop to write all entries from the list into the MariaDB (row for row!)
        */
        int index = 1;
        for (Map<String,String> map : stockValues) {
            try {
                /*
                    Parse the value into an double.
                 */


                Timestamp date = Timestamp.valueOf(map.get("date"));
                //Date date = Date.valueOf(map.get("date"));
                double open = Double.parseDouble(map.get("open"));
                double high = Double.parseDouble(map.get("high"));
                double low = Double.parseDouble(map.get("low"));
                double close = Double.parseDouble(map.get("close"));
                double volume = Double.parseDouble(map.get("volume"));

                // Connection to the MariaDB
                Connection conn = DriverManager.getConnection(url, user, pass);

                // Create an INSERT INTO query
                String query = "INSERT IGNORE INTO "+ table_name +" (Asset_id, Price_date, open, high, low, close, volume) values (?, ?, ?, ?, ?, ?, ?)";


                /*
                    Prepared Statements for an safety upload into the MariaDB
                 */

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, assetId);
                preparedStmt.setTimestamp(2, date);
                preparedStmt.setDouble(3, open);
                preparedStmt.setDouble(4, high);
                preparedStmt.setDouble(5, low);
                preparedStmt.setDouble(6, close);
                preparedStmt.setDouble(7, volume);
                preparedStmt.execute();
                System.out.println(index + "/" + stockValues.size() + " uploaded");
                index++;

                // Disconnect
                conn.close();
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e.getLocalizedMessage());
            }
        }

        System.out.println("Die Verbindung zur Datenbank wurde aufgehoben. Alle Daten wurden erfolgreich hochgeladen.");




    }

}