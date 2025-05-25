package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.EnterpriseDTO;
import com.DBank.DBank.dto.TransactionDTO;
import com.DBank.DBank.model.EnterpriseModel;
import com.DBank.DBank.model.TransactionModel;
import org.springframework.stereotype.Component;

@Component
public class TransactionMap {

    public TransactionModel toModel(TransactionDTO dto){
        TransactionModel model = new TransactionModel();

        model.setId(dto.getId());
        model.setSender(dto.getSender());
        model.setRecipientClient(dto.getRecipientClient());
        model.setRecipientEnterprise(dto.getRecipientEnterprise());

        return model;
    }

    public TransactionDTO toDTO(TransactionModel model){
        TransactionDTO dto = new TransactionDTO();

        dto.setId(model.getId());
        dto.setSender(model.getSender());
        dto.setRecipientClient(model.getRecipientClient());
        dto.setRecipientEnterprise(model.getRecipientEnterprise());

        return dto;
    }
}
