package com.DBank.DBank.model;

public class TransactionModel {

    private String id;

    private ClientModel sender;

    private ClientModel recipientClient;

    private EnterpriseModel recipientEnterprise;

    private double amount;

    public TransactionModel() {
    }

    public TransactionModel(String id, ClientModel sender, ClientModel recipientClient, EnterpriseModel recipientEnterprise, double amount) {
        this.id = id;
        this.sender = sender;
        this.recipientClient = recipientClient;
        this.recipientEnterprise = recipientEnterprise;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
