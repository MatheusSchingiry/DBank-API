package com.DBank.DBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseDTO {

    private String id;

    private String name;

    private String register;

    private String email;

    private String password;

    private double amount;
}
