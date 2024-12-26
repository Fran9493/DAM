use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 5
Utilizando el procedimiento creado anteriormente de nombre p_multiplica crea una función que se llamará f_multiplica que tendrá dos parámetros de entrada 
y devolverá el resultado de la multiplicación.
*/
DELIMITER $$
drop function if exists f_multiplica; $$
create function f_multiplica (num1 numeric, num2 numeric) returns numeric
begin
	declare resultado numeric;
	call p_multiplica (num1, num2, resultado);
    return resultado;
end; $$
