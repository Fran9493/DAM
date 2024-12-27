DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto CHARACTER SET utf8mb4;
USE instituto;

CREATE TABLE ALUMNO (
nre         		  INT PRIMARY KEY,
nombre   		      VARCHAR(100) NOT NULL,
apellidos	          VARCHAR(100) NOT NULL,
telefono			  VARCHAR(20) NULL);

CREATE TABLE MODULO (
codigo 				  INT PRIMARY KEY,
nombre   		      VARCHAR(100) NOT NULL,
horas_semanales		  INT NOT NULL,
curso_imparte		  INT,
constraint ck_curso_imparte CHECK(curso_imparte In (1,2)),
constraint ck_horas_semanas check(horas_semanales>0 and horas_semanales<20));

CREATE TABLE MATRICULA (
nre_alumno	INT NOT NULL,
cod_modulo	INT NOT NULL,
constraint pk_matricula Primary Key (nre_alumno, cod_modulo),
constraint fk_matricula_alumno Foreign key (nre_alumno) references Alumno(nre)
   On delete restrict On update cascade,
constraint fk_matricula_modulo Foreign key (cod_modulo) references Modulo(codigo)
   On delete restrict On update cascade);
   
-- Inserciones en la tabla ALUMNO
INSERT INTO ALUMNO (nre, nombre, apellidos, telefono) VALUES
(1, 'Guillermo', 'Palazón Cano', '11111111'),
(2, 'María', 'Gómez Cano', '11111112'),
(3, 'Luisa', 'López Fernández', '11111113');

-- Inserciones en la tabla MODULO
INSERT INTO MODULO (codigo, nombre, horas_semanales, curso_imparte) VALUES
(1, 'Programación', 7, 1),
(2, 'Base de Datos', 5, 1),
(3, 'Entornos de Desarrollo', 3, 1),
(4, 'Acceso a Datos', 5, 2),
(5, 'Lenguaje de Marcas', 6, 2);

-- Inserciones en la tabla MATRICULA
INSERT INTO MATRICULA (nre_alumno, cod_modulo) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5);