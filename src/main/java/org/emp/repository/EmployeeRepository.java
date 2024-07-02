package org.emp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.emp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
