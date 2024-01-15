package dev.truewinter.huskchattestevents.velocity;

import com.velocitypowered.api.command.SimpleCommand;
import dev.truewinter.huskchattestevents.common.ImpersonateCommand;
import net.william278.huskchat.velocity.player.VelocityPlayer;

public class VelocityImpersonateCommand implements SimpleCommand {
    private final ImpersonateCommand<com.velocitypowered.api.proxy.Player> command;

    public VelocityImpersonateCommand(HuskChatTestEvents hcte) {
        this.command = new ImpersonateCommand<>(hcte);
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof com.velocitypowered.api.proxy.Player)) {
            return;
        }

        command.execute(VelocityPlayer.adapt((com.velocitypowered.api.proxy.Player) invocation.source()),
                invocation.arguments());
    }
}
