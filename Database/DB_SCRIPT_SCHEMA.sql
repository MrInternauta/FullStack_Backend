CREATE DATABASE IF NOT EXISTS DB_TASKS;
USE DB_TASKS;
-- -----------------------------------------------------
-- Table ROLES
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ROLES (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(45) NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX idrols_UNIQUE (id ASC) )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table USERS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS USERS (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(45) NOT NULL,
    password VARCHAR(256) NOT NULL,
    imageUrl VARCHAR(128) NULL,
    createdAt DATETIME NOT NULL,
    lastLogin DATETIME NULL,
    idRol INT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX idusers_UNIQUE (id ASC),
    UNIQUE INDEX email_UNIQUE (email ASC) ,
    INDEX USER_ROL_idx (idRol ASC) ,
    CONSTRAINT USER_ROL
    FOREIGN KEY (idRol)
    REFERENCES ROLES (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table TASKS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TASKS (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    done TINYINT NULL,
    createdAt DATETIME NULL,
    idUser INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX idtaks_UNIQUE (id ASC) ,
    INDEX TASK_USER_idx (idUser ASC) ,
    CONSTRAINT TASK_USER
    FOREIGN KEY (idUser)
    REFERENCES USERS (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;