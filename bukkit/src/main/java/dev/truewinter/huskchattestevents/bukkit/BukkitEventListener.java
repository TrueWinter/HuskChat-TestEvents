package dev.truewinter.huskchattestevents.bukkit;

import dev.truewinter.huskchattestevents.common.EventListener;
import net.william278.huskchat.bukkit.event.BroadcastMessageEvent;
import net.william278.huskchat.bukkit.event.ChatMessageEvent;
import net.william278.huskchat.bukkit.event.PrivateMessageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.logging.Logger;

public class BukkitEventListener implements Listener {
    private final EventListener eventListener;

    public BukkitEventListener(Logger logger) {
        this.eventListener = new EventListener(new BukkitLogger(logger));
    }

    @EventHandler
    public void onChatMessage(ChatMessageEvent event) {
        eventListener.onChatMessage(event);
    }

    @EventHandler
    public void onPrivateMessage(PrivateMessageEvent event) {
        eventListener.onPrivateMessage(event);
    }

    @EventHandler
    public void onBroadcastMessage(BroadcastMessageEvent event) {
        eventListener.onBroadcastMessage(event);
    }
}
