package com.app.glorepay.controller;

import com.app.glorepay.payload.FoodDto;
import com.app.glorepay.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class FoodController {
@Autowired
    FoodService foodService;
    // create food REST API
    @PostMapping("/{id}/food")
    ResponseEntity<FoodDto> createFood(@PathVariable Long id,@Valid @RequestBody FoodDto foodDto){
        return new ResponseEntity<>(foodService.createFood(id,foodDto), HttpStatus.CREATED);
    }

    // get food by id REST API
    @GetMapping("/{id}/food/{foodId}")
    ResponseEntity<FoodDto> getFoodById(@PathVariable Long id,@PathVariable Long foodId){
        return new ResponseEntity<>(foodService.getFoodById(id,foodId),HttpStatus.OK);
    }

}

