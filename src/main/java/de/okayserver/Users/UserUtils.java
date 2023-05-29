package de.okayserver.Users;

import de.okayserver.SQL.Tables.Mines.mines;
import de.okayserver.SQL.Tables.user;

import java.sql.Timestamp;
import java.time.Instant;

public class UserUtils {

    public static void addUsers(){
        for (String uuid : user.UUIDs()) {
            User u = new User();
            u.setUUID(uuid);
            u.setAdmin(user.isAdmin(uuid));
            u.setVIP(user.isVIP(uuid));
            u.setToken(user.getToken(uuid));
            u.setLevel(user.getLevel(uuid));
            u.setXP(user.getXP(uuid));
            User.UserList.put(uuid , u);
        }
    }

    public static void createUser(String uuid) {
        if (!user.UUIDexists(uuid)) {
            user.InsertUser(uuid , false , false , 0 , 1 , 0, Timestamp.from(Instant.now()));


            User u = new User();
            u.setUUID(uuid);
            u.setAdmin(user.isAdmin(uuid));
            u.setVIP(user.isVIP(uuid));
            u.setToken(user.getToken(uuid));
            u.setLevel(user.getLevel(uuid));
            u.setXP(user.getXP(uuid));
            mines.addUser(u , "Coal");
            User.UserList.put(uuid , u);
        }
    }

    public static void updateUsers() {
        for (User u : User.UserList.values()) {
            user.UpdateUser(u);
        }
    }
}
