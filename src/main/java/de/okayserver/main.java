package de.okayserver;


import com.mysql.cj.protocol.MessageListener;
import de.okayserver.SQL.MySQL;
import de.okayserver.properties.Properties;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class main {
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

        if (MySQL.isConnected()) {
            // create Tables
        }

        ActivityChanged = false;
        StatusChanged = false;

        String TOKEN = Properties.PROPERTIES.get("TOKEN");
        if (!TOKEN.equalsIgnoreCase("INSERTTOKEN")) {
            jda = JDABuilder.createDefault(TOKEN, GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                            GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.DIRECT_MESSAGE_REACTIONS, GatewayIntent.GUILD_MESSAGE_REACTIONS)
                    .setActivity(Activity.watching("Starting"))
                    .setStatus(OnlineStatus.INVISIBLE)
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
        }
    }

}
