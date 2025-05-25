package com.DBank.DBank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne()
    @JoinColumn(name = "client_sender_id")
    private ClientModel sender;

    private String senderEmail;

    @ManyToOne()
    @JoinColumn(name = "client_recipient_id")
    private ClientModel recipientClient;

    @ManyToOne()
    @JoinColumn(name = "enterprise_recipient_id")
    private EnterpriseModel recipientEnterprise;

    private String recipientEmail;

    private boolean authorization;

    private double amount;
}
