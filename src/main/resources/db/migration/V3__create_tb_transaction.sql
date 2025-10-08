CREATE TABLE tb_transaction (
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    senderClient_id UUID NOT NULL,
    senderEmail TEXT NULL,
    recipientClient_id UUID NULL,
    recipientEnterprise_id UUID NULL,
    recipientEmail TEXT NULL,
    is_authorization BOOLEAN NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    CONSTRAINT pk_tb_transaction PRIMARY KEY (id),
    CONSTRAINT fk_transaction_sender_client FOREIGN KEY (senderClient_id) REFERENCES tb_client(id),
    CONSTRAINT fk_transaction_recipient_client FOREIGN KEY (recipientClient_id) REFERENCES tb_client(id),
    CONSTRAINT fk_transaction_recipient_enterprise FOREIGN KEY (recipientEnterprise_id) REFERENCES tb_enterprise(id),
    CONSTRAINT chk_one_recipient_type CHECK (
        (recipientClient_id IS NOT NULL AND recipientEnterprise_id IS NULL)
        OR
        (recipientClient_id IS NULL AND recipientEnterprise_id IS NOT NULL)
    )
);