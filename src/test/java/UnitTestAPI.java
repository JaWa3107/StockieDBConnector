


import com.stockie.API;
import com.stockie.MockData;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

public class UnitTestAPI {
    API testResponse = new API();
    MockData mockData = new MockData();
    // test to check if the API Call was valid
    @Test
    public void validAPICall() throws IOException {

        String test = testResponse.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        System.out.println(test);
        assertTrue(test.contains(mockData.getCompanyNameMock()));
    }
    // test to check if the API Call was incorrect
    @Test
    public void wrongAPICall() throws IOException {
        String test = testResponse.getWebPage("https://world.openfoodfacts.org/api/v0/product/737628064502.json");
        System.out.println(test);
        assertEquals("Keine gültige API.", test);
    }
    // test to check if the response was right
    @Test
    public void JSONResponseTest() throws IOException {
        ArrayList<Map<String, String>> data = testResponse.getJson(testResponse.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22"), "5min");
        String test = data.toString();
        System.out.println(test);
        ArrayList<String> value = new ArrayList<String>();
        value.add("date=");
        value.add("volume=");
        value.add("high=");
        value.add("low=");
        value.add("close=");
        value.add("open=");

        for(int i = 0; i <value.size();i++)  assertTrue(test.contains(value.get(i)));

       // assertTrue(test.contains("date="));


    }


}
