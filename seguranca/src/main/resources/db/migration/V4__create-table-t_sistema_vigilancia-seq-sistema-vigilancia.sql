CREATE SEQUENCE SEQ_SISTEMA_VIGILANCIA
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE T_SISTEMA_VIGILANCIA (

                                    RECURSOS_POLICIAIS_ID INTEGER DEFAULT SEQ_SISTEMA_VIGILANCIA.NEXTVAL NOT NULL,
                                    id VARCHAR2(100) NOT NULL,
                                    nomeSistema VARCHAR2(100) NOT NULL,
                                    localizacao VARCHAR2(100) NOT NULL,
                                    descricao VARCHAR2(100) NOT NULL,
                                    status VARCHAR2(20) NOT NULL,
                                    resolucao_video VARCHAR2(20) NOT NULL,
                                    ultima_manutencao DATE,
                                    responsavel_manutencao VARCHAR2(100) NOT NULL,
                                    registroIncidentes VARCHAR2(100) NOT NULL,

                                    PRIMARY KEY (id)

);
