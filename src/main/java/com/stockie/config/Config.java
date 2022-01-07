package com.stockie.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static String configfile = "./src/main/java/com/stockie/config/stockieConfig.properties";
    private static Properties properties = loadProperties();

    public static String getKey(String key){
        String keyName = (String) properties.get(key);
        throwExceptionWhenNull(key,keyName);
        return keyName;
    }

    public static String getInterval(String interval){
        String itervalName = (String) properties.get(interval);
        throwExceptionWhenNull(interval,itervalName);
        return itervalName;
    }

    public static String getIdentifier(String identifier){
        String identifierName = (String) properties.get(identifier);
        throwExceptionWhenNull(identifier,identifierName);
        return identifierName;
    }

    public static String getTableName(String table){
        String tableName = (String) properties.get(table);
        throwExceptionWhenNull(table,tableName);
        return tableName;
    }

    public static String getAssets(String assets){
        String assetsName = (String) properties.get(assets);
        throwExceptionWhenNull(assets,assetsName);
        return assetsName;
    }
    public static String getDbUrl(String DbUrl){
        String DbUrlName = (String) properties.get(DbUrl);
        throwExceptionWhenNull(DbUrl,DbUrlName);
        return DbUrlName;
    }
    public static String getDbUser(String DbUser){
        String DbUserName = (String) properties.get(DbUser);
        throwExceptionWhenNull(DbUser,DbUserName);
        return DbUserName;
    }
    public static String getDbPass(String DbPass){
        String DbPassName = (String) properties.get(DbPass);
        throwExceptionWhenNull(DbPass,DbPassName);
        return DbPassName;
    }

    private static void throwExceptionWhenNull(String property, String Parameter){
        if (Parameter == null){
            throw new RuntimeException("Parameter: "+property+"nicht in der Konfigurationsdatei gefunden");
        }
    }

    private static Properties loadProperties(){

            Properties props = new Properties();
        try{
            InputStream is = new FileInputStream(configfile);

            props.load(is);

            return props;
        } catch (Exception e){
            throw new RuntimeException("Keine Config gefunden", e);
        }

    }
}
