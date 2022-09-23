
-- SQLINES DEMO *** ------------------------------------
-- Table ROLES
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY

CREATE TABLE IF NOT EXISTS ROLES (
    id SERIAL NOT NULL,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(45) NULL,
    PRIMARY KEY (id),
    CONSTRAINT idrols_UNIQUE UNIQUE (id) )
    ;

-- SQLINES DEMO *** ------------------------------------
-- Table USERS
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY

CREATE TABLE IF NOT EXISTS USERS (
    id SERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(45) NOT NULL,
    password VARCHAR(256) NOT NULL,
    imageUrl VARCHAR(128) NULL,
    createdAt TIMESTAMP(0) NOT NULL,
    lastLogin TIMESTAMP(0) NULL,
    idRol SERIAL NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT idusers_UNIQUE UNIQUE (id),
    CONSTRAINT email_UNIQUE UNIQUE (email)
    ,
    CONSTRAINT USER_ROL
    FOREIGN KEY (idRol)
    REFERENCES ROLES (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
    ;


-- SQLINES DEMO *** ------------------------------------
-- Table TASKS
-- SQLINES DEMO *** ------------------------------------
-- SQLINES LICENSE FOR EVALUATION USE ONLY

CREATE TABLE IF NOT EXISTS TASKS (
    id SERIAL NOT NULL ,
    name VARCHAR(45) NOT NULL,
    done SMALLINT NULL,
    createdAt TIMESTAMP(0) NULL,
    idUser SERIAL NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT idtaks_UNIQUE UNIQUE (id)
    ,
    CONSTRAINT TASK_USER
    FOREIGN KEY (idUser)
    REFERENCES USERS (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ;


CREATE INDEX USER_ROL_idx ON USERS (idRol ASC);
CREATE INDEX TASK_USER_idx ON TASKS (idUser ASC);


CREATE SEQUENCE ROLES_seq;
CREATE SEQUENCE USERS_seq;
CREATE SEQUENCE TASKS_seq;