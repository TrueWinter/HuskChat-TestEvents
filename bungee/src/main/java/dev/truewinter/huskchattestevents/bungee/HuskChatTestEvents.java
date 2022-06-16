package dev.truewinter.huskchattestevents.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import java.util.logging.Logger;

public class HuskChatTestEvents extends Plugin {
    private ProxyServer server;
    private Logger logger;

    public void onEnable() {
        this.server = getProxy();
        this.logger = getLogger();

        server.getPluginManager().registerListener(this, new EventListener(logger));
    }
}
