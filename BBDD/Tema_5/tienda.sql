drop database if exists tienda;

create database tienda;

use tienda;

create table FABRICANTES(
Codigo INT NOT NULL,
Nombre VARCHAR(100),
PRIMARY KEY(Codigo)
);

create table ARTICULOS(
Codigo INT NOT NULL,
Nombre VARCHAR(100),
Precio INT,
Fabricante INT,
PRIMARY KEY(Codigo),
FOREIGN KEY(Fabricante) REFERENCES FABRICANTES(Codigo) On delete restrict On Update cascade
);

insert into FABRICANTES values(1,'Kingston');
insert into FABRICANTES values(2,'Adata');
insert into FABRICANTES values(3,'Logitech');
insert into FABRICANTES values(4,'Lexar');
insert into FABRICANTES values(5,'Seagate');

insert into ARTICULOS values(1,'Teclado',100,3);
insert into ARTICULOS values(2,'Disco Duro 300Gb',500,5);
insert into ARTICULOS values(3,'Mouse',80,3);
insert into ARTICULOS values(4,'Memoria USB',140,4);
insert into ARTICULOS values(5,'Memoria RAM',290,1);
insert into ARTICULOS values(6,'Disco Duro extraible 250Gb',650,5);
insert into ARTICULOS values(7,'Memoria USB',279,1);
insert into ARTICULOS values(8,'DVD Rom',450,2);
insert into ARTICULOS values(9,'CD Rom',200,2);
insert into ARTICULOS values(10,'Tarjeta de red',180,3);
  
  