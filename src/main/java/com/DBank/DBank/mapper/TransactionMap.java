package com.DBank.DBank.mapper;

import com.DBank.DBank.dto.EnterpriseDTO;
import com.DBank.DBank.dto.TransactionDTO;
import com.DBank.DBank.model.ClientModel;
import com.DBank.DBank.model.EnterpriseModel;
import com.DBank.DBank.model.TransactionModel;
import com.DBank.DBank.repository.ClientRepository;
import com.DBank.DBank.repository.TransactionRepository;
import org.springframework.stereotype.Component;

@Component
public class TransactionMap {

    private final ClientRepository repository;

    public TransactionMap(ClientRepository repository) {
        this.repository = repository;
    }

    public TransactionModel toModel(TransactionDTO dto) {
        TransactionModel model = new TransactionModel();

        model.setId(dto.getId());

        if (dto.getSender() != null) {
            ClientModel sender = repository.findById(dto.getSender())
                    .orElseThrow(() -> new RuntimeException("Sender not found"));
            model.setSender(sender);
        }

        model.setSenderEmail(dto.getSenderEmail());

        if (dto.getRecipientClient() != null) {
            ClientModel recipientClient = new ClientModel();
            recipientClient.setId(dto.getRecipientClient());
            model.setRecipientClient(recipientClient);
        }

        if (dto.getRecipientEnterprise() != null) {
            EnterpriseModel recipientEnterprise = new EnterpriseModel();
            recipientEnterprise.setId(dto.getRecipientEnterprise());
            model.setRecipientEnterprise(recipientEnterprise);
        }

        model.setRecipientEmail(dto.getRecipientEmail());
        model.setAuthorization(dto.isAuthorization());
        model.setAmount(dto.getAmount());

        return model;
    }

    public TransactionDTO toDTO(TransactionModel model){
        TransactionDTO dto = new TransactionDTO();

        dto.setId(model.getId());
        dto.setSender(model.getSender() != null ? model.getSender().getId() : null);
        dto.setSenderEmail(model.getSenderEmail());
        dto.setRecipientClient(model.getRecipientClient() != null ? model.getRecipientClient().getId() : null);
        dto.setRecipientEnterprise(model.getRecipientEnterprise() != null ? model.getRecipientEnterprise().getId() : null);
        dto.setRecipientEmail(model.getRecipientEmail());
        dto.setAuthorization(model.isAuthorization());
        dto.setAmount(model.getAmount());

        return dto;
    }
}
