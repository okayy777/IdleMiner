package de.okayserver.Users;

import java.sql.Timestamp;
import java.util.HashMap;

public class User {

    public static HashMap<String , User> UserList = new HashMap<>();

    private String UUID;
    private boolean Admin;
    private boolean VIP;
    private int Token;
    private int Level;
    private int XP;

    private Timestamp started;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public int getToken() {
        return Token;
    }

    public void setToken(int token) {
        Token = token;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public Timestamp getStarted() {
        return started;
    }

    public void setStarted(Timestamp started) {
        this.started = started;
    }
}
