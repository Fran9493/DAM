drop database if exists examen;

create database if not exists examen;

use examen;

create table if not exists cantante(

codigo			int(3)			primary key,
dni				varchar(20)		not null,
fecha_nac		date			null,
nombre			varchar(20)		not null,
apellidos		varchar(60)		not null,

constraint uq_cantante unique (dni)

);

create table if not exists grupo(

nombre			varchar(20)		primary key,
añofundacion	int(4)			not null,
tipomusica		varchar(10)		not null,
cod_cantante	int(3)			not null,
constraint ck_grupo_añofundacion check (añofundacion > 1960),
constraint ck_grupo_tipomusica check (tipomusica in('clasica','blues','rock','pop','metal','otras')),
constraint fk_grupo_cantante foreign key (cod_cantante)
	references cantante (codigo) on delete restrict on update cascade

);

create table if not exists mail_grupo(

nombre_grupo		varchar(20),
mail				varchar(30),
constraint pk_mail_grupo primary key (nombre_grupo, mail),
constraint fk_mail_grupo_grupo foreign key (nombre_grupo)
	references grupo (nombre) on delete cascade on update cascade

);
