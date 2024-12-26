use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_partidos_local; $$
create function f_partidos_local (codigo int) returns varchar (100)
begin
	declare res varchar (20);
    declare salida varchar (100);
    declare i int;
    declare cont int;
    declare existe int;
	declare partidos cursor for
		select resultado
			from partido
		   where elocal = codigo;
	    
    set i = 0;
    
    select count(*) into cont
		from partido
	   where elocal = codigo;
	
    select count(*) into existe
		from equipo
	   where id_equipo = codigo;
	
    if (existe = 0) then
		set salida = concat('El equipo ', codigo, ' no existe');
    elseif (cont = 0) then
		set salida = concat('El equipo ', codigo, ' no ha jugado ningún partido como local'); 
    else   
		open partidos;    
		partidos_loop: while (i < cont) do
			fetch partidos into res;
			if (salida is null) then
				set salida = res;
			else
				set salida = concat(salida,'; ', res);
			end if;
			set i = i + 1;
		end while partidos_loop;
		close partidos;
	end if;
	return salida;
end; $$