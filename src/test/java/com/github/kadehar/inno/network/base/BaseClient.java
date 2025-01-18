package com.github.kadehar.inno.network.base;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;

public abstract class BaseClient {

    protected OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

    public Response execute(Request request) {
        try {
            return clientBuilder.build().newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
