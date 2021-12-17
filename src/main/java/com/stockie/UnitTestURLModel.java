package com.stockie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

    public class UnitTestURLModel {
        @Test
        public void getAssetUrlsUnitTest(){

            URLModel url = new URLModel("1A79MCHMT69G16RE", "1min");
            MockData urlMock = new MockData();

            LinkedHashMap<String, String> actualUrls = url.getAssetUrls();
            ArrayList<String> expectedUrls = urlMock.getUrlMock();

            int i = 0;
            for (String keys : actualUrls.keySet())
            {
                System.out.println(actualUrls.get(keys));
                assertEquals(expectedUrls.get(i),actualUrls.get(keys) );
                i++;
            }

        }

    }
