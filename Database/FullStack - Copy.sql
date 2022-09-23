CREATE TABLE
IF NOT EXISTS users
( idusers INT NOT NULL AUTO_INCREMENT, nameUsers VARCHAR
(100) NOT NULL, emailUsers VARCHAR
(45) NOT NULL, password VARCHAR
(256) NOT NULL, image_url VARCHAR
(128) NULL, created_at DATETIME NOT NULL, lastLogin DATETIME NULL, PRIMARY KEY
(idusers))ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- -----------------------------------------------------
-- Table rols
-- -----------------------------------------------------
CREATE TABLE
IF NOT EXISTS rols
(
  idrols INT NOT NULL AUTO_INCREMENT,
  nameRole VARCHAR
(45) NOT NULL,
  descriptionRole VARCHAR
(45) NULL,
  c TINYINT NULL,
r TINYINT NULL,
  u TINYINT NULL,
  d TINYINT
NULL,
  PRIMARY KEY
(idrols)) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- Table users_rols
-- -----------------------------------------------------
CREATE TABLE
IF NOT EXISTS users_rols
(
  id_user INT NOT NULL,
  id_role INT NOT NULL,
  PRIMARY KEY
(id_user, id_role),
  CONSTRAINT id_user_FK
    FOREIGN KEY
(id_user)
    REFERENCES users
(idusers)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION,
  CONSTRAINT id_role_FK
FOREIGN KEY
(id_role)
    REFERENCES rols
(idrols)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- -----------------------------------------------------
-- Table taks
-- -----------------------------------------------------
CREATE TABLE
IF NOT EXISTS tasks
(
  idtasks INT NOT NULL AUTO_INCREMENT,
  nameTask VARCHAR
(45) NOT NULL,
  done TINYINT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY
(idtaks)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
