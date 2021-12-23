package com.stockie;


import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.*;

public class UnitTestAPI {
    API testResponse = new API();
    MockData mockData = new MockData();
    @Test
    public void validAPICall() throws IOException {

        String test = testResponse.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        assertTrue(test.contains(mockData.getCompanyNameMock()));
    }
    @Test
    public void wrongAPICall() throws IOException {
        String test = testResponse.getWebPage("https://world.openfoodfacts.org/api/v0/product/737628064502.json");
        assertEquals("Keine gültige API.", test);
    }
    @Test
    public void JSONResponseTest() throws IOException {
        ArrayList<Map<String, String>> data  = testResponse.getJson(testResponse.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22"),"5min");
       String test = data.toString();
        System.out.println(test);

        assertTrue(test.contains("date="));

    }

}
