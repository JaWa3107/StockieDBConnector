package com.stockie;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    public DatabaseConnector() throws IOException {

        deleteData();

        URLModel url = new URLModel("1A79MCHMT69G16RE","1min","TIME_SERIES_INTRADAY");
        LinkedHashMap<String, String> alphavantageUrls = url.getUrls();
        API api = new API();



        for (String key : alphavantageUrls.keySet()){
            String response = api.getWebPage(alphavantageUrls.get(key));
            ArrayList<Map<String, String>> data = api.getJson(response);
            uploadData(data, key);

        }

    }

    /**
     Method which shows all entries from the database.
     */

    public void viewData()  {

        try {
            // Connection to the MariaDB
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Verbindung erfolgreich hergestellt");

            // Create a query
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM dailyprices;");

            // While loop to go through all entries
            while (rs.next()) {
                int id = rs.getInt("Asset_ID");
                String price = rs.getString("Price_Date");
                double open = rs.getDouble("open");
                double high = rs.getDouble("high");
                double low = rs.getDouble("low");
                double close = rs.getDouble("close");
                double volume= rs.getDouble("volume");

                System.out.println("date"+"                | "+      "open"+"   | "+"high"+"   | "+"low"+ "     | "+"close"+" | "+ "volume");
                System.out.println(price+" | "+open+" | "+high+" | "+low+ " | "+close+" | "+ volume);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }


    /**
     Method to write the data from the API call into the MariaDB
     */

    public void uploadData(ArrayList<Map<String, String>> data,  String table_name){

        //deleteData();

        // ArrayList with the data from the API call.
        ArrayList<Map<String, String>> stockValues = data;

        /*
            loop to write all entries from the list into the MariaDB (row for row!)
        */
        int index = 1;
        for (Map<String,String> map : stockValues) {
            try {
                String date = map.get("date");

                /*
                    Parse the value into an double.
                 */
                double open = Double.parseDouble(map.get("open"));
                double high = Double.parseDouble(map.get("high"));
                double low = Double.parseDouble(map.get("low"));
                double close = Double.parseDouble(map.get("close"));
                double volume = Double.parseDouble(map.get("volume"));

                // Connection to the MariaDB
                Connection conn = DriverManager.getConnection(url, user, pass);

                // Create an INSERT INTO query
                String query = "INSERT IGNORE INTO "+table_name+" (Price_date, open, high, low, close, volume) values (?, ?, ?, ?, ?, ?)";

                /*
                    Prepared Statements for an safety upload into the MariaDB
                 */

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, date);
                preparedStmt.setDouble(2, open);
                preparedStmt.setDouble(3, high);
                preparedStmt.setDouble(4, low);
                preparedStmt.setDouble(5, close);
                preparedStmt.setDouble(6, volume);
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

    private void deleteData() {
        try {
            // Connection to the MariaDB
            Connection conn = DriverManager.getConnection(url, user, pass);
            String query = "delete from history_prices";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            conn.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}