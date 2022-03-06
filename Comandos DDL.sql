CREATE TABLE empresa (
    id_empresa NUMBER(4) NOT NULL,
    nm_empresa VARCHAR2(30) NOT NULL,
    cnpj       VARCHAR2(14) NOT NULL,
    endereco   VARCHAR2(80) NOT NULL,
    telefone   VARCHAR2(14) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( id_empresa );

CREATE TABLE cliente (
    id_cliente NUMBER(4) NOT NULL,
    id_empresa NUMBER(4) NOT NULL,
    nm_cliente VARCHAR2(50) NOT NULL,
    cnpj       VARCHAR2(50) NOT NULL,
    endereco   VARCHAR2(60) NOT NULL,
    telefone   VARCHAR2(14) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT clientes_pk PRIMARY KEY ( id_cliente );

CREATE TABLE funcionario (
    id_funcionario NUMBER(4) NOT NULL,
    id_empresa     NUMBER(4) NOT NULL,
    nm_funcionario VARCHAR2(50) NOT NULL,
    rg             VARCHAR2(10) NOT NULL,
    endereco       VARCHAR2(80) NOT NULL,
    telefone       VARCHAR2(14) NOT NULL,
    salario        NUMBER NOT NULL
);

ALTER TABLE funcionario ADD CONSTRAINT funcionários_pk PRIMARY KEY ( id_funcionario );

CREATE TABLE produtos (
    id_produto  NUMBER(4) NOT NULL,
    id_empresa  NUMBER(4) NOT NULL,
    nm_produto  VARCHAR2(50) NOT NULL,
    vl_unitario NUMBER(10) NOT NULL,
    funcao      VARCHAR2(60) NOT NULL
);

ALTER TABLE produtos ADD CONSTRAINT produtos_pk PRIMARY KEY ( id_produto );

CREATE TABLE servicos (
    id_servico     NUMBER(4) NOT NULL,
    id_empresa     NUMBER(4) NOT NULL,
    id_funcionario NUMBER(4) NOT NULL,
    nm_servico     VARCHAR2(40) NOT NULL,
    valor_servico  NUMBER NOT NULL
);

ALTER TABLE servicos ADD CONSTRAINT serviços_pk PRIMARY KEY ( id_servico );

ALTER TABLE cliente ADD CONSTRAINT cliente_empresa_fk FOREIGN KEY ( id_empresa )REFERENCES empresa ( id_empresa );

ALTER TABLE funcionario ADD CONSTRAINT funcionario_empresa_fk FOREIGN KEY ( id_empresa ) REFERENCES empresa ( id_empresa );

ALTER TABLE produtos ADD CONSTRAINT produtos_empresa_fk FOREIGN KEY ( id_empresa ) REFERENCES empresa ( id_empresa );

ALTER TABLE servicos ADD CONSTRAINT servicos_empresa_fk FOREIGN KEY ( id_empresa ) REFERENCES empresa ( id_empresa );

ALTER TABLE servicos ADD CONSTRAINT servicos_funcionario_fk FOREIGN KEY ( id_funcionario ) REFERENCES funcionario ( id_funcionario );


