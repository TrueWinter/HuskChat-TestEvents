package dev.truewinter.huskchattestevents.common;

import net.william278.huskchat.HuskChat;

import java.util.Optional;

public interface HCPlugin<T> {
    Optional<T> getPlayer(String name);
    HuskChat getHuskChat();
}
