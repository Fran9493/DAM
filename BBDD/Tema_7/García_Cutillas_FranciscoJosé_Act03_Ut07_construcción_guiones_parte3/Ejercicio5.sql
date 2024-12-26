use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

/*
5. Haz un trigger que le suba un 10% el sueldo a los empleados si tienen 
	que cambiar el departamento en el que trabajan.
*/
DELIMITER $$
drop trigger if exists tr_bu_subeSueldo; $$
create trigger tr_bu_subeSueldo before update
					on emple for each row
begin		    
	if (new.dept_no != old.dept_no) then
		set new.salario = new.salario * 1.1;
    end if;
end; $$

