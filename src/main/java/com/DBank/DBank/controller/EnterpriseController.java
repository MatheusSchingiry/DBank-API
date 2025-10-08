package com.DBank.DBank.controller;

import com.DBank.DBank.dto.EnterpriseDTO;
import com.DBank.DBank.service.EnterpiseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpiseService service;

    public EnterpriseController(EnterpiseService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public EnterpriseDTO add(@Valid @RequestBody EnterpriseDTO dto){
        return service.add(dto);
    }

    @GetMapping("/list/{email}")
    public EnterpriseDTO list(@PathVariable String email){
        return service.list(email);
    }

    @PutMapping("/edit/{id}")
    public EnterpriseDTO edit(@PathVariable UUID id, @Valid @RequestBody EnterpriseDTO dto){
        return service.edit(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){ service.delete(id); }
}
