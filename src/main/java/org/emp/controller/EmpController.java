package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmpController {

    private final EmployeeService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        service.addNewEmployee(employee);
    }

    @GetMapping("/get-all")
    public List<Employee> getAllEmployees() {
        return service.retrieve();

    }


    @DeleteMapping("/delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployeeById(id);
        return "the Employee has been Deleted";
    }


    @PutMapping("/update-emp")
    @ResponseStatus(HttpStatus.OK)
    public String updateEmployee(@RequestBody Employee employee){
        service.updateTheEmployee(employee);
        return "updated";
    }

    @GetMapping("/find-by-id/{id}")
    public Employee findById(@PathVariable Long id){
        return service.findEmployeeById(id);
    }

    @GetMapping("/find-by-firstName/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName){
        return service.findEmployeeByFirstName(firstName);
    }

}

 