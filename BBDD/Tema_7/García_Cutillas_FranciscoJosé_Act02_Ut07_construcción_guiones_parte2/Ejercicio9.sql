use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_abreviatura; $$
create function f_abreviatura () returns varchar (500)
begin
	declare salida varchar (500);
    declare temp varchar (20);
    declare final boolean;
    declare cursor_ab cursor for
		select substr(apellido, 1, 3)
			from jugador
		   order by salario desc;
	declare continue handler for not found set final = 1;
    
    set final = 0;
    
    open cursor_ab;
    apellidos_loop: loop
		fetch cursor_ab into temp;
		if (final = 1) then
			set final = 0;
			close cursor_ab;
            leave apellidos_loop;
        else
			if (salida is null) then
				set salida = temp;			
			else				
				set salida = concat(salida,', ', temp);
			end if;
		end if;
	end loop;
    return salida;
end; $$