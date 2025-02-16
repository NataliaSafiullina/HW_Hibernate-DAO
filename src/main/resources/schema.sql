CREATE TABLE IF NOT EXISTS `netology`.`persons` (
    `name` VARCHAR(255) NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL CHECK (`age`>= 0),
    `phone_number` VARCHAR(20),
    `city_of_living` VARCHAR(100),
    PRIMARY KEY (`name`,`surname`,`age`)
);