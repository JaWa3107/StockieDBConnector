package com.stockie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    /*
     * Entry-Point und Main der gesamten Applikation.
     * */

    public static void main(String[] args) throws IOException {

        System.out.println("test");

        /*URLModel url = new URLModel("1A79MCHMT69G16RE","1min","TIME_SERIES_INTRADAY");
        LinkedHashMap<String, String> assetUrls = url.getUrls();

        for (String variableName : assetUrls.keySet()){

            System.out.println(variableName);
        }

       // System.out.println(assetUrls);
       // System.out.println(assetUrls.get("AAPL"));
       // System.out.println(assetUrls.size());*/


        /**
         *
         * API CALLS AND UPLOAD TO THE MARIA DB
         *
         * */

        new DatabaseConnector();
    }
}



// TEST ABFRAGE!
        /*URLModel url = new URLModel("1A79MCHMT69G16RE","AAPL","1min","TIME_SERIES_INTRADAY");
        API api = new API();
        String alphaVantageUrl = url.getUrl();
        String response = api.getWebPage(alphaVantageUrl);
        ArrayList<Map<String, String>> data = api.getJson(response);*/

// DB Conector SELECT ABFRAGE UND UPLOAD API CALL

//db.viewData();


/** DIE UPLOAD METHODE ERSTMAL NICHT AUSFÜHREN !
 MUSS NOCH ANGEPASST WERDEN
 DATEN IN DER DB WÜRDEN SONST DOPPELT VORHANDEN SEIN.
 */
//db.uploadData(data);
