package com.mayron.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayron.library.dtos.CreateClientDTO;
import com.mayron.library.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/client")
public class ClientController {
    
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> createClient(@RequestBody @Valid CreateClientDTO clientDTO){
        var newClientDTO = this.clientService.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClientDTO);
    }
}
