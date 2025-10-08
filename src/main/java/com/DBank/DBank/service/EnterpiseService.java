package com.DBank.DBank.service;

import com.DBank.DBank.dto.EnterpriseDTO;
import com.DBank.DBank.mapper.EnterpriseMap;
import com.DBank.DBank.mapper.EnterpriseMapper;
import com.DBank.DBank.model.EnterpriseModel;
import com.DBank.DBank.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EnterpiseService {

    private final EnterpriseRepository repository;
    private final EnterpriseMap mapper;

    public EnterpiseService(EnterpriseRepository repository, EnterpriseMap mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EnterpriseDTO add(EnterpriseDTO dto){
        EnterpriseModel model = mapper.toModel(dto);
        repository.save(model);

        return mapper.toDTO(model);
    }

    public EnterpriseDTO list(String email){
        return repository.findByEmail(email)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Email not found"));
    }

    public EnterpriseDTO edit(UUID id, EnterpriseDTO dto){
        EnterpriseModel model = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if(dto.getName() == null) dto.setName(model.getName());
        if(dto.getEmail() == null) dto.setEmail(model.getEmail());
        if(dto.getPassword() == null) dto.setPassword(model.getPassword());

        dto.setId(id);
        dto.setRegister(model.getRegister());
        dto.setAmount(model.getAmount());

        EnterpriseModel editUser = repository.save(mapper.toModel(dto));
        return mapper.toDTO(editUser);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}
