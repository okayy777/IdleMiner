package de.okayserver.properties;

import java.io.*;
import java.util.HashMap;

public class Properties {

    public static HashMap<String, String> PROPERTIES = new HashMap<String, String>();
    public static void create() {
        if (!new File("config.properties").exists()) {
            try (OutputStream output = new FileOutputStream("config.properties")) {
                java.util.Properties prop = new java.util.Properties();
                prop.setProperty("token", "INSERTTOKEN");
                prop.setProperty("db.url", "localhost");
                prop.setProperty("db.user", "username");
                prop.setProperty("db.password", "password");
                prop.setProperty("db.port", "3306");
                prop.setProperty("db.database", "database");

                prop.store(output, null);
                System.out.println(prop);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Config found");
        }
    }

    public static void load() {
        try (InputStream input = new FileInputStream("config.properties")) {
            java.util.Properties prop = new java.util.Properties();
            prop.load(input);
            PROPERTIES.put("TOKEN" , prop.getProperty("token"));
            PROPERTIES.put("DB.USER" , prop.getProperty("db.user"));
            PROPERTIES.put("DB.PASSWORD" , prop.getProperty("db.password"));
            PROPERTIES.put("DB.PORT" , prop.getProperty("db.port"));
            PROPERTIES.put("DB.URL" , prop.getProperty("db.url"));
            PROPERTIES.put("DB.DATABASE" , prop.getProperty("db.database"));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
