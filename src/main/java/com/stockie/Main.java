package com.stockie;

import com.stockie.config.Config;
import java.io.IOException;


public class Main {

    /*
     * Entry-Point und Main der gesamten Applikation.
     * */

    public static void main(String[] args) throws IOException, InterruptedException {

        Config config = new Config();
        URLModel urlModel = new URLModel(config.getKey("Alphakey"),config.getInterval("minute"),config.getAssets("Assets"));
        API api = new API();
        DatabaseConnector DbConn = new DatabaseConnector();
        Routine routine = new Routine(urlModel,DbConn,api);

        System.out.println("Starting Upload");

        routine.init(config.getIdentifier("minute"), config.getTableName("TableName"));
        Thread.sleep(60 * 1000); // Wait for 60 seconds
        routine.init(config.getIdentifier("daily"), config.getTableName("HistoryTableName"));

    }

}
