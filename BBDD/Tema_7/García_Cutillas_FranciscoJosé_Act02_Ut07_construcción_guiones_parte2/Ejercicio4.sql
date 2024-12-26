use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$
drop function if exists f_mejor_codigo; $$
create function f_mejor_codigo (cod_eq1 int, cod_eq2 int) returns varchar (200)
begin
	declare salida_cod varchar(10);
    declare salida_nombre varchar (200);
       
    call p_mejor_puntuacion (cod_eq1, cod_eq2, salida_cod, salida_nombre);
    
    if (salida_cod = -1) then
		return salida_nombre;
	else
		return salida_cod;
	end if;
end; $$