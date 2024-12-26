use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 6
Crea una función que se llame f_media_equipo que devuelva la media del salario del código de equipo que se pasa como parámetro.
*/
DELIMITER $$
drop function if exists f_media_equipo; $$
create function f_media_equipo(cod_equipo int) returns decimal(10,2)
begin
	declare dec_salida decimal(10,2);
	select avg(j.salario) into dec_salida
			from jugador j inner join equipo e
				on j.num_equipo = e.id_equipo
			   where e.id_equipo = cod_equipo
			  group by e.id_equipo;
	return dec_salida;
end; $$
