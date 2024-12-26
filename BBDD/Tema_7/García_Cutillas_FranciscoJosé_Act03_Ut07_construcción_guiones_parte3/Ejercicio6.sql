use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

/*
6. Haz un trigger que impida que un departamento se quede sin empleados.
*/
DELIMITER $$
drop trigger if exists tr_bd_borraEmpleado; $$
create trigger tr_bd_borraEmpleado before delete
					on emple for each row
begin		    
	declare numEmpleados int;
    
    select count(*) into numEmpleados
		from emple 
	   where dept_no = old.dept_no;
	
    call P_borraEmpleado (numEmpleados);
    
end; $$

DELIMITER $$
drop trigger if exists tr_bu_borraEmpleado; $$
create trigger tr_bu_borraEmpleado before update
					on emple for each row
begin		    
	declare numEmpleados int;
    
    select count(*) into numEmpleados
		from emple 
	   where dept_no = old.dept_no;
	
    if(new.dept_no != old.dept_no) then
		call P_borraEmpleado (numEmpleados);
    end if;
    
end; $$

DELIMITER $$
drop procedure if exists p_borraEmpleado; $$
create procedure p_borraEmpleado(in numEmpleados int)
begin
	if (numEmpleados <= 1) then
		signal sqlstate '45006'
					set message_text = 'No se pueden eliminar todos los empleados de un departamento',
					mysql_errno = 45006;
	end if;
end; $$