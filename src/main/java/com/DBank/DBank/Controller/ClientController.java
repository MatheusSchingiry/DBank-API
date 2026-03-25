package com.DBank.DBank.Controller;

import com.DBank.DBank.DTO.ClientDTO;
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

    @PostMapping
    public ClientDTO add(@Valid @RequestBody ClientDTO dto){
        return service.add(dto);
    }

    @GetMapping("/{email}")
    public ClientDTO list(@PathVariable String email){
        return service.list(email);
    }

    @PutMapping("/{id}")
    public ClientDTO edit(@PathVariable UUID id, @Valid @RequestBody ClientDTO dto){
        return service.edit(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){ service.delete(id);}
}
