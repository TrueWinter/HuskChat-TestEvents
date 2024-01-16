package dev.truewinter.huskchattestevents.velocity;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.truewinter.huskchattestevents.common.HCPlugin;
import net.william278.huskchat.velocity.player.VelocityPlayer;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.Optional;

@Plugin(id = "huskchattestevents",
        authors = {
            "TrueWinter"
        },
        dependencies = {
            @Dependency(id = "huskchat")
        }
)
public class HuskChatTestEvents implements HCPlugin<Player> {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public HuskChatTestEvents(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getPluginManager().getPlugin("huskchat").ifPresentOrElse(p -> {
            Optional<?> h = p.getInstance();
            if (h.isEmpty()) {
                logger.error("Failed to get instance of HuskChat");
                return;
            }

            server.getEventManager().register(this, new VelocityEventListener(logger));
            server.getCommandManager().register("impersonate", new VelocityImpersonateCommand(this));
        }, () -> {
            logger.error("HuskChat is not installed");
        });
    }

    @Override
    public Optional<Player> getPlayer(String name) {
        return server.getPlayer(name);
    }

    @Override
    public net.william278.huskchat.player.Player getHuskChatPlayer(Player player) {
        return VelocityPlayer.adapt(player);
    }
}
