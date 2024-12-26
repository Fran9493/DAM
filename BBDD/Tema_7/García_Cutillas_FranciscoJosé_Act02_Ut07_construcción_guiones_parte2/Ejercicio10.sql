use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop procedure if exists p_recorta_salario; $$
create procedure p_recorta_salario (in letra char)
begin
	declare cod_jugador int;
	declare in_nombre char;
    declare sal decimal;
	declare sal_recorte decimal;
    declare final boolean;
    declare recortes cursor for
		select id_jugador, substr(nombre, 1, 1), salario
			from jugador;
	declare continue handler for not found set final = 1;
    
    set final = 0;
    
    open recortes;
    loop_jugadores: loop
		fetch recortes into cod_jugador, in_nombre, sal;
        if (final != 1) then
			if (in_nombre = letra) then
				set sal_recorte = sal - (sal * 0.2);
					update jugador
						set salario = sal_recorte
					  where id_jugador = cod_jugador;				  
            end if;
        else
			set final = 0;
            leave loop_jugadores;
            close recortes;            
        end if;
    end loop;    
end; $$

