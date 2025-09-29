package com.DBank.DBank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
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

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<TransactionModel> transactionsSender = new ArrayList<>();

    @OneToMany(mappedBy = "recipientClient", cascade = CascadeType.ALL)
    private List<TransactionModel> transactionsRecipient = new ArrayList<>();
}
