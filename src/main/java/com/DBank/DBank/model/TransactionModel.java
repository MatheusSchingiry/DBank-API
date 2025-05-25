package com.DBank.DBank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne()
    @JoinColumn(name = "client_sender_id")
    private ClientModel sender;

    @ManyToOne()
    @JoinColumn(name = "client_recipient_id")
    private ClientModel recipientClient;

    @ManyToOne()
    @JoinColumn(name = "enterprise_recipient_id")
    private EnterpriseModel recipientEnterprise;

    public TransactionModel() {
    }

    public TransactionModel(String id, ClientModel sender, ClientModel recipientClient, EnterpriseModel recipientEnterprise) {
        this.id = id;
        this.sender = sender;
        this.recipientClient = recipientClient;
        this.recipientEnterprise = recipientEnterprise;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientModel getSender() {
        return sender;
    }

    public void setSender(ClientModel sender) {
        this.sender = sender;
    }

    public ClientModel getRecipientClient() {
        return recipientClient;
    }

    public void setRecipientClient(ClientModel recipientClient) {
        this.recipientClient = recipientClient;
    }

    public EnterpriseModel getRecipientEnterprise() {
        return recipientEnterprise;
    }

    public void setRecipientEnterprise(EnterpriseModel recipientEnterprise) {
        this.recipientEnterprise = recipientEnterprise;
    }
}
