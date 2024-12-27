DROP DATABASE IF EXISTS fct;
CREATE DATABASE fct CHARACTER SET utf8mb4;
USE fct;

CREATE TABLE Alumnos (
    alumno_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_alumno VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    titulo VARCHAR(50) NOT NULL
);

INSERT INTO Alumnos (nombre_alumno, edad, titulo) VALUES
('Marina García', 21, 'DAM'),
('Alejandro Ruiz', 43, 'DAW'),
('Laura Martínez', 32, 'DAW'),
('Javier López', 24, 'DAM'),
('Sara Rodríguez', 21, 'ASIR');

CREATE TABLE Empresas (
    empresa_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(100) NOT NULL,
    sector VARCHAR(50) NOT NULL
);

INSERT INTO Empresas (nombre_empresa, sector) VALUES
('NTT DATA', 'Tecnología'),
('NEORIS', 'Data Science'),
('METAENLACE', 'Seguridad Informática'),
('SLANGO', 'Desarrollo Web'),
('AYESA', 'Cloud Computing');

CREATE TABLE Practicas (
    practica_id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    empresa_id INT NOT NULL,
    alumno_id INT NULL,
    FOREIGN KEY (empresa_id) REFERENCES Empresas(empresa_id) ON DELETE RESTRICT ON UPDATE CASCADE, 
    FOREIGN KEY (alumno_id) REFERENCES Alumnos(alumno_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO Practicas (fecha_inicio, fecha_fin, descripcion, empresa_id, alumno_id) VALUES
('2022-02-01', '2022-04-30', 'Desarrollo Web en Tech Innovators', 1, 1),
('2022-03-15', '2022-06-15', 'Análisis de Datos en Data Wizards', 2, 2),
('2022-04-10', '2022-06-30', 'Seguridad de Redes en SecureNet', 3, NULL),
('2022-05-01', '2022-07-31', 'Desarrollo de Software en Web Solutions', 4, NULL),
('2022-06-15', '2022-09-15', 'Cloud Computing en Cloud Systems', 5, NULL);

CREATE TABLE AlumnosCandPracticas (
    alumno_id INT,
    practica_id INT,
    PRIMARY KEY (alumno_id, practica_id),
    FOREIGN KEY (alumno_id) REFERENCES Alumnos(alumno_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (practica_id) REFERENCES Practicas(practica_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO AlumnosCandPracticas (alumno_id, practica_id) VALUES
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 3), 
(1, 3), 
(2, 1); 

