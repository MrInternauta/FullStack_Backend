-- FIRST SELECT THE DATABASE
-- INSERT ROLES
INSERT INTO `ROLES` (`id`, `name`, `description`) VALUES (NULL, 'ADMIN', 'Was a superAdmin'), (NULL, 'CLIENT', 'Was a simple user');

-- INSERT USERS
INSERT INTO `USERS` (`id`, `name`, `email`, `password`, `imageUrl`, `createdAt`, `lastLogin`, `idRol`) VALUES (NULL, 'Juan Rodriguez', 'juan_rdz@gmail.com', '123456', NULL, '2021-08-26 00:00:00', NULL, '1'), (NULL, 'Maria Cortes', 'm_cortes@gmail.com', '123456', NULL, '2021-08-26 00:00:00', NULL, '2');
INSERT INTO `USERS` (`id`, `name`, `email`, `password`, `imageUrl`, `createdAt`, `lastLogin`, `idRol`) VALUES (NULL, 'Ricardo Sanchez', 'rick_sanchez@gmail.com', '123456', NULL, '2021-08-27 00:00:00', NULL, '2'), (NULL, 'Martin Smith', 'morty_s@gmail.com', '123456', NULL, '2021-08-28 00:00:00', NULL, '2');

-- INSERT TASKS
INSERT INTO `TASKS` (`id`, `name`, `done`, `createdAt`, `idUser`) VALUES (NULL, 'Levantamiento de requerimientos', '1', '2021-08-26 00:00:00', '2'), (NULL, 'Analizar los requerimientos', NULL, '2021-08-27 00:00:00', '3'), (NULL, 'Diseñar diagramas de casos de uso', NULL, '2021-08-29 00:00:00', '4');
