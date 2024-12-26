use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 10
Crea una función que se llame f_encima_media_eq que indique para un código de equipo el número de jugadores que cobran
más de la media del salario de dicho equipo. Se debe hacer uso de la función f_media_equipo que hemos creado anteriormente.
*/
DELIMITER $$
drop function if exists f_encima_media_eq; $$
create function f_encima_media_eq (codigo int) returns int
begin
	declare n_salida int;
	select count(id_jugador) into n_salida
			from jugador
		   where salario > f_media_equipo (codigo)
			  and num_equipo = codigo;
	return n_salida;
end; $$






