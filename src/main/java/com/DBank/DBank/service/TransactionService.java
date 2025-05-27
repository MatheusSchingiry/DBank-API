package com.DBank.DBank.service;

import com.DBank.DBank.dto.TransactionDTO;
import com.DBank.DBank.mapper.TransactionMap;
import com.DBank.DBank.model.ClientModel;
import com.DBank.DBank.model.EnterpriseModel;
import com.DBank.DBank.model.TransactionModel;
import com.DBank.DBank.repository.ClientRepository;
import com.DBank.DBank.repository.EnterpriseRepository;
import com.DBank.DBank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private  final ClientRepository clientRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final TransactionRepository repository;
    private final TransactionMap mapper;

    public TransactionService(ClientRepository clientRepository, EnterpriseRepository enterpriseRepository, TransactionRepository repository, TransactionMap mapper) {
        this.clientRepository = clientRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    public TransactionDTO Operation(TransactionDTO dto){
        validationOperation(dto);

        TransactionModel model = mapper.toModel(dto);
        model = repository.save(model);

        isValidToken(dto.isAuthorization());
        transfer(dto);

        return mapper.toDTO(model);
    }

    public void validationOperation(TransactionDTO model){
        validatorSender(model);
        validatorRecipient(model);
    }

    public void isValidToken(boolean token){
        if(!token){
            throw(new RuntimeException("Transaction not Authorized"));
        }
    }

    public void validatorSender(TransactionDTO model){
        ClientModel existClient = clientRepository.findById(model.getSender()).orElseThrow(() -> new RuntimeException("Client not Found"));
        isEmailClient(existClient, model);
        isHaveBalance(existClient, model);
    }

    public void isEmailClient(ClientModel existClient, TransactionDTO model) {
        System.out.println("Exist Client: " +existClient.getEmail());
        System.out.println("Model: " +model.getSenderEmail());
        if (existClient.getEmail().equals(model.getSenderEmail())) { return; }
        else { throw(new RuntimeException("Enterprise cannot make Transfer")); }
    }

    public void isHaveBalance(ClientModel existClient, TransactionDTO model) {
        if (existClient.getAmount() >= model.getAmount()) { return; }
        else { throw (new RuntimeException("Insufficient Balance")); }
    }

    public void validatorRecipient(TransactionDTO model){
        if (model.getRecipientEnterprise() == null){
            ClientModel existClient = clientRepository.findById(model.getRecipientClient()).orElseThrow(() -> new RuntimeException("Client not Found"));
        }
        else {
            EnterpriseModel existEnterprise = enterpriseRepository.findById(model.getRecipientEnterprise())
                    .orElseThrow(() -> new RuntimeException("Enterprise not Found"));
        }
    }

    public void transfer(TransactionDTO model){
        ClientModel sender = clientRepository.findById(model.getSender()).orElseThrow(() -> new RuntimeException("Client not Found"));
        sender.setAmount(sender.getAmount() - model.getAmount());
        clientRepository.save(sender);

        if (model.getRecipientEnterprise() == null){
            ClientModel existClient = clientRepository.findById(model.getRecipientClient()).orElseThrow(() -> new RuntimeException("Client not Found"));
            existClient.setAmount(existClient.getAmount() + model.getAmount());
            clientRepository.save(existClient);
        }
        else {
            EnterpriseModel existEnterprise = enterpriseRepository.findById(model.getRecipientEnterprise())
                    .orElseThrow(() -> new RuntimeException("Enterprise not Found"));
            existEnterprise.setAmount(existEnterprise.getAmount() + model.getAmount());
            enterpriseRepository.save(existEnterprise);
        }
    }
}
