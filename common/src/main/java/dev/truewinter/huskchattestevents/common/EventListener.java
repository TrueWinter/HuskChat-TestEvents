package dev.truewinter.huskchattestevents.common;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.william278.huskchat.event.IBroadcastMessageEvent;
import net.william278.huskchat.event.IChatMessageEvent;
import net.william278.huskchat.event.IPrivateMessageEvent;
import net.william278.huskchat.player.Player;

import java.util.ArrayList;
import java.util.Locale;

public class EventListener {
    private final Logger logger;

    public EventListener(Logger logger) {
        this.logger = logger;
    }

    public void onChatMessage(IChatMessageEvent event) {
        if (event.isCancelled()) return;

        if (event.getMessage().equalsIgnoreCase("test")) {
            event.setMessage("much test such wow");
        }

        logger.info(String.format("[%s] %s: %s", event.getChannelId(), event.getSender().getName(), event.getMessage()));
    }

    public void onPrivateMessage(IPrivateMessageEvent event) {
        if (event.isCancelled()) return;

        ArrayList<String> names = new ArrayList<>();

        for (Player player : event.getRecipients()) {
            names.add(player.getName());
        }

        if (event.getMessage().toLowerCase(Locale.ROOT).contains("pvp")) {
            event.setCancelled(true);
            event.getSender().sendMessage(Component.text("PvP is not allowed on this server").color(NamedTextColor.RED));

            return;
        }

        logger.info(String.format("%s -> [%s]: %s", event.getSender().getName(),
                String.join(",", names), event.getMessage()));
    }

    public void onBroadcastMessage(IBroadcastMessageEvent event) {
        if (event.isCancelled()) return;

        if (event.getMessage().equalsIgnoreCase("never gonna give you up")) {
            event.setMessage("A mod/admin just tried to rick roll you... Luckily, a plugin can use the HuskChat event API to stop this.");
        }

        logger.info(String.format("[Broadcast] %s", event.getMessage()));
    }
}
