package com.stockie;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AClassWithOneJUnitTest {

    @Test
    void getWebPageTestSymbol() throws IOException {

        API test = new API();
        String response = test.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=AAPL&interval=5min&apikey=1A79MCHMT69G16RE");
        JSONObject obj = new JSONObject(response);
        String metaData = obj.getJSONObject("Meta Data").get("2. Symbol").toString();
        assertEquals(metaData, "AAPL");
    System.out.println(metaData);

    }
}
