package org.emp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper mapper;

    @Override
    public void addNewEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        employeeRepository.save(employeeEntity);
    }

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> retrieve() {
        List<EmployeeEntity> all = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity : all) {
//            Employee employee = mapper.convertValue(employeeEntity, Employee.class);
//            employeeList.add(employee);
            employeeList.add(mapper.convertValue(employeeEntity,Employee.class));
        }
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
