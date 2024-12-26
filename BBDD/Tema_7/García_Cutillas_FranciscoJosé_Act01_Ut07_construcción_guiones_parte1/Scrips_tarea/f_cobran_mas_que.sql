use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 13
Crea una función que dado un código de equipo y un salario (ambos son parámetros) nos indique el número de jugadores que para ese equipo cobran más de ese salario.
*/
DELIMITER $$
drop function if exists f_cobran_mas_que; $$
create function f_cobran_mas_que (codigo int, in_salario decimal) returns int	
begin
	declare n_salida int;
	select count(*) into n_salida
			from jugador
		   where num_equipo = codigo
			  and salario > in_salario;
	return n_salida;
end; $$
