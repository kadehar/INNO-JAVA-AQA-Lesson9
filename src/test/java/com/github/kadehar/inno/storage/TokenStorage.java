package com.github.kadehar.inno.storage;

import java.util.HashMap;
import java.util.Map;

public enum TokenStorage implements Storage<String> {
    INSTANCE;

    private final static String KEY = "tokenStorageKey";

    private final Map<String, String> tokenStorage = new HashMap<>();

    @Override
    public void put(String value) {
        tokenStorage.put(KEY, value);
    }

    @Override
    public String get() {
        return tokenStorage.get(KEY);
    }

    @Override
    public void clear() {
        tokenStorage.clear();
    }
}
