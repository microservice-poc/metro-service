-- sqlplus system/password@xe
-- 
-- 
-- create user train identified by password;
--grant CREATE SESSION, ALTER SESSION, CREATE DATABASE LINK, 
--  CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM, 
--  CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM, CREATE TABLE, 
--  CREATE TRIGGER, CREATE TYPE, CREATE VIEW, UNLIMITED TABLESPACE 
--  to train;
-- 
-- exit
  
sqlplus train/password@xe

--DROP TABLE ROUTE_STATION;
--DROP TABLE ROUTE;
--DROP TABLE STATION;

Table : TRAIN - columns = id, train_name, train_number, last_serviced_date
Table : COMPARTMENT - columns = id, compartment_no, compartment_type, number_of_seats, train_id(ForeignKey)



CREATE TABLE TRAIN.TRAIN (
  TRAIN_ID               NUMBER PRIMARY KEY,
  TRAIN_NAME             VARCHAR(100),
  TRAIN_NUMBER           NUMBER,
  LAST_SERVICED_DATE     DATE,
  LAST_MODIFIED_DATETIME TIMESTAMP  DEFAULT CURRENT_DATE
);

CREATE TABLE TRAIN.COMPARTMENT (
  COMPARTMENT_ID         NUMBER PRIMARY KEY,
  COMPARTMENT_NUMBER     NUMBER,
  COMPARTMENT_TYPE       VARCHAR(100),
  NUMBER_OF_SEATS        NUMBER,
  TRAIN_ID               NUMBER,
  LAST_MODIFIED_DATETIME TIMESTAMP  DEFAULT CURRENT_DATE
);


ALTER TABLE TRAIN.COMPARTMENT   ADD FOREIGN KEY (TRAIN_ID) REFERENCES TRAIN.TRAIN(TRAIN_ID);



--ALTER TABLE ROUTE         ADD FOREIGN KEY (START_STATION_ID) REFERENCES STATION(STATION_ID);
--ALTER TABLE ROUTE         ADD FOREIGN KEY (END_STATION_ID)   REFERENCES STATION(STATION_ID);

--ALTER TABLE ROUTE_STATION ADD FOREIGN KEY (ROUTE_ID)   REFERENCES ROUTE(ROUTE_ID);
--ALTER TABLE ROUTE_STATION ADD FOREIGN KEY (STATION_ID) REFERENCES STATION(STATION_ID);


---------------------------------------------------------------------------------------------------------
--This sequence is required by Hibernate for AUTO_INCREMENTING columns across the application
CREATE SEQUENCE train.hibernate_sequence
  INCREMENT BY 1
  MINVALUE 1
  MAXVALUE 9999999999999999999
;

-------------------------------------------------------------------------------------------------------