CREATE SEQUENCE SEQ_HABITANTES
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE T_HABITANTE (

        HABITANTE_ID INTEGER DEFAULT SEQ_HABITANTES.NEXTVAL NOT NULL,
        id VARCHAR2(100) NOT NULL,
        nome VARCHAR2(100) NOT NULL,
        genero VARCHAR2(20) NOT NULL,
        email VARCHAR2(30) NOT NULL,
        email VARCHAR2(100) NOT NULL,
        endereco_habitante VARCHAR2(100) NOT NULL,
        data_nascimento DATE,
        cpf VARCHAR2(30) NOT NULL,
        telefone INTEGER

        PRIMARY KEY (id)

);


