package com.stockie;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class URLModel {

    protected String key;
    protected String interval;
    protected String function;
    protected String assets;


    LinkedHashMap<String, String> assetUrls = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> assetUrlsHistory = new LinkedHashMap<String, String>();


    /**

     Class with getter and setter for the ALPHAVANTAGE URL

     */

    public URLModel (String key, String interval, String assets){
        this.key = key;
        this.interval = interval;
        this.assets = assets;
        init();
    }

    public void init(){
        setAssets();
        setUrls();

    }

    public LinkedHashMap<String, String> getAssetUrls(){
        return this.assetUrls;
    }

    public LinkedHashMap<String, String> getAssetUrlsHistory(){
        return this.assetUrlsHistory;
    }

    public void setAssets() {

        List<String> listOfAssets = Arrays.asList(this.assets.split(","));

        for( int i = 0; i < listOfAssets.size(); i++ ) {
            this.assetUrls.put(listOfAssets.get(i), "");
        }
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setUrls() {

        for (String keys : assetUrls.keySet())
        {

            String assetKey = keys;
            setFunction("TIME_SERIES_INTRADAY");
            String url ="https://www.alphavantage.co/query?function="+function+"&symbol="+assetKey+"&interval="+ interval+"&outputsize=full&apikey="+key;
            setFunction("TIME_SERIES_DAILY");
            String url2 ="https://www.alphavantage.co/query?function="+function+"&symbol="+assetKey+"&outputsize=full&apikey="+key;

            this.assetUrls.put(assetKey, url);
            this.assetUrlsHistory.put(assetKey, url2);
        }

    }

}
