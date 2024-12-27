DROP DATABASE IF EXISTS institutos;
CREATE DATABASE institutos CHARACTER SET utf8mb4;
USE institutos;

CREATE TABLE IF NOT EXISTS TInstituto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) not null,
    direccion VARCHAR(255) not null,
    localidad VARCHAR(100) not null,
    telefono VARCHAR(15) not null);
    
INSERT INTO TInstituto (nombre, direccion, localidad, telefono) VALUES
('IES Vicente Medina', 'C/. Vaso Ibérico de los Guerreros, S/N', 'ARCHENA', '968670157'),
('IES Los Albares', 'C/ Vereda de Morcillo S/N', 'CIEZA', '968773077'),
('IES Valle del Segura', 'Av. Río Segura, nº 10', 'BLANCA', '968459348');

CREATE TABLE IF NOT EXISTS TAlumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) not null,
    fecha_nacimiento DATE,
    direccion VARCHAR(255),
    correo VARCHAR(255),
    telefono VARCHAR(15),
    instituto_id INT,
    constraint fk_alumno_instituto FOREIGN KEY (instituto_id) 
		REFERENCES TInstituto(id) On delete restrict On Update Cascade
);

INSERT INTO TAlumno	(nombre, fecha_nacimiento, direccion, correo, telefono, instituto_id) VALUES
('Juan Pérez', '2000-01-15', 'Calle 123, Ciudad A', 'juan@example.com', '123456789', 1),
('Ana García', '1999-05-22', 'Avenida XYZ, Ciudad B', 'ana@example.com', '987654321', 2),
('Pedro López', '1998-11-10', 'Calle Principal, Ciudad A', 'pedro@example.com', '555555555', 1),
('María Rodríguez', '2001-03-05', 'Calle Secundaria, Ciudad C', 'maria@example.com', '777777777', 3),
('Carlos Sánchez', '1997-08-18', 'Avenida Central, Ciudad B', 'carlos@example.com', '999999999', 2);


