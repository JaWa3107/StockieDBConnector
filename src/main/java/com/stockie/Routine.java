package com.stockie;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Routine {

    URLModel urlModel;
    DatabaseConnector DbConn;
    API api;

    public Routine(URLModel urlModel, DatabaseConnector DbConn, API api)  {

       this.urlModel = urlModel;
       this.DbConn = DbConn;
       this.api = api;

    }

    public void init(String identifier,String tableName,String DbUrl, String DbUser, String DbPass) throws IOException {
        LinkedHashMap<String, String> alphavantageUrls = null;

        if(tableName.equals("assetPrices")){
             alphavantageUrls = urlModel.getAssetUrls();
        }else if(tableName.equals("assetHistoryPrices")){
            alphavantageUrls = urlModel.getAssetUrlsHistory();
        }

        int index = 0;
        for (String key : alphavantageUrls.keySet()){
            String response = api.getWebPage(alphavantageUrls.get(key));
            ArrayList<Map<String, String>> data = api.getJson(response, identifier);
            DbConn.uploadData(data, tableName, index,  DbUrl,  DbUser,  DbPass);
            index++;
        }

    }
}
