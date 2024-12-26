use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_total_salarios; $$
create function f_total_salarios (cod_eq int) returns decimal
begin
	declare total decimal;
        
	select ifnull(sum(salario), '0') into total
		from jugador
	  where num_equipo = cod_eq;
		
		return total;     	
end; $$