package com.github.kadehar.inno.utils;

import com.github.javafaker.Faker;
import com.github.kadehar.inno.network.employee.data.Employee;
import com.github.kadehar.inno.storage.CompanyIdStorage;

import java.time.LocalDate;

public class CreateNewEmployee {
    private static final Faker faker = new Faker();

    public static Employee getEmployee() {
        return Employee.newBuilder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setMiddleName(faker.name().firstName())
                .setEmail(faker.internet().emailAddress())
                .setUrl(faker.internet().url())
                .setBirthdate(LocalDate.now().minusYears(20).toString())
                .setPhone("7999" + faker.phoneNumber().subscriberNumber(7))
                .setCompanyId(CompanyIdStorage.INSTANCE.get())
                .setActive(true)
                .build();
    }
}
