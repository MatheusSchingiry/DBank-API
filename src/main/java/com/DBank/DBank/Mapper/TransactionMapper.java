package com.DBank.DBank.Mapper;

import com.DBank.DBank.DTO.TransactionDTO;
import com.DBank.DBank.Model.ClientModel;
import com.DBank.DBank.Model.EnterpriseModel;
import com.DBank.DBank.Model.TransactionModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "sender.id",           target = "sender")
    @Mapping(source = "senderEmail",         target = "senderEmail")
    @Mapping(source = "recipientClient.id",  target = "recipientClient")
    @Mapping(source = "recipientEnterprise.id", target = "recipientEnterprise")
    TransactionDTO toDTO(TransactionModel model);

    @Mapping(target = "sender",            ignore = true)
    @Mapping(source = "recipientClient",   target = "recipientClient", qualifiedByName = "uuidToClient")
    @Mapping(source = "recipientEnterprise", target = "recipientEnterprise", qualifiedByName = "uuidToEnterprise")
    TransactionModel toModel(TransactionDTO dto);

    @Named("uuidToClient")
    default ClientModel uuidToClient(java.util.UUID id) {
        if (id == null) return null;
        ClientModel client = new ClientModel();
        client.setId(id);
        return client;
    }

    @Named("uuidToEnterprise")
    default EnterpriseModel uuidToEnterprise(java.util.UUID id) {
        if (id == null) return null;
        EnterpriseModel enterprise = new EnterpriseModel();
        enterprise.setId(id);
        return enterprise;
    }
}