package net.javaguides.controller;

import org.springframework.web.bind.annotation.RestController;

import net.javaguides.entity.Employee;
import net.javaguides.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/VueTestApi/api")

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/Employee")
    public Employee createProduct(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
