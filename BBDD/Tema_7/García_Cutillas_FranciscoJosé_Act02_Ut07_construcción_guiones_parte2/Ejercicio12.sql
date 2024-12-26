use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_salarios_cadena; $$
create function f_salarios_cadena () returns varchar (500)
begin
	declare salida varchar (500);
    declare cod_eq int;
    declare nom_eq varchar (30);
    declare total_salario decimal;
    declare final boolean;
    declare cur_equipos cursor for
		select id_equipo, nombre
			from equipo;
	declare continue handler for not found set final = 1;
    
    set final = 0;
    open cur_equipos;    
	loop_equipos: loop
		fetch cur_equipos into cod_eq, nom_eq;
        if (final = 1) then
			set final = 0;
			close cur_equipos;
			leave loop_equipos;	
		else			
			call p_total_salarios (cod_eq, total_salario);
            if (salida is null) then
				set salida = concat(nom_eq, '(', total_salario, ')');
			else
				set salida = concat(salida,'-',nom_eq, '(', total_salario, ')');
            end if;				
		end if;
    end loop;
    return salida;
end; $$