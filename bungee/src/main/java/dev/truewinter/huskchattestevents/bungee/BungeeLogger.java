package dev.truewinter.huskchattestevents.bungee;

import dev.truewinter.huskchattestevents.common.Logger;

public class BungeeLogger implements Logger {
    private final java.util.logging.Logger logger;

    public BungeeLogger(java.util.logging.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String s) {
        logger.info(s);
    }
}
