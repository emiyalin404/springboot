package net.javaguides.service;

import net.javaguides.entity.Order;
import net.javaguides.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.entity.Employee;
import net.javaguides.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    OrderRepository orderRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteemployee(Long employeeId) {
        Employee employeeToDelete = employeeRepository.findById(employeeId).orElse(null);
        List<Order> ordersToDelete = employeeToDelete.getOrders();
        for (Order order : ordersToDelete) {
            order.setEmployee(null);
        }
        employeeRepository.deleteemployee(employeeId);
    }
}
