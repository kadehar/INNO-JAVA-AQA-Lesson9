package com.github.kadehar.inno.storage;

public interface Storage<T> {
    void put(T value);
    T get();
    void clear();
}
