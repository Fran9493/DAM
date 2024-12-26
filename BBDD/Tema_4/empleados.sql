# Script obtenido de José Juan Sánchez (https://josejuansanchez.org)
# Este contenido está bajo una licencia de Creative Commons Reconocimiento-NoComercial- CompartirIgual 4.0 Internacional.
# Esta licencia permite:
# 1) Compartir — copiar y redistribuir el material en cualquier medio o formato
# 2) Adaptar — remezclar, transformar y construir a partir del material
DROP DATABASE IF EXISTS empleados;
CREATE DATABASE empleados CHARACTER SET utf8mb4;
USE empleados;

CREATE TABLE provincia (
	codigo		NUMERIC(2) 		PRIMARY KEY,
    nombre		VARCHAR(100)	NOT NULL UNIQUE);
CREATE TABLE departamento (
	id 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre 		VARCHAR(100) NOT NULL,
	presupuesto DOUBLE UNSIGNED NOT NULL,
	gastos 		DOUBLE UNSIGNED NOT NULL);
CREATE TABLE empleado (
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nif 			VARCHAR(9) NOT NULL UNIQUE,
	nombre 			VARCHAR(100) NOT NULL,
	apellido1 		VARCHAR(100) NOT NULL,
	apellido2 		VARCHAR(100) NULL,
	id_departamento INT UNSIGNED NULL,
    cod_provincia	NUMERIC(2) NOT NULL,
	FOREIGN KEY (id_departamento) REFERENCES departamento(id),
    FOREIGN KEY (cod_provincia) REFERENCES provincia(codigo)
);

INSERT INTO provincia VALUES (30,'MURCIA');
INSERT INTO provincia VALUES (41,'SEVILLA');
INSERT INTO provincia VALUES (21,'HUELVA');
INSERT INTO provincia VALUES (28,'MADRID');
INSERT INTO provincia VALUES (8,'BARCELONA');
INSERT INTO provincia VALUES (23,'JAEN');

INSERT INTO departamento VALUES(1, 'Desarrollo', 120000, 6000);
INSERT INTO departamento VALUES(2, 'Sistemas', 150000, 21000);
INSERT INTO departamento VALUES(3, 'Recursos Humanos', 280000, 25000);
INSERT INTO departamento VALUES(4, 'Contabilidad', 110000, 3000);
INSERT INTO departamento VALUES(5, 'I+D', 375000, 380000);
INSERT INTO departamento VALUES(6, 'Proyectos', 0, 0);
INSERT INTO departamento VALUES(7, 'Publicidad', 0, 1000);

INSERT INTO empleado VALUES(1, '32481596F', 'Aarón', 'Rivero', 'Gómez', 1, 30);
INSERT INTO empleado VALUES(2, 'Y5575632D', 'Adela', 'Salas', 'Díaz', 2, 41);
INSERT INTO empleado VALUES(3, 'R6970642B', 'Adolfo', 'Rubio', 'Flores', 3, 30);
INSERT INTO empleado VALUES(4, '77705545E', 'Adrián', 'Suárez', NULL, 4, 21);
INSERT INTO empleado VALUES(5, '17087203C', 'Marcos', 'Loyola', 'Méndez', 5, 28);
INSERT INTO empleado VALUES(6, '38382980M', 'María', 'Santana', 'Moreno', 1, 30);
INSERT INTO empleado VALUES(7, '80576669X', 'Pilar', 'Ruiz', NULL, 2, 23);
INSERT INTO empleado VALUES(8, '71651431Z', 'Pepe', 'Ruiz', 'Santana', 3, 30);
INSERT INTO empleado VALUES(9, '56399183D', 'Juan', 'Gómez', 'López', 2, 30);
INSERT INTO empleado VALUES(10, '46384486H', 'Diego','Flores', 'Salas', 5, 28);
INSERT INTO empleado VALUES(11, '67389283A', 'Marta','Herrera', 'Gil', 1, 28);
INSERT INTO empleado VALUES(12, '41234836R', 'Irene','Salas', 'Flores', NULL, 30);
INSERT INTO empleado VALUES(13, '82635162B', 'Juan Antonio','Sáez', 'Guerrero', NULL, 21);