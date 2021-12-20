package com.stockie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class UnitTestAPI {
    API testResponse = new API();

    @Test
    public void getAPIResponseTest() throws IOException {
        MockData getMockDataResponse = new MockData();
        String test = testResponse.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        assertEquals(test, getMockDataResponse.getJSONResponseMock());
    }
}
