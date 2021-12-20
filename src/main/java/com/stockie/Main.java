package com.stockie;

import com.stockie.config.Config;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    /*
     * Entry-Point und Main der gesamten Applikation.
     * */

    public static void main(String[] args) throws IOException, InterruptedException {

        Config config = new Config();
        URLModel urlModel = new URLModel(config.getKey("Alphakey"),config.getInterval("Interval"),config.getAssets("Assets"));
        API api = new API();
        DatabaseConnector DbConn = new DatabaseConnector();
        Routine routine = new Routine(urlModel,DbConn,api);

        System.out.println("Starting Upload");

        LinkedHashMap<String, String> alphavantageUrls = urlModel.getAssetUrls();

        for (String key : alphavantageUrls.keySet()){
            System.out.println(alphavantageUrls.get(key));
        }


        //Unix seconds
        long test = 1639731600000L;
        Timestamp st = new Timestamp(1639731600000L);
        System.out.println(st);
        routine.init(config.getInterval("Interval"), config.getTableName("TableName"));
        //Thread.sleep(60 * 1000); // Wait for 60 seconds
        //routine.init(config.getIdentifier("Identifier"), config.getTableName("HistoryTableName"));

    }
}
