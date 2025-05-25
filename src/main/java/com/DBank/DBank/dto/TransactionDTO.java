package com.DBank.DBank.dto;

import com.DBank.DBank.model.ClientModel;
import com.DBank.DBank.model.EnterpriseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private String id;

    private ClientModel sender;

    private ClientModel recipientClient;

    private EnterpriseModel recipientEnterprise;
}
