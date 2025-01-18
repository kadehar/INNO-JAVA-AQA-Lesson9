package com.github.kadehar.inno.network.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kadehar.inno.network.auth.data.Token;
import com.github.kadehar.inno.network.auth.data.User;
import com.github.kadehar.inno.network.base.BaseClient;
import com.github.kadehar.inno.network.base.Endpoints;
import com.github.kadehar.inno.network.base.MediaTypes;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class TokenClient {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final BaseClient client;

    public TokenClient(BaseClient client) {
        this.client = client;
    }

    public Token fetch(User user) {
        try {
            String jsonBody = MAPPER
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(user);
            RequestBody body = RequestBody.create(jsonBody, MediaTypes.JSON);
            Request tokenRequest = new Request.Builder()
                    .url(Endpoints.login())
                    .post(body)
                    .build();
            Response response = client.execute(tokenRequest);
            return MAPPER.readValue(response.body().string(), Token.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
