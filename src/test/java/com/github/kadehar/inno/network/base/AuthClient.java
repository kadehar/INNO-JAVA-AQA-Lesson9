package com.github.kadehar.inno.network.base;

import com.github.kadehar.inno.network.base.interceptors.AuthInterceptor;

public class AuthClient extends BaseClient {

    public AuthClient() {
        super.clientBuilder.addInterceptor(new AuthInterceptor());
    }
}
