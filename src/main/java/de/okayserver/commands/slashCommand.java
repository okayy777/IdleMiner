package de.okayserver.commands;

import de.okayserver.SQL.Tables.user;
import de.okayserver.Users.UserUtils;
import de.okayserver.embeds;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class slashCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        switch (e.getName()) {
            case "create":
                if (user.UUIDexists(e.getInteraction().getUser().getId())) {
                    e.replyEmbeds(embeds.BasicEmbed("Account creation", "You already created your Account", e.getUser().getName(), "Red")).setEphemeral(true).queue();
                } else {
                    UserUtils.createUser(e.getInteraction().getUser().getId());
                    e.replyEmbeds(embeds.BasicEmbed("Account creation", "You successfully created your Account", e.getUser().getName(), "Costum4"))
                            .addActionRow(Button.link("https://github.com/okayy777/IdleMiner/wiki", "Wiki")).setEphemeral(true).queue();
                }
            case "CoalMine":
                if (user.UUIDexists(e.getInteraction().getUser().getId())) {
                    if (e.getInteraction().getFullCommandName().contains("info")) {

                    }

                } else {
                    e.replyEmbeds(embeds.BasicEmbed("Account creation" , "You need to create a Account first" , e.getUser().getName() , "Red")).queue();
                }
        }
    }
}
