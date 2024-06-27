package com.app.glorepay.service.impl;

import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.PrivateTransport;
import com.app.glorepay.entity.PublicTransport;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.payload.PublicTransportDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.repository.PrivateTransportRepository;
import com.app.glorepay.service.PrivateTransportService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a private transport service
@Service
@Transactional
public class PrivateTransportServiceImpl implements PrivateTransportService {
@Autowired
    EmployeeRepository employeeRepository;
@Autowired
    PrivateTransportRepository privateTransportRepository;
    @Autowired
    ModelMapper modelMapper;

    private PrivateTransportDto mapToDto(PrivateTransport privateTransport){
        return modelMapper.map(privateTransport,PrivateTransportDto.class);
    }

    private PrivateTransport mapToEntity(PrivateTransportDto privateTransportDto){
        return modelMapper.map(privateTransportDto,PrivateTransport.class);
    }
    @Override
    public PrivateTransportDto createPrivateTransport(Long id, PrivateTransportDto privateTransportDto) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        PrivateTransport privateTransport1=privateTransportRepository.save(mapToEntity(privateTransportDto));
        privateTransport1.setEmp2(employee);
        employee.getPrivateTransports().add(privateTransport1);
        return mapToDto(privateTransport1);
    }

    @Override
    public PrivateTransportDto getPrivateTransportById(Long id, Long privateTransportId) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        PrivateTransport privateTransport=privateTransportRepository.findById(privateTransportId).orElseThrow(()->new ResourceNotFoundException("PrivateTransport","id",privateTransportId));

        return mapToDto(privateTransport);
    }
}
