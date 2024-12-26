use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 14
Crea una función f_fecha_equipo que recibiendo el NOMBRE de un equipo nos indique el número de partidos que ha jugado con fecha anterior a la fecha 
que también va a recibir como parámetro.
*/
DELIMITER $$
drop function if exists f_fecha_equipo; $$
create function f_fecha_equipo (nombre varchar(20), fecha date) returns int
begin
	declare n_num_partidos int;
	select count(*) into n_num_partidos
			from equipo e inner join partido p 
				on e.id_equipo = p.elocal
					or e.id_equipo = p.evisitante
			 where e.nombre = nombre
				and p.fecha < fecha;
	return n_num_partidos;
end; $$
