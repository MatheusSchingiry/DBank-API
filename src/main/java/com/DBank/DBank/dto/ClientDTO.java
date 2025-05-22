package com.DBank.DBank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String register;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private double amount;
}
