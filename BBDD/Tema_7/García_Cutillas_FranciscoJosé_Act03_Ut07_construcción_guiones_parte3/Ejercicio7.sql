use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

/*
7. Crea un trigger que impida que la comisión de un empleado sea más del 15% del salario..
*/
DELIMITER $$
drop trigger if exists tr_bu_comisionMax; $$
create trigger tr_bu_comisionMax before update
					on emple for each row
begin   
	call p_comisionMax(new.comision, new.salario);
end; $$

DELIMITER $$
drop trigger if exists tr_bi_comisionMax; $$
create trigger tr_bi_comisionMax before insert
					on emple for each row
begin   
    call p_comisionMax(new.comision, new.salario);
end; $$

DELIMITER $$
drop procedure if exists p_comisionMax; $$
create procedure p_comisionMax (in comision double, in salario double)
begin
	if (comision > salario * 1.15) then
		signal sqlstate '45007'
					set message_text = 'La comisión de un empleado no puede superar más del 15% de su salario',
					mysql_errno = 45007;
	end if;
end; $$