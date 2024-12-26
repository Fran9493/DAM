use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_actualiza_jugador; $$
create function f_actualiza_jugador (cod_eq int, cod_jug int) returns varchar (100)
begin
	declare cont_eq int;
    declare cont_cap int;    
    declare cap int;    
	            
    select count(*) into cont_eq
		from jugador 
			where id_jugador = cod_jug
				and num_equipo = cod_eq;
	
    select count(*) into cont_cap
		from jugador 
			where id_jugador = cod_jug
				and id_capitan = cod_jug;
            
	if	(cod_eq not in (select id_equipo from equipo)) then
		return concat('El equipo ', cod_eq, ' no existe');
    elseif (cod_jug not in (select id_jugador from jugador)) then
		return concat('El jugador ', cod_jug, ' no existe');
	elseif (cont_eq = 0) then
		return concat('El jugador ', cod_jug, ' no juega en el equipo ', cod_eq);
	elseif (cont_cap = 1) then
		return concat('El jugador ', cod_jug, ' ya es capitán del equipo ', cod_eq);
	else
		update jugador
			set id_capitan = cod_jug
				where num_equipo = cod_eq;
    end if;
	return 'OK';
end; $$