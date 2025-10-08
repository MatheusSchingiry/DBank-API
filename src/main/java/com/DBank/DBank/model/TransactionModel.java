package com.DBank.DBank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@Table(name = "tb_transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
