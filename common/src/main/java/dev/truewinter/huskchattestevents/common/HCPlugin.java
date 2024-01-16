package dev.truewinter.huskchattestevents.common;

import net.william278.huskchat.HuskChatAPI;
import net.william278.huskchat.player.Player;

import java.util.Optional;

public interface HCPlugin<T> {
    Optional<T> getPlayer(String name);
    Player getHuskChatPlayer(T player);
}
