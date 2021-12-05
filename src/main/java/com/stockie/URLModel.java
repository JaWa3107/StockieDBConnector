package com.stockie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class URLModel {

    protected String key;
    protected String asset;
    protected String interval;
    protected String function;
    protected String url;

    LinkedHashMap<String, String> assetUrls = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> assetUrlsHistroy = new LinkedHashMap<String, String>();

    /**

     Class with getter and setter for the ALPHAVANTAGE URL

     */

    public URLModel (){

    }

    public URLModel (String key, String interval){
        this.key = key;
        //this.asset = asset;
        this.interval = interval;
        //this.function = function;
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

    public LinkedHashMap<String, String> getAssetUrls(){
        setUrls();
        return this.assetUrls;
    }

    public LinkedHashMap<String, String> getAssetUrlsHistroy(){
        setUrls();
        return this.assetUrlsHistroy;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAssets() {
        this.assetUrls.put("AAPL", "");
        this.assetUrls.put("MSFT", "");
        this.assetUrls.put("TSLA", "");
        this.assetUrls.put("NVDA", "");
        this.assetUrls.put("AMZN", "");
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setUrls() {

        for (String keys : assetUrls.keySet())
        {

            String assetKey = keys;
            setFunction("TIME_SERIES_INTRADAY");
            String url ="https://www.alphavantage.co/query?function="+function+"&symbol="+assetKey+"&interval="+ interval+"&apikey="+key;
            setFunction("TIME_SERIES_DAILY");
            String url2 ="https://www.alphavantage.co/query?function="+function+"&symbol="+assetKey+"&apikey="+key;

            this.assetUrls.put(assetKey, url);
            this.assetUrlsHistroy.put(assetKey, url2);
        }

    }

}
//