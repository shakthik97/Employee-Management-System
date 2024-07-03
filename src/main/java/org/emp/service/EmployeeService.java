package org.emp.service;

import org.emp.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void addNewEmployee(Employee employee);

    List<Employee> retrieve();

    void deleteEmployeeById(Long id);

    void updateTheEmployee(Employee employee);
}
