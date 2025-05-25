package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.EnterpriseDTO;
import com.DBank.DBank.model.EnterpriseModel;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseMap {

    public EnterpriseModel toModel(EnterpriseDTO dto){
        EnterpriseModel model = new EnterpriseModel();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setRegister(dto.getRegister());
        model.setEmail(dto.getEmail());
        model.setPassword(dto.getPassword());
        model.setAmount(dto.getAmount());

        return model;
    }

    public EnterpriseDTO toDTO(EnterpriseModel model){
        EnterpriseDTO dto = new EnterpriseDTO();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setRegister(model.getRegister());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        dto.setAmount(model.getAmount());

        return dto;
    }
}
