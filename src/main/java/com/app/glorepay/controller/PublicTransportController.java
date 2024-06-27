package com.app.glorepay.controller;

import com.app.glorepay.payload.PublicTransportDto;
import com.app.glorepay.service.PublicTransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class PublicTransportController {

    // create public transport REST API
    @Autowired
    PublicTransportService publicTransportService;

    @PostMapping("/{id}/publicTransport")
    ResponseEntity<PublicTransportDto> createPublicTransport(@PathVariable Long id, @Valid @RequestBody PublicTransportDto publicTransportDto){

        return new ResponseEntity<>(publicTransportService.createPublicTransport(id,publicTransportDto), HttpStatus.CREATED);
    }

    // get public transport by id REST API
    @GetMapping("/{id}/publicTransport/{publicTransport}")
    ResponseEntity<PublicTransportDto> getPublicTransportById(@PathVariable Long id,@PathVariable Long publicTransport ){

        return new ResponseEntity<>(publicTransportService.getPublicTransportById(id,publicTransport),HttpStatus.OK);
    }

}
