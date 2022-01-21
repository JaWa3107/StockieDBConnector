import com.stockie.API;
import com.stockie.DatabaseConnector;
import com.stockie.config.Config;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Map;


public class UnitTestDatabaseConnector {
    DatabaseConnector database = new DatabaseConnector();
    API api = new API();
    Config config = new Config();

    // test to check if the upload was successful
    @Test
    public void uploadDataBaseUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int index = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), config.getDbUser("DbUser"), config.getDbPass("DbPass"));
        assertEquals(100,index);

    }
    // test to check if the upload with falseidentifier was successful
    @Test
    public void falseIdentifierUploadDataBaseUnitTest() throws IOException {

        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"///");
        int index = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), config.getDbUser("DbUser"), config.getDbPass("DbPass"));
        System.out.println(index);
        assertEquals(0,index);



    }
    // test to check if the Password was wrong
    @Test
    public void falseloginPasswordUnitTest() throws IOException {

        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int falsePass = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), config.getDbUser("DbUser"), "Passwort123");
        System.out.println(falsePass);
        assertEquals(0,falsePass);

    }
    // test to check if URL was wrong
    @Test
    public void falseloginUrlUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int falseUrl = database.uploadData(data,"unitTestPrices",0, "example.com", config.getDbUser("DbUser"), config.getDbPass("DbPass"));
        System.out.println(falseUrl);
        assertEquals(0,falseUrl);

    }
    // test to check if the Username was wrong
    @Test
    public void falseloginUserUnitTest() throws IOException {
        String testResponse = api.getWebPage("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo%22");
        ArrayList<Map<String, String>> data  = api.getJson(testResponse,"5min");
        int falseUser = database.uploadData(data,"unitTestPrices",0, config.getDbUrl("DbUrl"), "User1", config.getDbPass("DbPass"));
        System.out.println(falseUser);
        assertEquals(0,falseUser);

    }



}
