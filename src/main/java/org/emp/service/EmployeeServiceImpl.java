package org.emp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.exceptions.EmployeeNotFoundException;
import org.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if(employeeList.isEmpty()){
            throw new EmployeeNotFoundException("No records available");
        }
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {

        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException("no emplyee found by this id");
        }
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

    @Override
    public Employee findEmployeeById(Long id) {
        if(employeeRepository.findById(id).isPresent()){
            Optional<EmployeeEntity> byId = employeeRepository.findById(id);
            return mapper.convertValue(byId, Employee.class);
        }
        throw new EmployeeNotFoundException("No Employee found by this ID : ".concat(String.valueOf(id)));
    }

    @Override
    public List<Employee> findEmployeeByFirstName(String firstName) {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> employeeByFirstName = employeeRepository.findEmployeeByFirstName(firstName);
        for (EmployeeEntity entity : employeeByFirstName) {
            Employee employee = mapper.convertValue(entity, Employee.class);
            employeeList.add(employee);
        }
        if (employeeList.isEmpty()){
            throw new EmployeeNotFoundException("Employees are not found by this first name : ".concat( firstName));
        }
        return employeeList;
    }

}
