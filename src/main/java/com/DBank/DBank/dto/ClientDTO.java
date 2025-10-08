package com.DBank.DBank.dto;

import com.DBank.DBank.model.TransactionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private UUID id;

    private String name;

    private String register;

    private String email;

    private String password;

    private double amount;

    private List<TransactionModel> transactionsSender;

    private List<TransactionModel> transactionsRecipient;
}
