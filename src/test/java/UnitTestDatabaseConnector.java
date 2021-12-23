import com.stockie.API;
import com.stockie.DatabaseConnector;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class UnitTestDatabaseConnector {
    DatabaseConnector database = new DatabaseConnector();
    API api = new API();
    @Test
    public void uploadDataBaseUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int index = database.uploadData(data,"unitTestPrices",0);
        assertEquals(101,index);

    }

}
