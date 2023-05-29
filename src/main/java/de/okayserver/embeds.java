package de.okayserver;

import de.okayserver.SQL.Tables.Mines.mines;
import de.okayserver.Users.User;
import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static de.okayserver.utils.ColorChange;

public class embeds {


    public static MessageEmbed BasicEmbed(String title , String description  , String Author, String Color) {

        MessageEmbed.Thumbnail thumbnail = new MessageEmbed.Thumbnail("http://localhost" , "none" , 60 , 60);
        MessageEmbed.Provider provider = new MessageEmbed.Provider("none" , "http://localhost" );
        MessageEmbed.AuthorInfo author = new MessageEmbed.AuthorInfo("","" , "" , "");
        MessageEmbed.VideoInfo videoInfo = new MessageEmbed.VideoInfo("http://localhost" , 0 , 0);
        MessageEmbed.Footer footer = new MessageEmbed.Footer(Author , "" , "");
        MessageEmbed.ImageInfo image = new MessageEmbed.ImageInfo("" , "" , 0 , 0);
        //MessageEmbed.Field field = new MessageEmbed.Field("" , "" , false);
        List<MessageEmbed.Field> fields = new ArrayList<MessageEmbed.Field>();
        //fields.add(field);
        int color = ColorChange(Color);
        MessageEmbed embed = new MessageEmbed("" , title , description ,
                EmbedType.AUTO_MODERATION , OffsetDateTime.now() , color , thumbnail ,provider ,author ,videoInfo ,footer ,image, fields);
        return embed;
    }

    public static MessageEmbed CoalMine(String UUID, String Author) {

        MessageEmbed.Thumbnail thumbnail = new MessageEmbed.Thumbnail("http://localhost" , "none" , 60 , 60);
        MessageEmbed.Provider provider = new MessageEmbed.Provider("none" , "http://localhost" );
        MessageEmbed.AuthorInfo author = new MessageEmbed.AuthorInfo("","" , "" , "");
        MessageEmbed.VideoInfo videoInfo = new MessageEmbed.VideoInfo("http://localhost" , 0 , 0);
        MessageEmbed.Footer footer = new MessageEmbed.Footer(Author , "" , "");
        MessageEmbed.ImageInfo image = new MessageEmbed.ImageInfo("" , "" , 0 , 0);
        //MessageEmbed.Field field = new MessageEmbed.Field("" , "" , false);
        List<MessageEmbed.Field> fields = new ArrayList<MessageEmbed.Field>();
        //fields.add(field);
        int color = ColorChange("Costum3");
        User u = User.UserList.get(UUID);
        int miner = 1;
        for(int x = 1 ; x == 25 ; x++) {
            if (mines.getInfo(u , "Coal" , "Miner" + x) >= 1) {
                miner++;
            }
        }
        MessageEmbed embed = new MessageEmbed("" ,  Author+ "'s CoalMine" ,
                "**Cash**:  **" + mines.getInfo(u , "Coal" , "Cash") + "$** ("+CoalMine.CashPerSecond(u) +"$/s) \n" +
                "**Prestige**: Level **" + mines.getInfo(u , "Coal" , "Prestige") + "**\n" +
                "**Shop**: Level **" + mines.getInfo(u , "Coal" , "Shop") + "** ("+ CoalMine.ShopPerSecond(u)+"$/s)\n" +
                "**Elevator**: Level **" + mines.getInfo(u , "Coal" , "Elevator") + "**("+ CoalMine.ElevatorPerSecond(u)+"$/s)\n" +
                        "**Miner**: **" + miner  + "** active Miner ("+ CoalMine.MinerPerSecond(u)+"$/s)" ,
                EmbedType.AUTO_MODERATION , OffsetDateTime.now() , color , thumbnail ,provider ,author ,videoInfo ,footer ,image, fields);
        return embed;
    }

    public static MessageEmbed CoalMineShop(String title , String description  , String Author, String Color) {

        MessageEmbed.Thumbnail thumbnail = new MessageEmbed.Thumbnail("http://localhost" , "none" , 60 , 60);
        MessageEmbed.Provider provider = new MessageEmbed.Provider("none" , "http://localhost" );
        MessageEmbed.AuthorInfo author = new MessageEmbed.AuthorInfo("","" , "" , "");
        MessageEmbed.VideoInfo videoInfo = new MessageEmbed.VideoInfo("http://localhost" , 0 , 0);
        MessageEmbed.Footer footer = new MessageEmbed.Footer(Author , "" , "");
        MessageEmbed.ImageInfo image = new MessageEmbed.ImageInfo("" , "" , 0 , 0);
        //MessageEmbed.Field field = new MessageEmbed.Field("" , "" , false);
        List<MessageEmbed.Field> fields = new ArrayList<MessageEmbed.Field>();
        //fields.add(field);
        int color = ColorChange(Color);
        MessageEmbed embed = new MessageEmbed("" , "CoalMine Shop" , "old -> new" ,
                EmbedType.AUTO_MODERATION , OffsetDateTime.now() , color , thumbnail ,provider ,author ,videoInfo ,footer ,image, fields);
        return embed;
    }



}
