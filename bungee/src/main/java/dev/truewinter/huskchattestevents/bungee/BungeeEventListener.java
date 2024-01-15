package dev.truewinter.huskchattestevents.bungee;

import dev.truewinter.huskchattestevents.common.EventListener;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.william278.huskchat.bungeecord.event.BroadcastMessageEvent;
import net.william278.huskchat.bungeecord.event.ChatMessageEvent;
import net.william278.huskchat.bungeecord.event.PrivateMessageEvent;

import java.util.logging.Logger;

public class BungeeEventListener implements Listener {
    private final EventListener eventListener;

    public BungeeEventListener(Logger logger) {
        this.eventListener = new EventListener(new BungeeLogger(logger));
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
