drop database if exists embarcadero;

create database if not exists embarcadero;

use embarcadero;

create table if not exists socio(

DNI			varchar(12)			primary key,
nombre		varchar(20)			not null,
dir_n		int(3)				not null,
dir_calle	varchar(20)			not null,
dir_cp		int(6)				not null

);

create table if not exists telefonos_socio(

DNI_socio		varchar(12)		not null,
telefono		varchar(13)		not null,
constraint pk_telefonos_socio primary key (DNI_socio, telefono),
constraint fk_telefonos_socio_socio foreign key (DNI_socio)
	references socio (DNI) on delete cascade on update cascade
    
);

create table if not exists socio_vip(

DNI			varchar(12)		primary key,
constraint fk_socio_vip_socio foreign key (DNI)
	references socio (DNI) on delete restrict on update cascade
    
);

create table if not exists socio_novip(

DNI		varchar(12)		primary key,
constraint fk_socio_novip_socio foreign key (DNI)
	references socio (DNI) on delete restrict on update cascade
    
);

create table if not exists empleado(

codigo		int(3)				primary key,
nombre		varchar(20)			not null,
telefono	varchar(13)			not null,
esp			varchar(20)			not null,
dir_n		int(3)				not null,
dir_calle	varchar(20)			not null,
dir_cp		int(6)				not null,
letra_zona	char(2)				not null,
barcos_enc	int(3)				not null
-- constraint fk_empleado_zona foreign key (letra_zona)
	-- references zona (letra) on delete restrict on update cascade
    
);


create table if not exists zona(

letra		char(2)			primary key,
tipo_barcos	varchar(20)		not null,
num_barcos	int(3)			not null,
medidas		varchar(10)		not null,
cod_jefe	int(3)			not null,
constraint fk_zona_empleado foreign key (cod_jefe)
	references empleado (codigo) on delete restrict on update cascade
);

create table if not exists amarre(
numero			int(3)			primary key,
lec_agua		int(6)			not null,
lec_luz 		int(6)			not null,
serv_mant		char(1)			default('S'),
letra_zona		char(2)			not null,
DNI_sociovip	varchar(12)		not null,
fecha_compra	date			not null,
constraint ck_amarre check (serv_mant in ('S', 'N')),
constraint fk_amarre_sociovip foreign key (DNI_sociovip)
	references socio_vip (DNI) on delete restrict on update cascade,
constraint fk_amarre_zona foreign key (letra_zona)
	references zona (letra) on delete restrict on update cascade

);

create table if not exists embarcacion(

matricula 		varchar(10)			primary key,
nombre 			varchar(20)			not null,
dimensiones		varchar(10)			not null,
tipo			varchar(10)			not null,
DNI_socio		varchar(12)			not null,
num_amarre		int(3)				not null,
constraint fk_embarcacion_socio foreign key (DNI_socio)
	references socio (DNI) on delete restrict on update cascade,
constraint fk_embarcacion_amarre foreign key (num_amarre)
	references amarre (numero) on delete restrict on update cascade

);
