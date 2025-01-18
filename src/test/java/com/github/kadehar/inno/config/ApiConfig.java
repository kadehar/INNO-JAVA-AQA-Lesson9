package com.github.kadehar.inno.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties",
        "file:~/api.properties",
        "file:./api.properties"
})
public interface ApiConfig extends Config {
    @Key("baseUrl")
    String baseUrl();
    @Key("adminUser")
    String adminUsername();
    @Key("adminPassword")
    String adminPassword();
}
