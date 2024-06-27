package com.app.glorepay.service;


import com.app.glorepay.payload.EmployeeDto;

public interface EmployeeService {
    // It is a service to create an employee
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    // It is a service to get an employee by id
    EmployeeDto getEmployeeById(Long id);
}
