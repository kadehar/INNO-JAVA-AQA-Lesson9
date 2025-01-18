package com.github.kadehar.inno.tests;

import com.github.kadehar.inno.junit.annotation.NewEmployee;
import com.github.kadehar.inno.network.base.AuthClient;
import com.github.kadehar.inno.network.employee.EmployeeClient;
import com.github.kadehar.inno.network.employee.data.Employee;
import com.github.kadehar.inno.utils.CreateNewEmployee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeTests extends TestBase {

    private final EmployeeClient client = new EmployeeClient(new AuthClient());

    @Test
    @DisplayName("Могу создать нового сотрудника организации")
    void canCreateNewEmployee() {
        Employee employee = CreateNewEmployee.getEmployee();
        Long id = client.createNew(employee);
        assertThat(id).isNotNull();
        assertThat(id).isGreaterThan(0);
    }

    @Test
    @DisplayName("Могу найти сотрудника организации по его id")
    /* При получении сотрудника поля url и email == null */
    void canFindEmployeeById(@NewEmployee Employee expected) {
        Employee actualEmployee = client.getEmployee(expected.getId());
        assertThat(actualEmployee).isEqualTo(expected);
    }

    @Test
    @DisplayName("Могу получить список всех сотрудников организации")
    /* При получении сотрудника поля url и email == null */
    void canGetAllEmployees(@NewEmployee Employee expected) {
        List<Employee> employees = client.getEmployees();
        assertThat(employees).isNotEmpty();
        assertThat(employees).contains(expected);
    }

    @Test
    @DisplayName("Могу обновить данные сотрудника организации")
    /* Ожидается, что будет приходить вся сущность Employee с обновленным полем, а не часть полей */
    void canUpdateEmployee(@NewEmployee Employee employee) {
        employee.setIsActive(false);
        Employee actualEmployee = client.updateEmployee(employee.getId(), employee);
        assertThat(actualEmployee).isEqualTo(employee);
    }
}
