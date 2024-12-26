use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop procedure if exists p_mejor_puntuacion; $$
create procedure p_mejor_puntuacion (in cod_eq1 int, in cod_eq2 int, out codigo int, out nombre_eq varchar(200))
begin    
	if (cod_eq1 not in (select id_equipo from equipo)) then
		set nombre_eq = concat('ERROR. El equipo ', cod_eq1, ' no se encuentra en la base de datos');
        set codigo = -1;
	elseif (cod_eq2 not in (select id_equipo from equipo)) then
		set nombre_eq = concat('ERROR. El equipo ', cod_eq2, ' no se encuentra en la base de datos');
        set codigo = -1;
	else
		select id_equipo, nombre into codigo, nombre_eq
				from equipo
			  where id_equipo in (cod_eq1, cod_eq2)
			   order by puntos desc, nombre
			   limit 1;
    end if;
end; $$
