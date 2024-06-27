package com.app.glorepay.repository;

import com.app.glorepay.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a employee repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
