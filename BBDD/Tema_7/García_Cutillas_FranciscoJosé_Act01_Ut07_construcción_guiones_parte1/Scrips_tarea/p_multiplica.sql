use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 4
Crea un procedimiento que tenga tres parámetros, dos de entrada y uno de salida. El tercer parámetro tendrá el resultado de multiplicar los dos primeros. 
Este procedimiento se llamará p_multiplica
*/
DELIMITER $$
drop procedure if exists p_multiplica; $$
create procedure p_multiplica (in num1 numeric, in num2 numeric, out resultado numeric)
begin
	set resultado = num1 * num2;
end; $$