package de.okayserver;

import de.okayserver.Users.User;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import java.awt.*;
import java.io.*;
import java.util.Properties;

public class utils {


    private static int StatusRefresh;
    public static void StatusChange( JDA jda) {
        StatusRefresh++;
        if (StatusRefresh == 10) {
            jda.getPresence().setActivity(Activity.watching(User.UserList.size()  + " active Miner"));
            StatusRefresh = 0;
        }
    }


    public static int ColorChange(String Input) {
        int color = 0;
        if (Input.equalsIgnoreCase("BLACK")) {
            color = Color.BLACK.getRGB();
        } else if (Input.equalsIgnoreCase("BLUE")) {
            color = Color.BLUE.getRGB();
        }else if (Input.equalsIgnoreCase("CYAN")) {
            color = Color.CYAN.getRGB();
        }else if (Input.equalsIgnoreCase("DARK_GREY")) {
            color = Color.DARK_GRAY.getRGB();
        }else if (Input.equalsIgnoreCase("GRAY")) {
            color = Color.GRAY.getRGB();
        }else if (Input.equalsIgnoreCase("LIGHT_GRAY")) {
            color = Color.LIGHT_GRAY.getRGB();
        }else if (Input.equalsIgnoreCase("GREEN")) {
            color = Color.GREEN.getRGB();
        }else if (Input.equalsIgnoreCase("MAGENTA")) {
            color = Color.MAGENTA.getRGB();
        }else if (Input.equalsIgnoreCase("ORANGE")) {
            color = Color.ORANGE.getRGB();
        }else if (Input.equalsIgnoreCase("PINK")) {
            color = Color.PINK.getRGB();
        }else if (Input.equalsIgnoreCase("RED")) {
            color = Color.RED.getRGB();
        }else if (Input.equalsIgnoreCase("WHITE")) {
            color = Color.WHITE.getRGB();
        }else if (Input.equalsIgnoreCase("YELLOW")) {
            color = Color.YELLOW.getRGB();
        }else if (Input.equalsIgnoreCase("Costum1")) {
            color = Color.decode("#00ffa2").getRGB(); // GrünBlau
        } else if (Input.equalsIgnoreCase("Costum2")) {
            color = Color.decode("#ff3c00").getRGB(); // Orange
        }else if (Input.equalsIgnoreCase("Costum3")) {
            color = Color.decode("#a1c5ff").getRGB(); // Hellblau
        }else if (Input.equalsIgnoreCase("Costum4")) {
            color = Color.decode("#a2ff00").getRGB(); // Neon Grün
        }else if (Input.equalsIgnoreCase("Costum5")) {
            color = Color.decode("#85ff8d").getRGB(); // Hellgrünblau ??
        }else {
            System.out.println("not Found");
        }
        return color;
    }

}
