package com.stockie;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class API {

    /**
     * Method to return the result of the API call.
     */

    public String getWebPage(String url) throws IOException {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(url));
        String response = request.execute().parseAsString();

        return response;
    }

    /**
     * Method to get a structured Arraylist of all entries of the API call
     */

    public ArrayList<Map<String, String>> getJson(String response) {

        // Create a Hashmap to store the individual values
        Map<String, String> values = new HashMap<String, String>();

        // Create ArrayList with the type of hashmap
        ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();

        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

        //JsonElement results = jsonObject.getAsJsonArray("results");

        JsonArray results = jsonObject.getAsJsonArray("results");

        System.out.println(results);

        for (JsonElement pa : results) {
            JsonObject paymentObj = pa.getAsJsonObject();

            String date = paymentObj.get("t").getAsString();

            values.put("date", date);
            values.put("open", paymentObj.get("o").getAsString());
            values.put("high", paymentObj.get("h").getAsString());
            values.put("low", paymentObj.get("l").getAsString());
            values.put("close", paymentObj.get("c").getAsString());
            values.put("volume", paymentObj.get("v").getAsString());
            data.add(values);
            values = new HashMap<String, String>();

            //String date = paymentObj.get("t").getAsString();
            // String open = paymentObj.get("o").getAsString();
            //String high = paymentObj.get("h").getAsString();
            //String low = paymentObj.get("l").getAsString();
            //String close = paymentObj.get("c").getAsString();
            //String volume = paymentObj.get("v").getAsString();
        }


        //JsonElement datenSatz = results.getAsJsonObject();


        return data;
    }

}
