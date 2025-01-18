package com.github.kadehar.inno.network.employee;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kadehar.inno.network.base.BaseClient;
import com.github.kadehar.inno.network.base.Endpoints;
import com.github.kadehar.inno.network.base.MediaTypes;
import com.github.kadehar.inno.network.employee.data.Employee;
import com.github.kadehar.inno.storage.CompanyIdStorage;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class EmployeeClient {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final BaseClient client;

    public EmployeeClient(BaseClient client) {
        this.client = client;
    }

    public Long createNew(Employee employee) {
        try {
            String jsonBody = MAPPER
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(employee);
            RequestBody body = RequestBody.create(jsonBody, MediaTypes.JSON);
            Request createEmployeeRequest = new Request.Builder()
                    .url(Endpoints.employee())
                    .post(body)
                    .build();
            Response response = client.execute(createEmployeeRequest);
            JsonNode jsonNode = MAPPER.readTree(response.body().string());
            return jsonNode.get("id").asLong();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getEmployees() {
        try {
            HttpUrl url = HttpUrl.parse(Endpoints.employee())
                    .newBuilder()
                    .addQueryParameter("company", String.valueOf(CompanyIdStorage.INSTANCE.get()))
                    .build();
            Request getAllEmployeesRequest = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = client.execute(getAllEmployeesRequest);
            return MAPPER.readerForListOf(Employee.class)
                    .readValue(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee getEmployee(Long id) {
        try {
            Request getEmployeeRequest = new Request.Builder()
                    .url(Endpoints.employee() + "/" + id)
                    .get()
                    .build();
            Response response = client.execute(getEmployeeRequest);
            return MAPPER.readValue(response.body().string(), Employee.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee updateEmployee(Long id, Employee employee) {
        try {
            String jsonBody = MAPPER
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(employee);
            RequestBody body = RequestBody.create(jsonBody, MediaTypes.JSON);
            Request updateEmployeeRequest = new Request.Builder()
                    .url(Endpoints.employee() + "/" + id)
                    .patch(body)
                    .build();
            Response response = client.execute(updateEmployeeRequest);
            return MAPPER.readValue(response.body().string(), Employee.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
