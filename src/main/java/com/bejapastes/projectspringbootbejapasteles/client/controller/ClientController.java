package com.bejapastes.projectspringbootbejapasteles.client.controller;

import com.bejapastes.projectspringbootbejapasteles.client.modelentity.Client;
import com.bejapastes.projectspringbootbejapasteles.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.util.*;

@RestController()
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping()
    public List<Client> getClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable Long id){
        Client client = clientService.findById(id);
        if(client == null){
            return createErrorResponse("Client not found", 404);
        }
        return ResponseEntity.status(200).body(client);
    }

    @PostMapping()
    public ResponseEntity<?> postClient(@Valid @RequestBody Client client){
        try{
            clientService.save(client);
            return ResponseEntity.status(201).body(client);
        }catch (Exception e){
            return createErrorResponse(e.getMessage(), 500);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Long id){
        Client clientDB = clientService.findById(id);
        if(clientDB == null){
            throw new RuntimeException("Client not found");
        }
        clientDB.setName(client.getName());
        clientDB.setEmail(client.getEmail());
        clientDB.setAddress(client.getAddress());
        clientDB.setPhone(client.getPhone());
        return clientService.save(clientDB);
    }

    private ResponseEntity<Map<String, String>> createErrorResponse(String message, int status) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.status(status).body(response);
    }
}
