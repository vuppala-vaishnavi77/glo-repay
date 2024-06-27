package com.app.glorepay.service.impl;


import com.app.glorepay.entity.Employee;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.EmployeeDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a employee service
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    private EmployeeDto mapToDto(Employee employee){
        return modelMapper.map(employee,EmployeeDto.class);
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        return modelMapper.map(employeeDto,Employee.class);
    }


    //create employee
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        return mapToDto(employeeRepository.save(mapToEntity(employeeDto)));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));

        return mapToDto(employee);
    }
}
