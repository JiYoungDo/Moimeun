use db;

CREATE TABLE moim_customer(
    moim_link VARCHAR(100) NOT NULL,
    customer_id VARCHAR(50) NOT NULL,
    PRIMARY KEY(`moim_link`,`customer_id`),
    FOREIGN KEY(`moim_link`) REFERENCES moim(`moim_link`),
    FOREIGN KEY(`customer_id`) REFERENCES customer(customer_id)
);