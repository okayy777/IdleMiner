package de.okayserver.SQL.Tables;

import de.okayserver.SQL.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class user {

    public static void UserTable() {
        PreparedStatement ps;
        try {
            ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS user (UUID VARCHAR(100) , " +
                    "ADMIN BOOLEAN , VIP BOOLEAN, TOKEN INT, LEVEL INT , XP INT, CREATED TIMESTAMP, PRIMARY KEY (UUID)");
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void InsertUser(String UUID , boolean Admin , boolean VIP , int Token , int Level , int XP , Timestamp date) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO user (UUID, ADMIN , VIP , TOKEN , LEVEL , XP , CREATED)" +
                    " VALUES (?,?,?,?,?,?,?");
            ps.setString(1, UUID);
            ps.setBoolean(2, Admin);
            ps.setBoolean(3, VIP);
            ps.setInt(4, Token);
            ps.setInt(5, Level);
            ps.setInt(6, XP);
            ps.setTimestamp(7 , date);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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

    public static boolean isAdmin(String UUID) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1, UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getBoolean("ADMIN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isVIP(String UUID) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1, UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getBoolean("VIP");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getToken(String UUID) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1, UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getInt("TOKEN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getLevel(String UUID) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1, UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getInt("LEVEL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int getXP(String UUID) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1, UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getInt("XP");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Timestamp getStartDate(String UUID) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from user WHERE UUID=?");
            ps.setString(1, UUID);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getTimestamp("Created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Timestamp.from(Instant.now());
    }

}
