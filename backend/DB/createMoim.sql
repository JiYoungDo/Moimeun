use db;

CREATE TABLE moim(
    moim_link VARCHAR(100) NOT NULL,
    moim_name VARCHAR(50) NOT NULL,
    moim_place VARCHAR(50),
    moim_pwd VARCHAR(50),
    moim_size BOOL NOT NULL,
    moim_money INT,
    moim_repeat DATETIME,
    moim_leader VARCHAR(50) NOT NULL,
    PRIMARY KEY(`moim_link`),
    FOREIGN KEY(`moim_leader`) REFERENCES customer(customer_id)   
);