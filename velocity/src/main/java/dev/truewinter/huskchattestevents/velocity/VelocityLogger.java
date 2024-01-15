package dev.truewinter.huskchattestevents.velocity;

import dev.truewinter.huskchattestevents.common.Logger;

public class VelocityLogger implements Logger {
    private final org.slf4j.Logger logger;

    public VelocityLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String s) {
        logger.info(s);
    }
}
