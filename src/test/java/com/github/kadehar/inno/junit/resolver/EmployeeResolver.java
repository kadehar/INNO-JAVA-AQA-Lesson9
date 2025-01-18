package com.github.kadehar.inno.junit.resolver;

import com.github.kadehar.inno.junit.annotation.NewEmployee;
import com.github.kadehar.inno.network.base.AuthClient;
import com.github.kadehar.inno.network.employee.EmployeeClient;
import com.github.kadehar.inno.network.employee.data.Employee;
import com.github.kadehar.inno.utils.CreateNewEmployee;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.support.AnnotationSupport;

public class EmployeeResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Employee.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) throws ParameterResolutionException {
        NewEmployee annotation = AnnotationSupport.findAnnotation(
                parameterContext.getParameter(),
                NewEmployee.class
        ).orElse(null);

        if (annotation == null) return null;

        EmployeeClient client = new EmployeeClient(new AuthClient());
        Employee employee = CreateNewEmployee.getEmployee();
        Long employeeId = client.createNew(employee);
        employee.setId(employeeId);
        return employee;
    }
}
