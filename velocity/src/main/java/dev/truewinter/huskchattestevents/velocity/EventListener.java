package dev.truewinter.huskchattestevents.velocity;

import com.velocitypowered.api.event.Subscribe;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.william278.huskchat.player.Player;
import net.william278.huskchat.velocity.event.BroadcastMessageEvent;
import net.william278.huskchat.velocity.event.ChatMessageEvent;
import net.william278.huskchat.velocity.event.PrivateMessageEvent;
import net.william278.huskchat.velocity.player.VelocityPlayer;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Locale;

public class EventListener {
    private final Logger logger;

    public EventListener(Logger logger) {
        this.logger = logger;
    }

    @Subscribe
    public void onChatMessage(ChatMessageEvent event) {
        if (event.isCancelled()) return;

        if (event.getMessage().equalsIgnoreCase("test")) {
            event.setMessage("much test such wow");
        }

        logger.info(String.format("[%s] %s: %s", event.getChannelId(), event.getSender().getName(), event.getMessage()));
    }

    @Subscribe
    public void onPrivateMessage(PrivateMessageEvent event) {
        if (event.isCancelled()) return;

        ArrayList<String> names = new ArrayList<>();

        for (Player player : event.getReceivers()) {
            names.add(player.getName());
        }

        if (event.getMessage().toLowerCase(Locale.ROOT).contains("pvp")) {
            event.setCancelled(true);
            VelocityPlayer.adaptVelocity(event.getSender()).ifPresent(player -> {
                player.sendMessage(Component.text("PvP is not allowed on this server").color(NamedTextColor.RED));
            });

            return;
        }

        logger.info(String.format("%s -> [%s]: %s", event.getSender().getName(),
                String.join(",", names), event.getMessage()));
    }

    @Subscribe
    public void onBroadcastMessage(BroadcastMessageEvent event) {
        if (event.isCancelled()) return;

        if (event.getMessage().equalsIgnoreCase("never gonna give you up")) {
            event.setMessage("A mod/admin just tried to rick roll you... Luckily, a plugin can use the HuskChat event API to stop this.");
        }

        logger.info(String.format("[Broadcast] %s", event.getMessage()));
    }
}
