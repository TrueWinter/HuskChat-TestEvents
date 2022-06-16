package dev.truewinter.huskchattestevents.velocity;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import javax.inject.Inject;

@Plugin(id = "huskchattestevents",
        authors = {
            "TrueWinter"
        },
        dependencies = {
            @Dependency(id = "huskchat")
        }
)
public class HuskChatTestEvents {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public HuskChatTestEvents(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new EventListener(logger));
        System.out.println("Loaded dev.truewinter.huskchattestevents.velocity.HuskChatTestEvents");
    }
}
