package dev.truewinter.huskchattestevents.bungee;

import dev.truewinter.huskchattestevents.common.ImpersonateCommand;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.william278.huskchat.bungeecord.player.BungeePlayer;

public class BungeeImpersonateCommand extends Command {
    private final ImpersonateCommand<ProxiedPlayer> command;

    public BungeeImpersonateCommand(HuskChatTestEvents hcte) {
        super("impersonate");
        this.command = new ImpersonateCommand<>(hcte);
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (!(commandSender instanceof ProxiedPlayer)) {
            return;
        }

        command.execute(BungeePlayer.adapt((ProxiedPlayer) commandSender), args);
    }
}
