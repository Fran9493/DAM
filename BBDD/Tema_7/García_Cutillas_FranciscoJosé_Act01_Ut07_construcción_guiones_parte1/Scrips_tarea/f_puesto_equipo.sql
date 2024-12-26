use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 7
Crea una función que se llame f_puesto_equipo que devuelva la posición en la que se encuentra ese equipo en la liga (se pasará el código). 
Ya sabéis que para saber su posición se debe revisar la columna puntos de la tabla equipo.
*/
DELIMITER $$
drop function if exists f_puesto_equipo; $$
create function f_puesto_equipo(codigo int) returns int 
begin
	declare int_salida int;
	select e2.clasificacion into int_salida
			from equipo e1 inner join (select id_equipo, row_number() over (order by puntos desc) clasificacion
												from equipo) e2
				on e1.id_equipo = e2.id_equipo
			  where e1.id_equipo = codigo;
	return int_salida;
end; $$


