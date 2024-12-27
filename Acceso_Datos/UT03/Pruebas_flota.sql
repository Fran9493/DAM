set autocommit = 1;
show variables like 'autocommit';

create database FLOTA;

use flota;

create table vehiculo(
	matricula varchar(10) primary key,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    fecha_matricula date null,
    color varchar(50) not null,
    tipo varchar (20) null,
    precio numeric(10,2)
);

insert into vehiculo (matricula, marca, modelo, fecha_matricula, color, tipo, precio) values
	('1122BBB', 'Audi', 'A3', '2001-06-25', 'Azul', 'Sedán', 18000.33),
    ('2222CCC', 'Audi', 'A5', '2010-08-02', 'Negro', 'Sedán', 23400.66),
    ('3333DDD', 'Opel', 'Antara', '2011-12-21', 'Blanco', null, 20020.50),
    ('4444FFF', 'Peugeot', '3008', null, 'Amarillo', 'Sedán', 19500.83),
    ('5555GGG', 'Seat', 'Arona', '2019-02-20', 'Rojo', 'Sedán', 21000.40),
    ('6666HHH', 'Toyota', 'Corola', '2014-01-25', 'Gris', null, 17490.12);

drop table vehiculo;

select *
	from vehiculo;
    
select * 
	from vehiculo
   order by marca desc;
    

select *
	from vehiculo
   where fecha_matricula > '2015-01-01';

create table conductor(
	dni varchar(10) primary key,
    nombre varchar(50) not null,
    apellidos varchar(100) not null,
    fecha_nacimiento date not null,
    fecha_carnet date not null,
    estatura numeric(3)
);

commit;

drop table conductor;

create table tipo_vehiculo(
	codigo_vehiculo varchar(10) primary key,
    descripcion varchar(100) not null
);

drop table tipo_vehiculo;

alter table vehiculo drop foreign key fk_vehiculo_tipo_vehiculo;

alter table vehiculo drop tipo_vehiculo;

alter table tipo_vehiculo drop index descripcion;

alter table vehiculo add column tipo_vehiculo varchar(100) not null,
	add constraint fk_vehiculo_tipo_vehiculo foreign key (tipo_vehiculo)
    references tipo_vehiculo(descripcion) on delete restrict on update cascade;

alter table vehiculo add column tipo_vehiculo varchar(100) not null;

ALTER TABLE tipo_vehiculo
ADD INDEX descripcion (descripcion);

alter table vehiculo add constraint fk_vehiculo_tipo_vehiculo foreign key (tipo_vehiculo)
    references tipo_vehiculo (descripcion) on delete restrict on update cascade;