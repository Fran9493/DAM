use empleados;
SET GLOBAL log_bin_trust_function_creatorsemple = 1;
/*
1. Crear un trigger sobre la tabla EMPLE para que no se permita que 
	un empleado sea jefe de más de 4 empleados.
*/
DELIMITER $$
drop trigger if exists tr_bu_jefeCondicion; $$
create trigger tr_bu_jefeCondicion before update
					on emple for each row
begin
	declare empleadosCargo int;
       
    if new.dir != old.dir then
		select count(*) into empleadosCargo
				from emple
			  where dir = new.dir;
	
		call p_jefeCondicion (empleadosCargo, 4);
    
	end if;
end; $$

DELIMITER $$ 
drop trigger if exists tr_bi_jefeCondicion; $$
create trigger tr_bi_jefeCondicion before insert
					on emple for each row
begin
	declare empleadosCargo int;
        
    select count(*) into empleadosCargo
			from emple
		  where new.dir = dir;
    
    call p_jefeCondicion (empleadosCargo, 4);
    
end; $$

DELIMITER $$
drop procedure if exists p_jefeCondicion; $$
create procedure p_jefeCondicion(in empleadosCargo int, in maxEmpleados int)
begin
	if empleadosCargo > maxEmpleados then
		signal sqlstate '45000'
			set message_text = 'Un director no puede tener más de 4 empleados',
            mysql_errno = 45000;
    end if;
end; $$

