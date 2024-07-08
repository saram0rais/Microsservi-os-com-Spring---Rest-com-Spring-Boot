CREATE SEQUENCE SEQ_RECURSOS_POLICIAIS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE T_RECURSO_POLICIAL (
        RECURSOS_POLICIAIS_ID INTEGER DEFAULT SEQ_RECURSOS_POLICIAIS.NEXTVAL NOT NULL,
        id VARCHAR2(100) NOT NULL,
        nome VARCHAR2(100) NOT NULL,
        status VARCHAR2(20) NOT NULL,
        localizacao VARCHAR2(100) NOT NULL,
        agentes VARCHAR2(100) NOT NULL,
        delegacias VARCHAR2(20) NOT NULL,
        capacidade INTEGER,
        data_aquisicao DATE,
        ultima_manutencao DATE,
        responsavel_manutencao VARCHAR2(100) NOT NULL

        PRIMARY KEY (id)
);



