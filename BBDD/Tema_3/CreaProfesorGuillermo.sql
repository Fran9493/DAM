drop database if exists profesor;

create database profesor;

use profesor;

Create table profesor (
	nrp			integer(9)		auto_increment primary key,
    dni			varchar(20)		not null,
    nombre		varchar(150)	not null,
    fechaNacto	date			null,
    constraint uq_dni	unique(dni));

Create table telefonos_profesor (
	nrp_profesor	integer(9),
    telefono		varchar(15),
    constraint pk_telefonos_profesor primary key (nrp_profesor, telefono),
	constraint fk_telefonos_profesor foreign key (nrp_profesor)
		References profesor (nrp) on delete cascade on update cascade);
        
Create table material (
	codigo		varchar(7)		primary key,
    nombre		varchar(200)	not null);
    
Create table clase (
	codigo		varchar(3)		primary key,
    descripcion	varchar(500)	not null,
    nrp_tutor	int(9)			not null,
    planta		int(1)			not null,
    esFP		char(1)			not null,
    constraint fk_clase_profesor	foreign key(nrp_tutor)
		References profesor(nrp) on delete restrict on update cascade,
   -- constraint ck_clase_planta 	check (planta in (1,2,3)),
    constraint ck_clase_planta check (planta >= 1 and planta <= 3),
    constraint ck_clase_esfp   	check (esFP in ('S','N')));
    
Create table compra (
	nrp_profesor	int(9),
    cod_material	varchar(7),
    fecha_compra 	date,
    constraint pk_compra	primary key (nrp_profesor, cod_material, fecha_compra),
    constraint fk_compra_profesor foreign key (nrp_profesor) 
		references profesor (nrp) on delete restrict on update cascade,
	constraint fk_compra_material foreign key (cod_material)
		references material (codigo) on delete restrict on update cascade);
        
describe material;

-- Añadir un nuevo campo precio
Alter table material add precio decimal(6,2) null;

-- Añado un nuevo campo profesor que es el responsable de ese material
Alter table material add nrp_profesor integer(9) not null;
Alter table material add constraint fk_material_profesor foreign key (nrp_profesor)
	references profesor (nrp) on delete restrict on update cascade;

-- Ahora quiero que la descripción sea de 400 en material
Alter table material modify nombre varchar(400) not null;        

-- Pongo valor por defecto a esFP de clase
Alter table clase alter esFP set default 'S';

-- Cambio nombre de la columna esFP y la voy es_fp
alter table clase drop constraint ck_clase_esfp;
Alter table clase change esFP es_fp char(1);
Alter table clase add constraint ck_clase_esfp check (es_fp in ('S', 'N'));

-- Quiero cargar columna precio de material
Alter table material drop column precio;

-- La tabla material la renombro por materialGuillermo
Alter table material rename to materialGuillermo;
		