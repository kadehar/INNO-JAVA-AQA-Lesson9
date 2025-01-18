package com.github.kadehar.inno.config;

import org.aeonbits.owner.ConfigFactory;

public enum Configuration {
    INSTANCE;

    private static final ApiConfig config = ConfigFactory.create(
            ApiConfig.class,
            System.getProperties()
    );

    public ApiConfig api() {
        return config;
    }
}
