package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/add-employee")
public class EmpController {

    private final EmployeeService service;

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        service.addNewEmployee(employee);
    }

    @GetMapping("/get-all")
    public List<Employee> getAllEmployees() {
        return service.retrieve();

    }
}

