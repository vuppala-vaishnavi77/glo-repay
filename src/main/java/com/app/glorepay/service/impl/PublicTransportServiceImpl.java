package com.app.glorepay.service.impl;

import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.PublicTransport;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.EmployeeDto;
import com.app.glorepay.payload.PublicTransportDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.repository.PublicTransportRepository;
import com.app.glorepay.service.EmployeeService;
import com.app.glorepay.service.PublicTransportService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a public transport service
@Service
@Transactional
public class PublicTransportServiceImpl implements PublicTransportService {
@Autowired
 EmployeeRepository employeeRepository;
@Autowired
    PublicTransportRepository publicTransportRepository;
    @Autowired
    ModelMapper modelMapper;

    private PublicTransportDto mapToDto(PublicTransport publicTransport){
        return modelMapper.map(publicTransport,PublicTransportDto.class);
    }

    private PublicTransport mapToEntity(PublicTransportDto publicTransportDto){
        return modelMapper.map(publicTransportDto,PublicTransport.class);
    }
    @Override
    public PublicTransportDto createPublicTransport(Long id, PublicTransportDto publicTransportDto) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        PublicTransport publicTransport=publicTransportRepository.save(mapToEntity(publicTransportDto));
        publicTransport.setEmp3(employee);
        employee.getPublicTransports().add(publicTransport);
        return mapToDto(publicTransport);
    }

    @Override
    public PublicTransportDto getPublicTransportById(Long id, Long publicTransportId) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        PublicTransport publicTransport=publicTransportRepository.findById(publicTransportId).orElseThrow(()->new ResourceNotFoundException("PublicTransport","id",publicTransportId));
        return mapToDto(publicTransport);
        //return null;
    }
}
