package com.vio.victor.supermarketservice.repositories;

import com.vio.victor.supermarketservice.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
