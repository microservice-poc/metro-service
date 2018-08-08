CREATE TABLE METUSER.USER_DETAIL (
USERID NUMBER NOT NULL PRIMARY KEY,
USERNAME VARCHAR2(15 CHAR) NOT NULL,
FIRSTNAME VARCHAR2(100 CHAR) NOT NULL,
LASTNAME VARCHAR2(100 CHAR) NOT NULL,
GENDER CHAR(1 CHAR) NOT NULL,
AGE NUMBER(3,0),
DATEOFBIRTH DATE NOT NULL,
MOBILENO NUMBER(10,0) NOT NULL,
EMAIL VARCHAR2(250 CHAR) NOT NULL,
ADDRESSLINE1 VARCHAR2(200 CHAR) NOT NULL,
ADDRESSLINE2 VARCHAR2(200 CHAR),
ADDRESSLINE3 VARCHAR2(200 CHAR),
CITY VARCHAR2(100 CHAR),
STATE VARCHAR2(200 CHAR),
POSTALCODE VARCHAR2(50 CHAR),
COUNTRY VARCHAR2(100 CHAR),
LASTMODIFIEDDATETIME DATE DEFAULT CURRENT_DATE NOT NULL,
LASTMODIFIEDSIGNON VARCHAR2(50 CHAR) DEFAULT USER NOT NULL
);

CREATE UNIQUE INDEX IDX_USERDETAIL_UNIQUE ON METUSER.USER_DETAIL(USERID,USERNAME, EMAIL, MOBILENO);