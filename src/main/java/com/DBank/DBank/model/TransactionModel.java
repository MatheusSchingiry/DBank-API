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
    @JoinColumn(name = "senderClient_id")
    private ClientModel sender;

    private String senderEmail;

    @ManyToOne()
    @JoinColumn(name = "recipientClient_id")
    private ClientModel recipientClient;

    @ManyToOne()
    @JoinColumn(name = "recipientEnterprise_id")
    private EnterpriseModel recipientEnterprise;

    private String recipientEmail;

    @Column(name = "is_authorization")
    private boolean authorization;

    private double amount;
}
