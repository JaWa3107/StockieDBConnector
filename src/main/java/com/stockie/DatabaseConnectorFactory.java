package com.stockie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DatabaseConnectorFactory {

    private URLModel urlModel = new URLModel("1A79MCHMT69G16RE","1min");
    private API api = new API();
    private DatabaseConnector DbConn = new DatabaseConnector();

    public DatabaseConnectorFactory() throws IOException {
        daily();
        //TimeUnit.MINUTES.sleep(1);
        //history();

    }

    public void daily() throws IOException {


        LinkedHashMap<String, String> alphavantageUrls = urlModel.getAssetUrls();
        int index = 0;
        for (String key : alphavantageUrls.keySet()){
            String response = api.getWebPage(alphavantageUrls.get(key));
            ArrayList<Map<String, String>> data = api.getJson(response, "1min");
            DbConn.uploadData(data,"assetPrices" ,index);
            index++;
        }

    }

    int index = 0;
    public void history() throws IOException {

        LinkedHashMap<String, String> alphavantageUrls = urlModel.getAssetUrlsHistroy();
        int index = 0;
        for (String key : alphavantageUrls.keySet()){
            String response = api.getWebPage(alphavantageUrls.get(key));
            ArrayList<Map<String, String>> data = api.getJson(response, "Daily");
            DbConn.uploadData(data, "assetHistroyPrices", index);
            index++;
        }

    }


}
