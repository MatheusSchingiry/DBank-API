package com.DBank.DBank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
    private String register;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private double amount;

    @OneToMany(mappedBy = "client_sender", cascade = CascadeType.ALL)
    private List<TransactionModel> transactionsSender = new ArrayList<>();

    @OneToMany(mappedBy = "client_recipient", cascade = CascadeType.ALL)
    private List<TransactionModel> transactionsRecipient = new ArrayList<>();

    public ClientModel() {
    }

    public ClientModel(String id, String name, String register, String email, String password, double amount, List<TransactionModel> transactionsSender, List<TransactionModel> transactionsRecipient) {
        this.id = id;
        this.name = name;
        this.register = register;
        this.email = email;
        this.password = password;
        this.amount = amount;
        this.transactionsSender = transactionsSender;
        this.transactionsRecipient = transactionsRecipient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<TransactionModel> getTransactionsSender() {
        return transactionsSender;
    }

    public void setTransactionsSender(List<TransactionModel> transactionsSender) {
        this.transactionsSender = transactionsSender;
    }

    public List<TransactionModel> getTransactionsRecipient() {
        return transactionsRecipient;
    }

    public void setTransactionsRecipient(List<TransactionModel> transactionsRecipient) {
        this.transactionsRecipient = transactionsRecipient;
    }
}
