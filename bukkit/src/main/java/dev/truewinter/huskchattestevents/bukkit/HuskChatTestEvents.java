package dev.truewinter.huskchattestevents.bukkit;

import dev.truewinter.huskchattestevents.common.HCPlugin;
import net.william278.huskchat.HuskChat;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.logging.Logger;

public class HuskChatTestEvents extends JavaPlugin implements HCPlugin<Player> {
    private Server server;
    private Logger logger;
    private HuskChat huskChat;

    public void onEnable() {
        this.server = getServer();
        this.logger = getLogger();
        this.huskChat = (HuskChat) server.getPluginManager().getPlugin("HuskChat");

        server.getPluginManager().registerEvents(new BukkitEventListener(logger), this);
        getCommand("impersonate").setExecutor(new BukkitImpersonateCommand(this));
    }

    @Override
    public Optional<Player> getPlayer(String name) {
        return Optional.ofNullable(server.getPlayer(name));
    }

    @Override
    public HuskChat getHuskChat() {
        return huskChat;
    }
}
