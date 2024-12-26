use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop procedure if exists p_total_salarios; $$
create procedure p_total_salarios (in cod_eq int, out total decimal) 
begin

	select ifnull(sum(salario), '0') into total
		from jugador
	  where num_equipo = cod_eq;
		     	
end; $$

