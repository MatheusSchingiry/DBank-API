package com.DBank.DBank.dto;

import com.DBank.DBank.model.TransactionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String id;

    private String name;

    private String register;

    private String email;

    private String password;

    private double amount;

    private List<TransactionModel> transactionsSender;

    private List<TransactionModel> transactionsRecipient;
}
