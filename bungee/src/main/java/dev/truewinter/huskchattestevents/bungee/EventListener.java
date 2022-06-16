package dev.truewinter.huskchattestevents.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.william278.huskchat.bungeecord.event.BroadcastMessageEvent;
import net.william278.huskchat.bungeecord.event.ChatMessageEvent;
import net.william278.huskchat.bungeecord.event.PrivateMessageEvent;
import net.william278.huskchat.bungeecord.player.BungeePlayer;
import net.william278.huskchat.player.Player;

import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Logger;

public class EventListener implements Listener {
    private final Logger logger;

    public EventListener(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onChatMessage(ChatMessageEvent event) {
        if (event.isCancelled()) return;

        if (event.getMessage().equalsIgnoreCase("test")) {
            event.setMessage("much test such wow");
        }

        logger.info(String.format("[%s] %s: %s", event.getChannelId(), event.getSender().getName(), event.getMessage()));
    }

    @EventHandler
    public void onPrivateMessage(PrivateMessageEvent event) {
        if (event.isCancelled()) return;

        ArrayList<String> names = new ArrayList<>();

        for (Player player : event.getRecipients()) {
            names.add(player.getName());
        }

        if (event.getMessage().toLowerCase(Locale.ROOT).contains("pvp")) {
            event.setCancelled(true);
            BungeePlayer.adaptBungee(event.getSender()).ifPresent(player -> {
                TextComponent textComponent = new TextComponent("PvP is not allowed on this server");
                textComponent.setColor(ChatColor.RED);
                player.sendMessage(textComponent);
            });

            return;
        }

        logger.info(String.format("%s -> [%s]: %s", event.getSender().getName(),
                String.join(",", names), event.getMessage()));
    }

    @EventHandler
    public void onBroadcastMessage(BroadcastMessageEvent event) {
        if (event.isCancelled()) return;

        if (event.getMessage().equalsIgnoreCase("never gonna give you up")) {
            event.setMessage("A mod/admin just tried to rick roll you... Luckily, a plugin can use the HuskChat event API to stop this.");
        }

        logger.info(String.format("[Broadcast] %s", event.getMessage()));
    }
}
