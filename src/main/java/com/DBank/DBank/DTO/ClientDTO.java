package com.DBank.DBank.DTO;

import com.DBank.DBank.Model.TransactionModel;
import jakarta.validation.constraints.Email;
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

    @Email
    private String email;

    private String password;

    private double amount;

    private List<TransactionModel> transactionsSender;

    private List<TransactionModel> transactionsRecipient;
}
