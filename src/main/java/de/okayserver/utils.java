package de.okayserver;

import de.okayserver.Users.User;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import java.io.*;
import java.util.Properties;

public class utils {


    private static int StatusRefresh;
    public static void StatusChange( JDA jda) {
        StatusRefresh++;
        if (StatusRefresh == 5) {
            jda.getPresence().setActivity(Activity.watching(User.UserList.size()  + " active Miner"));
            StatusRefresh = 0;
        }
    }

}
