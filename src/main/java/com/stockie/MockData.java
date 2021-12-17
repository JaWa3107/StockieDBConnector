package com.stockie;

import java.util.ArrayList;

public class MockData {

    public ArrayList<String> getUrlMock(){
        ArrayList<String>  expectedUrls = new ArrayList<String>();

        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=AAPL&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=TSLA&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=NVDA&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=AMZN&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");

        return expectedUrls;

    }
    public ArrayList<String> getHistoryUrlMock(){
        ArrayList<String>  expectedHistoryUrls = new ArrayList<String>();

        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=AAPL&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=TSLA&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=NVDA&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=AMZN&outputsize=full&apikey=1A79MCHMT69G16RE");

        return expectedHistoryUrls;

    }

}
