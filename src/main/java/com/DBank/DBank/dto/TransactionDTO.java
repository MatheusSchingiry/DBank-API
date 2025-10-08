package com.DBank.DBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private UUID id;

    private UUID sender;

    private String senderEmail;

    private UUID recipientClient;

    private UUID recipientEnterprise;

    private String recipientEmail;

    private boolean authorization;

    private double amount;
}
