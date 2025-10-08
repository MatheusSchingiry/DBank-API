package com.DBank.DBank.controller;

import com.DBank.DBank.dto.ClientDTO;
import com.DBank.DBank.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ClientDTO add(@Valid @RequestBody ClientDTO dto){
        return service.add(dto);
    }

    @GetMapping("/list/{email}")
    public ClientDTO list(@PathVariable String email){
        return service.list(email);
    }

    @PutMapping("/edit/{id}")
    public ClientDTO edit(@PathVariable UUID id, @Valid @RequestBody ClientDTO dto){
        return service.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){ service.delete(id);}
}
