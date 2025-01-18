package com.github.kadehar.inno.storage;

import java.util.HashMap;
import java.util.Map;

public enum CompanyIdStorage implements Storage<Long> {
    INSTANCE;

    private final static String KEY = "companyIdStorageKey";

    private final Map<String, Long> companyIdStorage = new HashMap<>();

    @Override
    public void put(Long value) {
        companyIdStorage.put(KEY, value);
    }

    @Override
    public Long get() {
        return companyIdStorage.get(KEY);
    }

    @Override
    public void clear() {
        companyIdStorage.clear();
    }
}
