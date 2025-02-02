drop database if exists empleados;
create database empleados;
use empleados;
create table if not exists depart(
        dept_no INT NOT NULL,
        dnombre VARCHAR(30),
        loc VARCHAR(30),
        PRIMARY KEY(dept_no)
);

create table if not exists emple(
    emp_no 	INT NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    oficio ENUM('Empleado','Vendedor','Director','Presidente','Analista'),
    dir INT,
    fecha_alt DATE,
    salario INT,
    comision INT,	
    dept_no INT,
    PRIMARY KEY(emp_no),
    FOREIGN KEY(dept_no) REFERENCES depart(dept_no) ON DELETE NO ACTION ON UPDATE CASCADE
    );	

INSERT INTO depart VALUES (10,'CONTABILIDAD','SEVILLA');
INSERT INTO depart VALUES (20,'INVESTIGACIÓN','MADRID');
INSERT INTO depart VALUES (30,'VENTAS','BARCELONA');
INSERT INTO depart VALUES (40,'PRODUCCIÓN','BILBAO');


INSERT INTO emple VALUES (7369,'SÁNCHEZ','EMPLEADO',7902,'1990/12/17',
                        1040,NULL,20);
INSERT INTO emple VALUES (7499,'ARROYO','VENDEDOR',7698,'1990/02/20',
                        1500,390,30);
INSERT INTO emple VALUES (7521,'SALA','VENDEDOR',7698,'1991/02/22',
                        1625,650,30);
INSERT INTO emple VALUES (7566,'JIMÉNEZ','DIRECTOR',7839,'1991/04/02',
                        2900,NULL,20);
INSERT INTO emple VALUES (7654,'MARTÍN','VENDEDOR',7698,'1991/09/29',
                        1600,1020,30);
INSERT INTO emple VALUES (7698,'NEGRO','DIRECTOR',7839,'1991/05/01',
                        3005,NULL,30);
INSERT INTO emple VALUES (7782,'CEREZO','DIRECTOR',7839,'1991/06/09',
                       2885,NULL,10);
INSERT INTO emple VALUES (7788,'GIL','ANALISTA',7566,'1991/11/09',
                        3000,NULL,20);
INSERT INTO emple VALUES (7839,'REY','PRESIDENTE',NULL,'1991/11/17',
                        4100,NULL,10);
INSERT INTO emple VALUES (7844,'TOVAR','VENDEDOR',7698,'1991/09/08',
                        1350,0,30);
INSERT INTO emple VALUES (7876,'ALONSO','EMPLEADO',7788,'1991/09/23',
                        1430,NULL,20);
INSERT INTO emple VALUES (7900,'JIMENO','EMPLEADO',7698,'1991/12/03',
                        1335,NULL,30);
INSERT INTO emple VALUES (7902,'FERNÁNDEZ','ANALISTA',7566,'1991/12/03',
                        3000,NULL,20);
INSERT INTO emple VALUES (7934,'MUÑOZ','EMPLEADO',7782,'1992/01/23',
                        1690,NULL,10);


ALTER TABLE emple ADD CONSTRAINT FK_emple FOREIGN KEY(dir) REFERENCES emple(emp_no) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE depart ADD tlf INT;
commit;
