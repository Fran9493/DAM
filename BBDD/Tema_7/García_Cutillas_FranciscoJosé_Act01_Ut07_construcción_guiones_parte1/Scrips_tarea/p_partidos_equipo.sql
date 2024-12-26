use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 8
Crea un procedimiento que pasando el código de un equipo devuelva en dos parámetros de salida el número de partidos que ha jugado como local y los que ha jugado como visitante. El procedimiento p_partidos_equipo
*/
DELIMITER $$
drop procedure if exists p_partidos_equipo; $$
create procedure p_partidos_equipo (in codigo int, out num_partidos_loc int, out num_partidos_vis int)
begin
	declare n_local int;
	declare n_visitante int;
    
	select count(e.id_equipo) into n_local
			from equipo e inner join partido p
				on e.id_equipo = p.elocal
			  where e.id_equipo = codigo
			 group by e.id_equipo;
              
	select count(e.id_equipo) into n_visitante
			from equipo e inner join partido p
				on e.id_equipo = p.evisitante
			  where e.id_equipo = codigo
			 group by e.id_equipo;	
             
	set num_partidos_loc = ifnull(n_local, '0');
    set num_partidos_vis = ifnull(n_visitante, '0');
end; $$
 
