package com.app.glorepay.controller;

import com.app.glorepay.payload.PrivateTransportDto;
import com.app.glorepay.service.PrivateTransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class PrivateTransportController {
@Autowired
    PrivateTransportService privateTransportService;
@PostMapping("/{id}/privateTransport")
    ResponseEntity<PrivateTransportDto> createPrivateTransport(@PathVariable Long id, @Valid @RequestBody PrivateTransportDto privateTransportDto){
    return new ResponseEntity<>(privateTransportService.createPrivateTransport(id,privateTransportDto), HttpStatus.CREATED);
}
    // create private transport REST API

    // get private transport by id REST API
    @GetMapping("/{id}/privateTransport/{privateTransport}")
    ResponseEntity<PrivateTransportDto> getPrivateTransportById(@PathVariable Long id,@PathVariable Long privateTransport){
    return new ResponseEntity<>(privateTransportService.getPrivateTransportById(id,privateTransport),HttpStatus.OK);
    }

}
