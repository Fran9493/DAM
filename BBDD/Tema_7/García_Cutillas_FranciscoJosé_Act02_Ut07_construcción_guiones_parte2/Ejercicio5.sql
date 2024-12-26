use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_inserta_partido; $$
create function f_inserta_partido (cod_local int, cod_visitante int, res_loc int, res_vis int, cod_arbitro int) returns varchar (200)
begin
	declare cont int;
	
    select count(*) into cont
		from partido
	   where elocal = cod_local
		and evisitante = cod_visitante;
    
    if(cont > 0) then
		return 'ERROR. Estos equipos ya han jugado';
	elseif (cod_local not in (select id_equipo from equipo)) then
		return 'ERROR. El equipo local no existe';
	elseif (cod_visitante not in (select id_equipo from equipo)) then
		return 'ERROR. El equipo visitante no existe';
	elseif (cod_local = cod_visitante) then
		return 'ERROR. Un equipo no se puede enfrentar a sí mismo';
	elseif (res_loc < 0) then
		return 'ERROR. El resultado del local no puede ser negativo';
	elseif (res_vis < 0) then
		return 'ERROR. El resultado del visitante no puede ser negativo';
	elseif (cod_arbitro not in (select arbitro from partido)) then
		return 'ERROR. El árbitro no existe';
    else
		insert into partido values (cod_local, cod_visitante, concat(res_loc, '-', res_vis), curdate(), cod_arbitro);
        if(res_loc > res_vis) then
			update equipo
				set puntos = puntos + 2
			  where id_equipo = cod_local;
		elseif (res_vis > res_loc) then
			update equipo
				set puntos = puntos + 2
			  where id_equipo = cod_visitante;
        else
			update equipo
				set puntos = puntos + 1
			  where id_equipo in (cod_local, cod_visitante);
        end if;
		return 'OK';
    end if;
end; $$ 