package com.github.kadehar.inno.network.base;

import com.github.kadehar.inno.config.Configuration;

public class Endpoints {
    private static final String BASE_URL = Configuration.INSTANCE.api().baseUrl();

    public static String login() {
        return BASE_URL + "/auth/login";
    }

    public static String getCompanies() {
        return BASE_URL + "/company";
    }

    public static String employee() {
        return BASE_URL + "/employee";
    }
}
