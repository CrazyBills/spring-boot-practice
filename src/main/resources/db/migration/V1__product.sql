CREATE TABLE PRODUCT
(
  ID           VARCHAR(32) NOT NULL PRIMARY KEY,
  JSON_CONTENT VARCHAR(500) NOT NULL,
  NAME         VARCHAR(100) ,
  PRICE        DECIMAL ,
  DESCRIPTION  VARCHAR(500) ,
  CREATED_AT   BIGINT
);
