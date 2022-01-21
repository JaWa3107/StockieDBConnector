package com.stockie;


import java.util.ArrayList;


public class MockData {

    public ArrayList<String> getUrlMock() {
        ArrayList<String> expectedUrls = new ArrayList<String>();

        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=AAPL&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=TSLA&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=NVDA&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=AMZN&interval=1min&outputsize=full&apikey=1A79MCHMT69G16RE");

        return expectedUrls;

    }

    public ArrayList<String> getHistoryUrlMock() {
        ArrayList<String> expectedHistoryUrls = new ArrayList<String>();

        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=AAPL&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=TSLA&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=NVDA&outputsize=full&apikey=1A79MCHMT69G16RE");
        expectedHistoryUrls.add("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=AMZN&outputsize=full&apikey=1A79MCHMT69G16RE");

        return expectedHistoryUrls;

    }

    public String getJSONDataResponse() {
        String parsedJSONResponse = "[{date=2021-12-17 13:55:00, volume=46906, high=128.5600, low=128.4350, close=128.4450, open=128.5500}, {date=2021-12-17 11:40:00, volume=49166, high=128.0400, low=127.8000, close=127.8950, open=128.0100}, {date=2021-12-17 14:25:00, volume=98421, high=128.0300, low=127.8201, close=128.0300, open=127.8815}, {date=2021-12-17 08:15:00, volume=200, high=124.8000, low=124.8000, close=124.8000, open=124.8000}, {date=2021-12-17 18:15:00, volume=212, high=127.5000, low=127.5000, close=127.5000, open=127.5000}, {date=2021-12-17 16:00:00, volume=387455, high=127.5800, low=127.3000, close=127.3999, open=127.3700}, {date=2021-12-17 10:35:00, volume=140574, high=128.4800, low=125.8700, close=128.4300, open=128.0000}, {date=2021-12-17 15:30:00, volume=54631, high=128.1000, low=127.7900, close=127.9050, open=128.0700}, {date=2021-12-17 11:05:00, volume=61979, high=128.2008, low=127.8569, close=127.8600, open=127.9790}, {date=2021-12-17 13:00:00, volume=55881, high=128.1900, low=127.7800, close=128.1500, open=127.9274}, {date=2021-12-17 14:45:00, volume=44641, high=128.0600, low=127.9100, close=127.9886, open=127.9900}, {date=2021-12-17 12:30:00, volume=40265, high=127.4832, low=127.3100, close=127.4300, open=127.4200}, {date=2021-12-17 13:35:00, volume=46522, high=128.3700, low=128.1500, close=128.3310, open=128.3200}, {date=2021-12-17 14:05:00, volume=41153, high=128.6400, low=128.4900, close=128.5902, open=128.5101}, {date=2021-12-17 09:05:00, volume=530, high=125.7200, low=125.6400, close=125.7200, open=125.6400}, {date=2021-12-17 08:10:00, volume=3203, high=125.3600, low=124.8900, close=124.8900, open=125.3600}, {date=2021-12-17 08:35:00, volume=175, high=125.3000, low=125.3000, close=125.3000, open=125.3000}, {date=2021-12-17 15:15:00, volume=49995, high=127.9600, low=127.7609, close=127.8050, open=127.9600}, {date=2021-12-17 15:50:00, volume=196603, high=127.3900, low=127.1100, close=127.1103, open=127.2701}, {date=2021-12-17 16:55:00, volume=1535, high=127.4700, low=127.1500, close=127.1500, open=127.4700}, {date=2021-12-17 10:55:00, volume=68029, high=127.9500, low=127.5700, close=127.9000, open=127.9400}, {date=2021-12-17 11:25:00, volume=71368, high=128.2300, low=128.0600, close=128.1315, open=128.2200}, {date=2021-12-17 11:00:00, volume=80123, high=128.0800, low=127.6600, close=127.9785, open=127.9000}, {date=2021-12-17 13:20:00, volume=44303, high=128.2000, low=127.9900, close=128.1768, open=128.0318}, {date=2021-12-17 09:00:00, volume=451, high=125.5000, low=125.5000, close=125.5000, open=125.5000}, {date=2021-12-17 12:50:00, volume=38732, high=127.9900, low=127.7730, close=127.9000, open=127.8094}, {date=2021-12-17 13:30:00, volume=68291, high=128.3700, low=128.2000, close=128.3150, open=128.3100}, {date=2021-12-17 13:05:00, volume=55316, high=128.2296, low=128.0704, close=128.1750, open=128.1500}, {date=2021-12-17 16:40:00, volume=885, high=127.7000, low=127.7000, close=127.7000, open=127.7000}, {date=2021-12-17 19:50:00, volume=305, high=127.7700, low=127.7700, close=127.7700, open=127.7700}, {date=2021-12-17 12:25:00, volume=38776, high=127.4600, low=127.2500, close=127.4400, open=127.2500}, {date=2021-12-17 10:10:00, volume=203364, high=127.7800, low=127.1400, close=127.4750, open=127.1400}, {date=2021-12-17 09:35:00, volume=768386, high=125.9200, low=125.2093, close=125.5500, open=125.8700}, {date=2021-12-17 14:10:00, volume=43861, high=128.5950, low=128.2650, close=128.3000, open=128.5917}, {date=2021-12-17 09:50:00, volume=142354, high=126.8000, low=126.2500, close=126.5650, open=126.5700}, {date=2021-12-17 15:55:00, volume=197620, high=127.4450, low=127.1200, close=127.3800, open=127.1200}, {date=2021-12-17 19:45:00, volume=130, high=127.7700, low=127.7700, close=127.7700, open=127.7700}, {date=2021-12-17 13:50:00, volume=71367, high=128.5700, low=128.3400, close=128.5500, open=128.3400}, {date=2021-12-17 11:45:00, volume=37365, high=128.0918, low=127.8500, close=127.9450, open=127.9000}, {date=2021-12-17 10:40:00, volume=93027, high=128.4400, low=128.0000, close=128.0050, open=128.4300}, {date=2021-12-17 09:55:00, volume=147080, high=127.1700, low=126.4000, close=126.8400, open=126.5200}, {date=2021-12-17 14:55:00, volume=33327, high=128.0800, low=127.9200, close=127.9200, open=128.0800}, {date=2021-12-17 11:20:00, volume=65423, high=128.3500, low=128.1600, close=128.2300, open=128.3100}, {date=2021-12-17 13:25:00, volume=87535, high=128.3100, low=128.1600, close=128.3100, open=128.1850}, {date=2021-12-17 14:30:00, volume=48911, high=128.0500, low=127.8600, close=127.8800, open=128.0100}, {date=2021-12-17 10:15:00, volume=92286, high=127.6199, low=127.3450, close=127.4700, open=127.4500}, {date=2021-12-17 09:30:00, volume=2288, high=126.0000, low=125.8700, close=125.9900, open=125.8700}, {date=2021-12-17 15:35:00, volume=81579, high=127.9300, low=127.5100, close=127.5500, open=127.9200}, {date=2021-12-17 15:10:00, volume=50449, high=127.9900, low=127.7400, close=127.9900, open=127.7900}, {date=2021-12-17 12:45:00, volume=34773, high=127.9000, low=127.7300, close=127.7900, open=127.7500}, {date=2021-12-17 18:20:00, volume=265, high=127.5000, low=127.5000, close=127.5000, open=127.5000}, {date=2021-12-17 11:15:00, volume=77484, high=128.3300, low=128.0400, close=128.2800, open=128.0700}, {date=2021-12-17 14:50:00, volume=55026, high=128.1483, low=127.9760, close=128.1000, open=127.9760}, {date=2021-12-17 10:45:00, volume=92779, high=128.0400, low=127.4700, close=127.5400, open=127.9900}, {date=2021-12-17 15:20:00, volume=77288, high=128.0500, low=127.8500, close=127.9900, open=127.8500}, {date=2021-12-17 08:40:00, volume=350, high=125.4000, low=125.3500, close=125.4000, open=125.3500}, {date=2021-12-17 12:20:00, volume=46486, high=127.3699, low=127.0950, close=127.2400, open=127.1300}, {date=2021-12-17 13:45:00, volume=42022, high=128.3700, low=128.2600, close=128.3400, open=128.3700}, {date=2021-12-17 12:00:00, volume=72826, high=127.9000, low=127.7476, close=127.8900, open=127.9000}, {date=2021-12-17 11:50:00, volume=106144, high=127.9800, low=127.6800, close=127.8200, open=127.9393}, {date=2021-12-17 14:15:00, volume=55284, high=128.3000, low=127.9700, close=127.9700, open=128.2900}, {date=2021-12-17 18:25:00, volume=301, high=127.5500, low=127.5000, close=127.5500, open=127.5000}, {date=2021-12-17 08:25:00, volume=601, high=125.0500, low=125.0100, close=125.0500, open=125.0100}, {date=2021-12-17 10:25:00, volume=141020, high=128.1700, low=127.8400, close=127.9350, open=127.8850}, {date=2021-12-17 15:40:00, volume=177193, high=127.5500, low=127.2301, close=127.2800, open=127.5400}, {date=2021-12-17 16:10:00, volume=162291, high=127.4000, low=125.8700, close=127.4000, open=127.4000}, {date=2021-12-17 17:15:00, volume=196, high=127.7000, low=127.7000, close=127.7000, open=127.7000}, {date=2021-12-17 13:10:00, volume=40381, high=128.2000, low=128.0600, close=128.1100, open=128.1700}, {date=2021-12-17 11:10:00, volume=50732, high=128.1900, low=127.8700, close=128.0300, open=127.8700}, {date=2021-12-17 12:40:00, volume=41085, high=127.7930, low=127.6300, close=127.7600, open=127.7200}, {date=2021-12-17 12:05:00, volume=68641, high=127.8800, low=127.5500, close=127.6900, open=127.8800}, {date=2021-12-17 11:35:00, volume=66949, high=128.2100, low=127.9900, close=127.9900, open=128.1200}, {date=2021-12-17 14:35:00, volume=48459, high=127.9231, low=127.7200, close=127.8100, open=127.8600}, {date=2021-12-17 08:45:00, volume=100, high=125.3200, low=125.3200, close=125.3200, open=125.3200}, {date=2021-12-17 18:05:00, volume=140, high=127.5000, low=127.5000, close=127.5000, open=127.5000}, {date=2021-12-17 15:05:00, volume=57877, high=127.8300, low=127.6500, close=127.7800, open=127.6600}, {date=2021-12-17 10:20:00, volume=94445, high=127.9000, low=127.4100, close=127.9000, open=127.4400}, {date=2021-12-17 14:00:00, volume=40622, high=128.5400, low=128.4176, close=128.4911, open=128.4400}, {date=2021-12-17 12:35:00, volume=41457, high=127.8900, low=127.4300, close=127.7300, open=127.4400}, {date=2021-12-17 11:55:00, volume=43801, high=128.0300, low=127.8300, close=127.9050, open=127.8300}, {date=2021-12-17 19:35:00, volume=2002, high=127.5100, low=127.5100, close=127.5100, open=127.5100}, {date=2021-12-17 10:30:00, volume=108239, high=128.0900, low=127.8700, close=128.0300, open=127.9200}, {date=2021-12-17 09:45:00, volume=116583, high=126.6200, low=125.7200, close=126.5990, open=125.9600}, {date=2021-12-17 16:05:00, volume=271961, high=127.4000, low=127.4000, close=127.4000, open=127.4000}, {date=2021-12-17 13:40:00, volume=42279, high=128.4245, low=128.3300, close=128.3750, open=128.3322}, {date=2021-12-17 10:00:00, volume=151369, high=127.2300, low=126.6100, close=127.1800, open=126.8100}, {date=2021-12-17 14:20:00, volume=50400, high=127.9700, low=127.8700, close=127.8900, open=127.9500}, {date=2021-12-17 12:15:00, volume=55156, high=127.3780, low=127.1300, close=127.1400, open=127.3000}, {date=2021-12-17 20:00:00, volume=310, high=127.5100, low=127.5100, close=127.5100, open=127.5100}, {date=2021-12-17 15:25:00, volume=45713, high=128.1700, low=127.9700, close=128.0750, open=128.0000}, {date=2021-12-17 12:55:00, volume=52676, high=128.0150, low=127.8810, close=127.9400, open=127.8974}, {date=2021-12-17 15:00:00, volume=56321, high=127.9100, low=127.6700, close=127.6700, open=127.9100}, {date=2021-12-17 10:50:00, volume=94289, high=127.9800, low=127.4600, close=127.9471, open=127.5700}, {date=2021-12-17 14:40:00, volume=37613, high=127.9800, low=127.8100, close=127.9700, open=127.8100}, {date=2021-12-17 13:15:00, volume=37625, high=128.1650, low=128.0000, close=128.0300, open=128.1200}, {date=2021-12-17 11:30:00, volume=50514, high=128.2300, low=128.0800, close=128.1270, open=128.1150}, {date=2021-12-17 15:45:00, volume=99775, high=127.5500, low=127.2900, close=127.2900, open=127.3000}, {date=2021-12-17 12:10:00, volume=63199, high=127.7400, low=127.2800, close=127.2851, open=127.7000}, {date=2021-12-17 10:05:00, volume=101019, high=127.2400, low=126.8900, close=127.1400, open=127.1400}, {date=2021-12-17 09:40:00, volume=162326, high=126.1450, low=125.5000, close=126.0100, open=125.6018}]";


        return parsedJSONResponse;
    }

    public String getCompanyNameMock() {
        String company = "IBM";
        return company;
    }


}
