package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.ClientDTO;
import com.DBank.DBank.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMap {

    public ClientModel toModel(ClientDTO dto){
        ClientModel model = new ClientModel();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setRegister(dto.getRegister());
        model.setEmail(dto.getEmail());
        model.setPassword(dto.getPassword());
        model.setAmount(dto.getAmount());
        model.setTransactionsSender(dto.getTransactionsSender());
        model.setTransactionsRecipient(dto.getTransactionsRecipient());

        return model;
    }

    public ClientDTO toDTO(ClientModel model){
        ClientDTO dto = new ClientDTO();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setRegister(model.getRegister());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        dto.setAmount(model.getAmount());
        dto.setTransactionsSender(model.getTransactionsSender());
        dto.setTransactionsRecipient(model.getTransactionsRecipient());

        return dto;
    }
}
