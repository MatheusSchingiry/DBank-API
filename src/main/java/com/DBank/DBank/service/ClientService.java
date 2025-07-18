package com.DBank.DBank.service;

import com.DBank.DBank.dto.ClientDTO;
import com.DBank.DBank.mapper.ClientMap;
import com.DBank.DBank.mapper.ClientMapper;
import com.DBank.DBank.model.ClientModel;
import com.DBank.DBank.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final ClientMap mapper;

    public ClientService(ClientRepository repository, ClientMap mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClientDTO add(ClientDTO dto){
        ClientModel model = mapper.toModel(dto);
        repository.save(model);
        return mapper.toDTO(model);
    }

    public ClientDTO list(String email){
        return repository.findByEmail(email)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public ClientDTO edit(String id, ClientDTO dto){
        ClientModel model = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if(dto.getName() == null) dto.setName(model.getName());
        if(dto.getEmail() == null) dto.setEmail(model.getEmail());
        if(dto.getPassword() == null) dto.setPassword(model.getPassword());

        dto.setRegister(model.getRegister());
        dto.setAmount(model.getAmount());
        dto.setId(id);

        ClientModel updateModel = repository.save(mapper.toModel(dto));
        return mapper.toDTO(updateModel);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
