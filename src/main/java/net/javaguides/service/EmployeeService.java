package net.javaguides.service;

import net.javaguides.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    void deleteemployee(Long employeeId);
}
