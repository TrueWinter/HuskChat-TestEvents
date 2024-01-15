package dev.truewinter.huskchattestevents.bukkit;

import dev.truewinter.huskchattestevents.common.Logger;

public class BukkitLogger implements Logger {
    private final java.util.logging.Logger logger;

    public BukkitLogger(java.util.logging.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String s) {
        logger.info(s);
    }
}
