package com.app.glorepay.service.impl;

import com.app.glorepay.entity.Employee;
import com.app.glorepay.entity.Food;
import com.app.glorepay.entity.PrivateTransport;
import com.app.glorepay.exception.ResourceNotFoundException;
import com.app.glorepay.payload.EmployeeDto;
import com.app.glorepay.payload.FoodDto;
import com.app.glorepay.repository.EmployeeRepository;
import com.app.glorepay.repository.FoodRepository;
import com.app.glorepay.service.FoodService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// make this into a food service
@Service
@Transactional
public class FoodServiceImpl implements FoodService {
@Autowired
    EmployeeRepository employeeRepository;
@Autowired
    FoodRepository foodRepository;
    @Autowired
    ModelMapper modelMapper;

    private FoodDto mapToDto(Food food){
        return modelMapper.map(food,FoodDto.class);
    }

    private Food mapToEntity(FoodDto foodDto){
        return modelMapper.map(foodDto,Food.class);
    }
    @Override
    public FoodDto createFood(Long id, FoodDto foodDto) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        Food food=foodRepository.save(mapToEntity(foodDto));
        food.setEmp1(employee);
        employee.getFood().add(food);
        return mapToDto(food);
    }

    @Override
    public FoodDto getFoodById(Long id, Long foodId) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        Food food=foodRepository.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food","id",foodId));

        return mapToDto(food);
       // return null;
    }
}
