package com.github.kadehar.inno.network.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kadehar.inno.network.base.BaseClient;
import com.github.kadehar.inno.network.base.Endpoints;
import com.github.kadehar.inno.network.company.data.Company;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class CompanyClient {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final BaseClient client;

    public CompanyClient(BaseClient client) {
        this.client = client;
    }

    public Company fetch() {
        try {
            HttpUrl url = HttpUrl.parse(Endpoints.getCompanies())
                    .newBuilder()
                    .addQueryParameter("active", "true")
                    .build();
            Request getAllCompanies = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = client.execute(getAllCompanies);
            List<Company> companies = MAPPER.readerForListOf(Company.class)
                    .readValue(response.body().string());
            return companies.stream().sorted(Comparator.comparingLong(Company::id)).toList().getFirst();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
