package com.stockie;
import java.util.LinkedHashMap;

public class URLModel {

    protected String key;
    protected String interval;
    protected String function;


    LinkedHashMap<String, String> assetUrls = new LinkedHashMap<String, String>();
    LinkedHashMap<String, String> assetUrlsHistroy = new LinkedHashMap<String, String>();

    /**

     Class with getter and setter for the ALPHAVANTAGE URL

     */

    public URLModel (String key, String interval){
        this.key = key;
        this.interval = interval;
        setAssets();

    }

    public LinkedHashMap<String, String> getAssetUrls(){
        setUrls();
        return this.assetUrls;
    }

    public LinkedHashMap<String, String> getAssetUrlsHistroy(){
        setUrls();
        return this.assetUrlsHistroy;
    }

    public void setAssets() {
        this.assetUrls.put("AAPL", "");
        this.assetUrls.put("MSFT", "");
        this.assetUrls.put("TSLA", "");
        this.assetUrls.put("NVDA", "");
        this.assetUrls.put("AMZN", "");
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
            this.assetUrlsHistroy.put(assetKey, url2);
        }

    }

}
