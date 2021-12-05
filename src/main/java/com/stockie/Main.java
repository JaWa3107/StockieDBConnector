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

        /**
         *
         * API CALLS AND UPLOAD TO THE MARIA DB
         *
         * */

        URLModel url = new URLModel("1A79MCHMT69G16RE","1min");

        LinkedHashMap<String, String> test1 =url.getAssetUrls();
        LinkedHashMap<String, String> test2 = url.getAssetUrlsHistroy();

        for (String key: test1.keySet()){

            System.out.println(key+":" + test1.get(key));

        }

        for (String key: test2.keySet()){

            System.out.println(key+":" + test2.get(key));

        }

        new DatabaseConnector();
    }
}
