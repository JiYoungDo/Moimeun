use db;

CREATE TABLE customer(
    customer_id VARCHAR(50) NOT NULL,
    customer_pwd VARCHAR(50) NOT NULL,
    customer_name VARCHAR(10) NOT NULL,
    customer_birth DATE NOT NULL,
    customer_email VARCHAR(50) NOT NULL,
    customer_penalty INT,
    customer_level INT,
    customer_latitude FLOAT,
    customer_longitude FLOAT,
    customer_profile BLOB,
    PRIMARY KEY(`customer_id`)
);