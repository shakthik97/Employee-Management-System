package org.emp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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


    @Override
    public List<Employee> retrieve() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> all = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity : all) {
            employeeList.add(mapper.convertValue(employeeEntity,Employee.class));
        }
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

//    @Override
//    public void updateTheEmployee(Employee employee) {
//        if(employeeRepository.findById(employee.getId()).isPresent()){
//            employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
//        }
//    }

    @Override
    public void updateTheEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getId())){
            employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
        }

    }

}
