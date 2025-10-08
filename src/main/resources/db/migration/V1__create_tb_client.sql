CREATE TABLE tb_client (
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    name TEXT NOT NULL,
    register TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    CONSTRAINT pk_tb_client PRIMARY KEY (id),
    CONSTRAINT uc_tb_client_register UNIQUE (register),
    CONSTRAINT uc_tb_client_email UNIQUE (email)
);