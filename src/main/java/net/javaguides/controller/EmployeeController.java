package net.javaguides.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.entity.Employee;
import net.javaguides.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/deleteEmployee")
    public Map<String, Object> deleteemployee(@RequestParam String employeeName){
        Map<String, Object> resultMap = new HashMap<>();
        if (!employeeName.isBlank()) {
            employeeService.deleteemployee(employeeName);
            resultMap.put("Message", "刪除成功");
        } else {
            resultMap.put("Message", "刪除失敗");
        }
        return resultMap;
    }
}
