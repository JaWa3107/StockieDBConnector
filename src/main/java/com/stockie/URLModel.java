package com.stockie;

import java.util.ArrayList;
import java.util.HashMap;

public class URLModel {

    protected String key;
    protected String asset;
    protected String interval;
    protected String function;
    protected String url;

    HashMap<String, String> assetUrls = new HashMap<String, String>();

    /**

     Class with getter and setter for the ALPHAVANTAGE URL

     */

    public URLModel (){

    }

    public URLModel (String key, String interval, String function){
        this.key = key;
        //this.asset = asset;
        this.interval = interval;
        this.function = function;
        setAssets();

    }



    public String getKey(){
        return key;
    }

    public String getAsset(){
        return asset;
    }

    public String getInterval(){
        return interval;
    }

    public String getFunction(){
        return function;
    }

    public HashMap<String, String> getUrls(){
        setUrls();
        return this.assetUrls;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAssets() {
        this.assetUrls.put("AAPL", "");
        this.assetUrls.put("MSFT", "");
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setUrls() {

        for (String variableName : assetUrls.keySet())
        {

            String variableKey = variableName;
            String url ="https://www.alphavantage.co/query?function="+function+"&symbol="+variableKey+"&interval="+ interval+"&apikey="+key;
            this.assetUrls.put(variableKey, url);
        }

    }

}
