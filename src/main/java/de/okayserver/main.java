package de.okayserver;


import de.okayserver.SQL.MySQL;
import de.okayserver.SQL.Tables.user;
import de.okayserver.properties.Properties;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class main {
    public static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    public static JDA jda;
    public static boolean StatusChanged;
    public static boolean ActivityChanged;

    public static void main(String[] args) throws LoginException {

        Properties.create();
        Properties.load();


        try {
            MySQL.connect();
        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }

        if (MySQL.isConnected()) { // create Tables
            user.UserTable();


        }

        ActivityChanged = false;
        StatusChanged = false;

        String TOKEN = Properties.PROPERTIES.get("TOKEN");
        if (!TOKEN.equalsIgnoreCase("INSERTTOKEN")) {
            jda = JDABuilder.createDefault(TOKEN, GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                            GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.DIRECT_MESSAGE_REACTIONS, GatewayIntent.GUILD_MESSAGE_REACTIONS)
                    .setActivity(Activity.watching("0 active Miner"))
                    .setStatus(OnlineStatus.ONLINE)
                    .disableCache(
                            CacheFlag.ACTIVITY,
                            CacheFlag.VOICE_STATE,
                            CacheFlag.CLIENT_STATUS
                    )
                    .disableIntents(
                            GatewayIntent.GUILD_VOICE_STATES,
                            GatewayIntent.GUILD_PRESENCES,
                            GatewayIntent.GUILD_MEMBERS
                    )
                    .setChunkingFilter(ChunkingFilter.NONE)
                    .addEventListeners(new MessageListener())
                    .build();

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    utils.StatusChange(jda);
                }
            };

            scheduler.scheduleAtFixedRate(run , 4 , 1 , TimeUnit.SECONDS);
        }
    }

}
