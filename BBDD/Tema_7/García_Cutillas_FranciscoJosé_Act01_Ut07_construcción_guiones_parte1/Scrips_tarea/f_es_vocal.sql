use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 1
Crea una función f_es_vocal que recibe una letra y retorna un TRUE si lo es y un FALSE en caso contrario
*/
DELIMITER $$
drop function if exists f_es_vocal;
create function f_es_vocal (letra char) returns boolean
begin
	if letra in ( 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U') then
		return true;
	else 
		return false;
	end if;
end;$$

