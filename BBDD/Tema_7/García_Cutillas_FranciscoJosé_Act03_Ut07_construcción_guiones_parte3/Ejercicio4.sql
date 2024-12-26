use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

/*
4. Haz un trigger que controle que los salarios estén en los siguientes rangos: 
	EMPLEADO: 800 – 1100, ANALISTA 1200 – 1600 y DIRECTOR:1800 – 2000
*/

DELIMITER $$
drop trigger if exists tr_bu_controlSalario; $$
create trigger tr_bu_controlSalario before update
					on emple for each row
begin
	call p_controlSalario (new.oficio, new.salario);	
end; $$

DELIMITER $$
drop trigger if exists tr_bi_controlSalario; $$
create trigger tr_bi_controlSalario before insert
					on emple for each row
begin
	call p_controlSalario (new.oficio, new.salario);	
end; $$

DELIMITER $$
drop procedure if exists p_controlSalario; $$
create procedure p_controlSalario (in oficio varchar(20), in salario double)
begin
	if (oficio = 'Empleado') then
		if (salario < 800 or salario > 1100) then
			signal sqlstate '45003'
					set message_text = 'Salario no válido para un Empleado',
					mysql_errno = 45003;
		end if;
	elseif (oficio = 'Analista') then
		if (salario < 1200 or salario > 1600) then
			signal sqlstate '45004'
					set message_text = 'Salario no válido para un Analista',
					mysql_errno = 45004;
		end if;
	elseif (oficio = 'Director') then
		if (salario < 1800 or salario > 2000) then
			signal sqlstate '45005'
					set message_text = 'Salario no válido para un Director',
					mysql_errno = 45005;
		end if;
	end if;	
end; $$ 