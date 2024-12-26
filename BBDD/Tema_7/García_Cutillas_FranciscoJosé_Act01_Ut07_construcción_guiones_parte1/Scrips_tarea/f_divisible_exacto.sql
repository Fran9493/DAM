use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 2
Crea una función que tendrá como parámetros de entradas dos enteros y tendrá que devolver si el primer número es divisible de manera exacta por el segundo, es decir, si se pasa un 7 y un 3 deberá devolver FALSE, pero si se pasa un 9 y un 3 deberá devolver TRUE.
*/
DELIMITER $$
drop function if exists f_divisible_exacto;$$
create function f_divisible_exacto (num1 int, num2 int) returns boolean
begin
	if (num1 % num2 = 0) then
		return true;
	else	
		return false;
	end if;
end;$$
