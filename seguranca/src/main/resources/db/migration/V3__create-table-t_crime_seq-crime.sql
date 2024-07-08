CREATE SEQUENCE SEQ_CRIME
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE T_CRIME (

                                    CRIME_ID INTEGER DEFAULT SEQ_CRIME.NEXTVAL NOT NULL,
                                    id VARCHAR2(100) NOT NULL,
                                    nomCrime VARCHAR2(100) NOT NULL,
                                    dataCrime DATE,
                                    localizacao VARCHAR2(100) NOT NULL,
                                    status VARCHAR2(20) NOT NULL,
                                    gravidade VARCHAR2(20) NOT NULL,
                                    armaUtilizada VARCHAR2(100) NOT NULL,
                                    descricao VARCHAR2(100) NOT NULL,

                                    PRIMARY KEY (id)

);
