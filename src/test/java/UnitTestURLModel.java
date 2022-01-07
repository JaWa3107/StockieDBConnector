
import com.stockie.MockData;
import com.stockie.URLModel;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

    public class UnitTestURLModel {
        URLModel url = new URLModel("1A79MCHMT69G16RE", "1min", "AAPL,MSFT,TSLA,NVDA,AMZN");
        MockData urlMock = new MockData();

        @Test
        public void getAssetUrlsUnitTest(){
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


        @Test
        public void getAssetUrlsHistoryUnitTest(){
            LinkedHashMap<String, String> actualHistoryUrls = url.getAssetUrlsHistory();
            ArrayList<String> expectedHistoryUrls = urlMock.getHistoryUrlMock();

            int i = 0;
            for (String keys : actualHistoryUrls.keySet())
            {
                System.out.println(actualHistoryUrls.get(keys));
                assertEquals(expectedHistoryUrls.get(i),actualHistoryUrls.get(keys) );
                i++;
            }

        }

    }
