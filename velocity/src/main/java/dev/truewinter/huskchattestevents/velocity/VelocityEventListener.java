package dev.truewinter.huskchattestevents.velocity;

import com.velocitypowered.api.event.Subscribe;
import dev.truewinter.huskchattestevents.common.EventListener;
import net.william278.huskchat.velocity.event.BroadcastMessageEvent;
import net.william278.huskchat.velocity.event.ChatMessageEvent;
import net.william278.huskchat.velocity.event.PrivateMessageEvent;
import org.slf4j.Logger;

public class VelocityEventListener {
    private final EventListener eventListener;

    public VelocityEventListener(Logger logger) {
        this.eventListener = new EventListener(new VelocityLogger(logger));
    }

    @Subscribe
    public void onChatMessage(ChatMessageEvent event) {
        eventListener.onChatMessage(event);
    }

    @Subscribe
    public void onPrivateMessage(PrivateMessageEvent event) {
        eventListener.onPrivateMessage(event);
    }

    @Subscribe
    public void onBroadcastMessage(BroadcastMessageEvent event) {
        eventListener.onBroadcastMessage(event);
    }
}
