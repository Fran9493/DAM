DROP DATABASE IF EXISTS modulos;
CREATE DATABASE modulos CHARACTER SET utf8mb4;
USE modulos;

CREATE TABLE MODULO (
codigo 				  INT PRIMARY KEY,
nombre   		      VARCHAR(100) NOT NULL,
horas_semanales		  INT NOT NULL,
curso_imparte		  INT,
constraint ck_curso_imparte CHECK(curso_imparte In (1,2)),
constraint ck_horas_semanas check(horas_semanales>0 and horas_semanales<20));

-- Inserciones en la tabla MODULO
INSERT INTO MODULO (codigo, nombre, horas_semanales, curso_imparte) VALUES
(1, 'Programación', 7, 1),
(2, 'Base de Datos', 5, 1),
(3, 'Entornos de Desarrollo', 3, 1),
(4, 'Acceso a Datos', 5, 2),
(5, 'Lenguaje de Marcas', 6, 2);