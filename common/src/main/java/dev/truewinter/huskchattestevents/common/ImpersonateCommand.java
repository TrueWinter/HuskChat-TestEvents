package dev.truewinter.huskchattestevents.common;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.william278.huskchat.player.Player;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ImpersonateCommand<T> {
    private final HCPlugin<T> hcte;

    public ImpersonateCommand(HCPlugin<T> hcte) {
        this.hcte = hcte;
    }

    public void execute(Player invoker, String[] args) {

        if (args.length < 2) {
            invoker.sendMessage(Component.text("/impersonate <player> <message>")
                    .color(NamedTextColor.RED));
            return;
        }

        String fromPlayerName = args[0];
        String message = Arrays.stream(args).skip(1).collect(Collectors.joining(" "));

        hcte.getPlayer(fromPlayerName).ifPresentOrElse(player -> {
            Player fromPlayer = hcte.getHuskChat().getAPI().adaptPlayer(player);
            invoker.sendMessage(Component.text("Sending message as player " + fromPlayer.getName())
                    .color(NamedTextColor.GOLD));
            hcte.getHuskChat().getAPI().sendChatMessage("global", fromPlayer, message);
        }, () -> {
            invoker.sendMessage(Component.text("Player is not online")
                    .color(NamedTextColor.RED));
        });
    }
}
