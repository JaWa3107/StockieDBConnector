import com.stockie.API;
import com.stockie.DatabaseConnector;
import com.stockie.config.Config;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class UnitTestDatabaseConnector {
    DatabaseConnector database = new DatabaseConnector();
    API api = new API();
    Config config = new Config();


    @Test
    public void uploadDataBaseUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int index = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), config.getDbUser("DbUser"), config.getDbPass("DbPass"));
        assertEquals(100,index);

    }
    @Test
    public void falseIdentifierUploadDataBaseUnitTest() throws IOException {

        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"///");
        int index = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), config.getDbUser("DbUser"), config.getDbPass("DbPass"));
        System.out.println(index);
        assertEquals(0,index);



    }
    @Test
    public void falseloginPasswordUnitTest() throws IOException {

        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int falsePass = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), config.getDbUser("DbUser"), "Passwort123");
        System.out.println(falsePass);
        assertEquals(0,falsePass);

    }
    @Test
    public void falseloginUrlUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int falseUrl = database.uploadData(data,"unitTestPrices",0, "example.com", config.getDbUser("DbUser"), config.getDbPass("DbPass"));
        System.out.println(falseUrl);
        assertEquals(0,falseUrl);

    }
    @Test
    public void falseloginUserUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int falseUser = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), "User1", config.getDbPass("DbPass"));
        System.out.println(falseUser);
        assertEquals(0,falseUser);

    }



}
