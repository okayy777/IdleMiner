package de.okayserver.SQL.Tables.Mines;

import de.okayserver.SQL.MySQL;
import de.okayserver.Users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

public class mines {

    public static void MineTable(String Name) {
        PreparedStatement ps;
        try {
            ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS " + Name +"mine" + " (UUID VARCHAR(100), CASH DOUBLE, COLLECTED TIMESTAMP, PRESTIGE INT, " +
                    "SHOP INT , ELEVATOR INT , MINER1 INT, MINER2 INT,MINER3 INT,MINER4 INT,MINER5 INT,MINER6 INT,MINER7 INT, MINER8 INT," +
                    "MINER9 INT,MINER10 INT,MINER11 INT,MINER12 INT,MINER13 INT, MINER14 INT, MINER15 INT, MINER16 INT, MINER17 INT," +
                    " MINER18 INT, MINER19 INT, MINER20 INT, MINER21 INT, MINER22 INT, MINER23 INT, MINER24 INT, MINER25 INT, PRIMARY KEY (UUID))");
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addUser(User u , String Mine) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO "+ Mine + "mine (UUID, CASH,  PRESTIGE , SHOP , ELEVATOR , MINER1 , COLLECTED)" +
                    " VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, u.getUUID());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setInt(6, 1);
            ps.setTimestamp(7, Timestamp.from(Instant.now()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getInfo(User u , String Mine ,String Info) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * from "+Mine + "mine" +" WHERE UUID=?");
            ps.setString(1, u.getUUID());
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                return results.getInt(Info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void updateInfo(User u , String Mine , String Info , int Level ) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE "+Mine+ "mine SET "+ Info+"=? WHERE UUID=?");
            ps.setInt(1 , Level);
            ps.setString(2 , u.getUUID());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateCash(User u , String Mine , double CASH ) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE "+Mine+ "mine SET CASH=? WHERE UUID=?");
            ps.setDouble(1 , CASH);
            ps.setString(2 , u.getUUID());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
