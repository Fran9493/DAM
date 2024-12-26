use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 3
Crea una función que, al pasar una cadena por parámetro, devuelve la misma en minúscula y al final tiene concatenado el tamaño de la longitud de la cadena. Por ejemplo, si se pasa hola, debería devolver hola4
*/
DELIMITER $$
drop function if exists f_minuscula_mide;$$
create function f_minuscula_mide(cadena varchar (20)) returns varchar (20)
begin
	declare num_mide int;
    declare vc_salida varchar (20);
    set num_mide = length(cadena);
    set vc_salida = concat(lower(cadena), num_mide);
    return vc_salida;    
end; $$
