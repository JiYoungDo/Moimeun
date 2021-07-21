use db;

CREATE TABLE customer_calander(
    calander_sid INT NOT NULL AUTO_INCREMENT,
    customer_id VARCHAR(50) NOT NULL,
    calander_name VARCHAR(10) NOT NULL,
    calander_startDate DATETIME NOT NULL,
    calander_endDate DATETIME NOT NULL,
    calander_repeat CHAR(1) NOT NULL,
    PRIMARY KEY(`calander_sid`),
    FOREIGN KEY(`customer_id`) REFERENCES customer(customer_id)
);