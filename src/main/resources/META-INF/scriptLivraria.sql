--------------------------------------------------------
--  Arquivo criado - Segunda-feira-Maio-11-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence S_EDITORA
--------------------------------------------------------

   CREATE SEQUENCE  "BRUNO2"."S_EDITORA"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence S_LIVRO
--------------------------------------------------------

   CREATE SEQUENCE  "BRUNO2"."S_LIVRO"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table EDITORA
--------------------------------------------------------

  CREATE TABLE "BRUNO2"."EDITORA" 
   (	"ID" NUMBER, 
	"NOME" VARCHAR2(100 BYTE), 
	"DESCRICAO" VARCHAR2(255 BYTE), 
	"STATUS" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LIVRO
--------------------------------------------------------

  CREATE TABLE "BRUNO2"."LIVRO" 
   (	"ID" NUMBER, 
	"ID_EDITORA" NUMBER, 
	"NOME" VARCHAR2(100 BYTE), 
	"AUTOR" VARCHAR2(100 BYTE), 
	"DESCRICAO" VARCHAR2(255 BYTE), 
	"PRECO" FLOAT(126), 
	"STATUS" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "BRUNO2"."USUARIO" 
   (	"CPF" VARCHAR2(20 BYTE), 
	"NOME" VARCHAR2(100 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"SEXO" VARCHAR2(5 BYTE), 
	"SENHA" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into BRUNO2.EDITORA
SET DEFINE OFF;
Insert into BRUNO2.EDITORA (ID,NOME,DESCRICAO,STATUS) values ('1','Editora 1',null,'0');
Insert into BRUNO2.EDITORA (ID,NOME,DESCRICAO,STATUS) values ('2','Editora 2','xx','0');
REM INSERTING into BRUNO2.LIVRO
SET DEFINE OFF;
Insert into BRUNO2.LIVRO (ID,ID_EDITORA,NOME,AUTOR,DESCRICAO,PRECO,STATUS) values ('1','1','Todos Aqui','xxx',null,'10','0');
Insert into BRUNO2.LIVRO (ID,ID_EDITORA,NOME,AUTOR,DESCRICAO,PRECO,STATUS) values ('2','2','Mais um livro','rr',null,'10,1','0');
Insert into BRUNO2.LIVRO (ID,ID_EDITORA,NOME,AUTOR,DESCRICAO,PRECO,STATUS) values ('3','1','AAA','XX',null,'74','1');
Insert into BRUNO2.LIVRO (ID,ID_EDITORA,NOME,AUTOR,DESCRICAO,PRECO,STATUS) values ('4','1','DDD','b',null,'74','0');
Insert into BRUNO2.LIVRO (ID,ID_EDITORA,NOME,AUTOR,DESCRICAO,PRECO,STATUS) values ('5','1','Biscoito','qq','aa','41','0');
REM INSERTING into BRUNO2.USUARIO
SET DEFINE OFF;
Insert into BRUNO2.USUARIO (CPF,NOME,EMAIL,SEXO,SENHA) values ('123','Bruno','b@b.com','M','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');
--------------------------------------------------------
--  DDL for Index USUARIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BRUNO2"."USUARIO_PK" ON "BRUNO2"."USUARIO" ("CPF") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TABLE1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BRUNO2"."TABLE1_PK" ON "BRUNO2"."LIVRO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TABLE2_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BRUNO2"."TABLE2_PK" ON "BRUNO2"."EDITORA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table LIVRO
--------------------------------------------------------

  ALTER TABLE "BRUNO2"."LIVRO" ADD CONSTRAINT "TABLE1_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BRUNO2"."LIVRO" MODIFY ("PRECO" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."LIVRO" MODIFY ("AUTOR" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."LIVRO" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."LIVRO" MODIFY ("ID_EDITORA" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."LIVRO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "BRUNO2"."USUARIO" ADD CONSTRAINT "USUARIO_PK" PRIMARY KEY ("CPF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BRUNO2"."USUARIO" MODIFY ("SENHA" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."USUARIO" MODIFY ("SEXO" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."USUARIO" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."USUARIO" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."USUARIO" MODIFY ("CPF" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EDITORA
--------------------------------------------------------

  ALTER TABLE "BRUNO2"."EDITORA" ADD CONSTRAINT "TABLE2_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BRUNO2"."EDITORA" MODIFY ("NOME" NOT NULL ENABLE);
  ALTER TABLE "BRUNO2"."EDITORA" MODIFY ("ID" NOT NULL ENABLE);