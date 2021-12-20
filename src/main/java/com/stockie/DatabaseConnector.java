package com.stockie;
import java.sql.*;
import java.util.ArrayList;
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
     Method to write the data from the API call into the MariaDB
     */

    public void uploadData(ArrayList<Map<String, String>> data,  String tableName, int assetId){

        // ArrayList with the data from the API call.
        ArrayList<Map<String, String>> stockValues = data;

        /*
            loop to write all entries from the list into the MariaDB (row for row!)
        */
        int index = 1;
        for (Map<String,String> map : stockValues) {
            try{
                // Connection to the MariaDB
                Connection conn = DriverManager.getConnection(url, user, pass);

                // Create an INSERT INTO query
                String query = "INSERT IGNORE INTO "+ tableName +" (Asset_id, Price_date, open, high, low, close, volume) values (?, ?, ?, ?, ?, ?, ?)";

                /*
                    Parse the value into an double and Prepared Statements for an safety upload into the MariaDB
                 */

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, assetId);

                if (tableName.equals("polygonTestPrices")) {
                    long test = Long.parseLong(map.get("date"));

                    Timestamp date = new Timestamp(test);
                    //String date = map.get("date");
                    preparedStmt.setTimestamp(2, date);
                    //Timestamp date = Timestamp.valueOf(map.get("date"));
                    //preparedStmt.setTimestamp(2, date);
                }else if(tableName.equals("assetHistoryPrices")){
                    Date date = Date.valueOf(map.get("date"));
                    preparedStmt.setDate(2, date);
                }

                double open = Double.parseDouble(map.get("open"));
                preparedStmt.setDouble(3, open);

                double high = Double.parseDouble(map.get("high"));
                preparedStmt.setDouble(4, high);

                double low = Double.parseDouble(map.get("low"));
                preparedStmt.setDouble(5, low);

                double close = Double.parseDouble(map.get("close"));
                preparedStmt.setDouble(6, close);

                double volume = Double.parseDouble(map.get("volume"));
                preparedStmt.setDouble(7, volume);

                preparedStmt.execute();

                System.out.println(index + "/" + stockValues.size() + " uploaded");
                index++;

                // Disconnect
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getStackTrace().toString());
            }
        }

        System.out.println("Die Verbindung zur Datenbank wurde aufgehoben. Alle Daten wurden erfolgreich hochgeladen.");




    }

}