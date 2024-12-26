use tienda;

-- Ejercicio 1
show variables like 'autocommit';

set autocommit = 0;
show variables like 'autocommit';


-- Ejercicio 2
create table provincia (
	codigo int primary key,
    nombre varchar (60));
    
    
-- Ejercicio 3
alter table fabricantes 
	add codigo_provincia int;
    
alter table fabricantes 
	add constraint fk_fabricantes_provincia foreign key (codigo_provincia) references provincia (codigo)
		on delete restrict on update cascade;


-- Ejercicio 4
insert into articulos (codigo, nombre, precio, fabricante) values (11, 'Altavoces', 70, 2);


-- Ejercicio 5
insert into articulos (codigo, nombre, precio, fabricante) values (12, 'Auricular Bluetooth', 27, 2);

-- Este sería el correcto. Mal porque lo he hecho igual que el 4. La idea era hacerlo diferente
insert into articulos set
	codigo = 12,
	nombre = 'Auricular bluetooth',
    precio = 27,
    fabricante = 2;


-- Ejercicio 6
create table articulos_adata like articulos;


-- Ejercicio 7
insert into articulos_adata
	select a.codigo, a.nombre, a.precio, a.fabricante
		from fabricantes f inner join articulos a
			on f.codigo = a.fabricante
		  where f.nombre = 'Adata';


-- Ejercicio 8
commit;


-- Ejercicio 9
insert into provincia (codigo, nombre) values (09, 'Burgos'), (34, 'Palencia'), (45, 'Toledo'), (30, 'Murcia');


-- Ejercicio 10
update fabricantes
	set codigo_provincia = (select codigo
								from provincia
									where nombre = 'Murcia')
		where codigo < 3;

update fabricantes
	set codigo_provincia = 08
		where codigo >= 3;
-- En lugar de 3 se podría poner isnull, puesto que esos códigos estarían aun sin rellenar
    

-- Ejercicio 11
commit;


-- Ejercicio 12
update fabricantes
	set codigo_provincia = (select max(codigo)
								from provincia)
		where codigo_provincia is null;


-- Ejercicio 13
alter table fabricantes 
	modify column codigo_provincia int not null;

show fields from fabricantes;


-- Ejercicio 14
commit;


-- Ejercicio 15
insert into articulos (codigo, nombre, precio, fabricante) values (13, 'Microfono', 12, 13);

/*
Error Code: 1452. Cannot add or update a child row: a foreign key constraint 
fails (`tienda`.`articulos`, CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (`Fabricante`) 
REFERENCES `fabricantes` (`Codigo`) ON DELETE RESTRICT ON UPDATE CASCADE)
*/


-- Ejercicio 16
update articulos 
	set nombre = 'Impresora laser'
		where codigo = 8;

-- Ejercicio 17
update articulos
	set precio = precio * 1.1
		where codigo > 0;


-- Ejercicio 18
rollback;


-- Ejercicio 19
update articulos
	set precio = precio - 8
		where fabricante = (select codigo
								from fabricantes
									where nombre = 'Adata');


-- Ejercicio 20
insert into fabricantes (codigo, nombre) values (6, 'Genius');

/*
Error Code: 1364. Field 'codigo_provincia' doesn't have a default value
*/


-- Ejercicio 21
update articulos
	set precio = (select precio_max 
					from (select max(precio) precio_max
							from articulos) a)
		where codigo = 4;


-- Ejercicio 22
update articulos
	set nombre = 'Portatil 300 GB', precio = 450
		where codigo = 2;


-- Ejercicio 23
delete from articulos
	where precio < 150
		and codigo > 0;


-- Ejercicio 24
set sql_safe_updates = 0;

delete from fabricantes
	where codigo in (select f.cod codigo
						from (select f.codigo cod
								from articulos a right join fabricantes f
									on a.fabricante = f.codigo
								  where a.fabricante is null) f);

set sql_safe_updates = 1;


-- Ejercicio 25
delete from articulos
	where codigo in (select a.codigo
						from (select a.codigo codigo
								from articulos a inner join fabricantes f
									on a.fabricante = f.codigo
								  where f.nombre like 'L%')a );


-- Ejercicio 26
set sql_safe_updates = 0;

delete from articulos_adata;

set sql_safe_updates = 1;


-- Ejercicio 27
set sql_safe_updates = 0;

delete from fabricantes;

/*
Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint 
fails (`tienda`.`articulos`, CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (`Fabricante`) 
REFERENCES `fabricantes` (`Codigo`) ON DELETE RESTRICT ON UPDATE CASCADE)
*/

delete from articulos;

delete from fabricantes;


-- Ejercicio 28
delete from provincia;


-- Ejercicio 29
rollback;


-- Ejercicio 30
drop table articulos;


-- Ejercicio 31
show tables;

rollback;

show tables;

drop table fabricantes;

set sql_safe_updates = 1;
