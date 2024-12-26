use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 9
Crea una función que se llame f_num_partidos_equipos que devuelva el número total de partidos que ha jugado ese equipo 
(se pasará el NOMBRE del equipo). Se debe tener en cuenta tanto los partidos que ha jugado como local como visitante por 
lo que se aconseja hacer uso del procedimiento p_partidos_equipo
*/
DELIMITER $$
drop function if exists f_num_partidos_equipos; $$
create function f_num_partidos_equipos (nom_equipo varchar(20)) returns numeric
begin
	declare p_local int;
    declare p_visitante int;
    
    call p_partidos_equipo ((select id_equipo
									from equipo
								   where nombre = nom_equipo),
							 p_local, p_visitante);
	return ifnull(p_local, '0') + ifnull(p_visitante, '0');
end; $$

