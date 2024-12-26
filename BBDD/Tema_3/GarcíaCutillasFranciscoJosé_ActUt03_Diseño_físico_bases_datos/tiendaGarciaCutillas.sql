drop database if exists tiendaBase;

create database tiendaBase;

use tiendaBase;

-- Ejercicio 1
-- Vamos a crear las tablas para una tienda que distribuye productos agrupados en
-- familias en varias tiendas.

-- Creación de la tabla "Familia". Contiene las familias a las que pertenecen los productos, como por
-- ejemplo ordenadores, impresoras, etc. Debes llamarla FamiliaNombre donde Nombre
-- es tu nombre. 
create table if not exists familia_fran(

cod_familia		int(3)		primary key,
deno_familia	int(3)		not null,
constraint uq_deno_familia unique(deno_familia)

);

-- Creación de la tabla "producto". Contendrá información general sobre los productos que distribuye la empresa a las tiendas.
create table if not exists	producto_fran(

cod_producto		int(5)			primary key,
deno_producto		varchar(30)		not null,
descrip_producto	varchar(100)	not null,
precio_base			decimal(8,2)	not null,
porc_reposicion		int(3),
unidades_minimas	int(4)			not null,
cod_familia			int(3)			not null,
constraint ck_precio_base check(precio_base > 0),
constraint ck_porc_reposicion check(porc_reposicion > 0),
constraint ck_unidades_minimas check(unidades_minimas > 0),
constraint fk_producto_fran foreign key(cod_familia)
	references familia_fran (cod_familia)
    
);

-- Creación de la tabla "tienda". Contendrá información básica sobre las tiendas que distribuyen los productos.
create table if not exists tienda_fran(

cod_tienda			int(3)			primary key,
deno_tienda			varchar(30)		not null,
telefono			varchar(11),
cod_postal			varchar(5)		not null,
provincia			varchar(5)		not null

);

-- Creación de la tabla "stock". Contendrá para cada tienda el número de unidades disponibles de
-- cada producto. La clave primaria está formada por la concatenación de los campos Codtienda y Codproducto.
create table if not exists stock_fran(

cod_tienda			int(3)			not null,
cod_producto		int(5)			not null,
unidades			int(6)			not null,
constraint fk_stock_fran_tienda foreign key(cod_tienda)
	references familia_fran (cod_familia),
constraint fk_stock_fran_producto foreign key(cod_producto)
	references producto_fran (cod_producto),
constraint pk_stock_fran primary key(cod_tienda, cod_producto),
constraint ck_unidades check(unidades >= 0)

);



