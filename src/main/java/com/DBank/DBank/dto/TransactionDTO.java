package com.DBank.DBank.dto;

import com.DBank.DBank.model.ClientModel;
import com.DBank.DBank.model.EnterpriseModel;

public class TransactionDTO {

    private String id;

    private ClientModel sender;

    private ClientModel recipientClient;

    private EnterpriseModel recipientEnterprise;
}
