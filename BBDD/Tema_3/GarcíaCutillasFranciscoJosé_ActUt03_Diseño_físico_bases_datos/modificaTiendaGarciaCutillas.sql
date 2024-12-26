use tiendabase;

-- Ejercicio2

-- ● Añadir a la tabla STOCK:

-- Una columna de tipo fecha llamada FechaUltimaEntrada que debe poder
-- permitir que no tenga valor y cuya valor debe ser superior al día que se crea la tabla.
alter table stock_fran add fecha_ultima_entrada timestamp default current_timestamp on update current_timestamp null;


-- Una columna llamada Beneficio que contendrá el tipo de porcentaje de
-- beneficio que esa tienda aplica en ese producto. Se debe controlar que el
-- valor que almacene sea 1,2, 3, 4 o 5.
alter table stock_fran add beneficio int(1) not null;
alter table stock_fran add constraint ck_stock_fran_beneficio check(beneficio >= 1 and beneficio <=5);


-- ● En la tabla PRODUCTO

-- Eliminar de la tabla producto la columna Descripción.
alter table producto_fran drop descrip_producto;

-- Añadir una columna llamada perecedero que únicamente acepta los valores: S o N.
alter table producto_fran add perecedero char(1) not null
	constraint ck_producto_fran_perecedero check(perecedero in ('S', 'N'));

-- Modificar el tamaño de la columna Denoproducto a 60.
alter table producto_fran modify deno_producto varchar(60) not null;

-- Añadir una columna que sea DenoproductoIngles y tenga una longitud de 60.
alter table producto_fran add deno_producto_ingles varchar(60) not null;


-- ● En la tabla FAMILIA

-- Añadir una columna llamada IVA, que representa el porcentaje de IVA y
-- únicamente pueda contener los valores 21,10,ó 4.
alter table familia_fran add IVA int(2) not null
	constraint ck_familia_fran_IVA check(IVA in ('21','10','4'));


-- ● En la tabla TIENDA

-- La empresa desea restringir el número de tiendas con las que trabaja, de
-- forma que no pueda haber más de una tienda en una misma zona (la
-- zona se identifica por el código postal). Definir mediante DDL las
-- restricciones necesarias para que se cumpla en el campo correspondiente.
alter table tienda_fran add constraint uq_tienda_fran_cod_postal unique (cod_postal);

-- Añadir una columna Añocreacion que tenga 4 dígitos. El valor mínimo
-- debe ser 2010 y el máximo 2035 (intervalo de valores).
alter table tienda_fran add año_creacion int(4) not null
	constraint ck_tienda_fran_año_creacion check(año_creacion >= 2010 and año_creacion <= 2035);
    

-- Renombra la tabla STOCK por tu primer Stock1apellido donde 1apellido es tu primer apellido.
alter table stock_fran rename to stock_garcia;

-- Elimina la tabla FAMILIA y su contenido si lo tuviera.

alter table producto_fran drop foreign key fk_producto_fran;
alter table stock_garcia drop foreign key fk_stock_fran_tienda;
drop table familia_fran;
	