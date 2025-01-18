package com.github.kadehar.inno.network.base.interceptors;

import com.github.kadehar.inno.storage.TokenStorage;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    private static final String X_CLIENT_TOKEN_HEADER = "x-client-token";

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request auth = chain.request()
                .newBuilder()
                .header(X_CLIENT_TOKEN_HEADER, TokenStorage.INSTANCE.get())
                .build();
        return chain.proceed(auth);
    }
}
