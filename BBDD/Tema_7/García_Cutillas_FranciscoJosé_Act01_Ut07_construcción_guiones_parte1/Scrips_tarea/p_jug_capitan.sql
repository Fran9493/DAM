use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 11
Crea un procedimiento llamado p_jug_capitan que muestre por pantalla todos los jugadores que tienen como capitán al jugador que se pasa como parámetro (se pasa el código).
*/
DELIMITER $$
drop procedure if exists p_jug_capitan; $$
create procedure p_jug_capitan (id_jugador int)
begin
	select nombre, apellido
			from jugador
		   where id_capitan = id_jugador;
end; $$

