package dev.truewinter.huskchattestevents.bukkit;

import dev.truewinter.huskchattestevents.common.ImpersonateCommand;
import net.william278.huskchat.bukkit.player.BukkitPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class BukkitImpersonateCommand implements CommandExecutor {
    private final ImpersonateCommand<Player> command;

    public BukkitImpersonateCommand(HuskChatTestEvents hcte) {
        this.command = new ImpersonateCommand<>(hcte);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command cmd, @NotNull String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            return true;
        }

        command.execute(BukkitPlayer.adapt((Player) commandSender), args);

        return true;
    }
}
