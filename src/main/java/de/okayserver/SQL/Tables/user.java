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

    public static void InsertUser(String UUID , boolean Admin , boolean VIP , int Tokens , int Level , int XP ) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO user (UUID, ADMIN , VIP , TOKENS , LEVEL , XP)" +
                    " VALUES (?,?,?,?,?,?");
            ps.setString(1, UUID);
            ps.setBoolean(2, Admin);
            ps.setBoolean(3, VIP);
            ps.setInt(4, Tokens);
            ps.setInt(5, Level);
            ps.setInt(6, XP);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
