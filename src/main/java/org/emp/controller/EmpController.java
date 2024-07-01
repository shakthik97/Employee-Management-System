package org.emp.controller;

import org.emp.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/add-employee")
public class EmpController {

    List<Employee> empList = new ArrayList<>();
    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        empList.add(employee);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployees(){
        return empList;
    }
}

