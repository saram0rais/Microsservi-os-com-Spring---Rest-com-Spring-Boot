CREATE SEQUENCE SEQ_EMERGENCIAS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE T_EMERGENCIAS (

                                      RECURSOS_POLICIAIS_ID INTEGER DEFAULT SEQ_EMERGENCIAS.NEXTVAL NOT NULL,
                                      id VARCHAR2(100) NOT NULL,
                                      localizacao VARCHAR2(100) NOT NULL,
                                      dataEmergencia DATE,
                                      descricao VARCHAR2(100) NOT NULL,
                                      status VARCHAR2(20) NOT NULL

                                      PRIMARY KEY (id)

);