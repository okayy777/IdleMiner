package de.okayserver.SQL;

import de.okayserver.properties.Properties;
import de.okayserver.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private static String host = Properties.PROPERTIES.get("DB.URL");
    private static String username = Properties.PROPERTIES.get("DB.USER");
    private static String password = Properties.PROPERTIES.get("DB.PASSWORD");
    private static String database = Properties.PROPERTIES.get("DB.DATABASE");
    private static String port = Properties.PROPERTIES.get("DB.PORT");

    public static boolean isIdle;

    public static Connection connection;

    public static boolean isConnected() {
        return (connection != null);
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/"
                    + database + "?usessl=" + false + "&autoReconnect=true", username , password);
        }
    }
    public static void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        isIdle = false;

        return connection;
    }

}
