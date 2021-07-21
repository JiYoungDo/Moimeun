use db;

CREATE TABLE moim_calander(
    calander_sid INT NOT NULL AUTO_INCREMENT,
    moim_link VARCHAR(100) NOT NULL,
    calander_name VARCHAR(10) NOT NULL,
    calander_startDate DATETIME NOT NULL,
    calander_endDate DATETIME NOT NULL,
    calander_repeat CHAR(1) NOT NULL,
    PRIMARY KEY(`calander_sid`),
    FOREIGN KEY(`moim_link`) REFERENCES moim(moim_link)
);