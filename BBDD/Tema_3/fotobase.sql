create database fotobase;

use fotobase;

select database();

drop table fotos;

create table if not exists fotos(
	id_foto			integer 			auto_increment primary key,
    camara			varchar(8)			not null,
    autor 			varchar(100)		not null,
    tamaño			int(7)				not null,
    descripcion		varchar(500)		null,
    constraint		ck_fotos_camara		check (camara in ('REFLEX','MOVIL','COMPACTA')),
    constraint		ck_fotos_tamaño		check (tamaño > 0)
);

create table if not exists fotos2 like fotos;

show create table fotos;



