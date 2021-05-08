DROP DATABASE pos;
CREATE DATABASE pos;
USE pos;
CREATE TABLE customer(
        id varchar(5),
        name varchar(25),
        address varchar(25),
        salary varchar(25),
        CONSTRAINT PRIMARY KEY (id)
);
SELECT * FROM customer;