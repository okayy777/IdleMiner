package de.okayserver.SQL.Tables;

import de.okayserver.SQL.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user {

    public static void UserTable() {
        PreparedStatement ps;
        try {
            ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS user (UUID VARCHAR(100) , " +
                    "ADMIN BOOLEAN , VIP BOOLEAN, TOKENS INT, LEVEL INT , XP INT, PRIMARY KEY (UUID)");
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean UUIDexists(String UUID) {
        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1 , UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()){
                return true;

            } else {
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
