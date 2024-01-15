package dev.truewinter.huskchattestevents.bungee;

import dev.truewinter.huskchattestevents.common.HCPlugin;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.william278.huskchat.HuskChat;

import java.util.Optional;
import java.util.logging.Logger;

public class HuskChatTestEvents extends Plugin implements HCPlugin<ProxiedPlayer> {
    private ProxyServer server;
    private Logger logger;
    private HuskChat huskChat;

    public void onEnable() {
        this.server = getProxy();
        this.logger = getLogger();
        this.huskChat = (HuskChat) server.getPluginManager().getPlugin("HuskChat");

        server.getPluginManager().registerListener(this, new BungeeEventListener(logger));
        server.getPluginManager().registerCommand(this, new BungeeImpersonateCommand(this));
    }

    @Override
    public Optional<ProxiedPlayer> getPlayer(String name) {
        return Optional.ofNullable(server.getPlayer(name));
    }

    @Override
    public HuskChat getHuskChat() {
        return huskChat;
    }
}
