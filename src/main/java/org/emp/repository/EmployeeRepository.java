package org.emp.repository;

import org.emp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    public List<EmployeeEntity> findEmployeeByFirstName(String firstName);
}
