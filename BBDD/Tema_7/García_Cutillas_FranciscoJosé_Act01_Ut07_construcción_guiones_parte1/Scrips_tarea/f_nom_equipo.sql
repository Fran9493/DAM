use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 12
Crea una función que dado un código de equipo devuelva su nombre. Pon de nombre f_nom_equipo.
*/
DELIMITER $$
drop function if exists f_nom_equipo; $$
create function f_nom_equipo (codigo int) returns varchar (20)
begin
	declare vc_salida varchar (20);
	select nombre into vc_salida
		from equipo
	   where id_equipo = codigo;
	return vc_salida;
end; $$
