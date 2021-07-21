use db;

CREATE TABLE place(
    place_sid INT NOT NULL AUTO_INCREMENT,
    place_name VARCHAR(20) NOT NULL,
    place_content VARCHAR(10),
    place_phone VARCHAR(20),
    place_road VARCHAR(50) NOT NULL,
    place_num VARCHAR(50) NOT NULL,
    place_isParking BOOL,
    place_latitude FLOAT NOT NULL,
    place_longitude FLOAT NOT NULL,
    place_star FLOAT,
    place_etc TEXT,
    place_keyword TEXT,
    PRIMARY KEY(`place_sid`)
);