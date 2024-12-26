use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

/*
2. Crear un trigger para impedir que se aumente el salario 
	de un empleado en más de un 20%.
*/
DELIMITER $$
drop trigger if exists tr_bu_aumentaSalario; $$
create trigger tr_bu_aumentaSalario before update
					on emple for each row
begin
	declare salMax double;
    
    select (salario * 1.2) into salMax
		from emple
	   where new.emp_no = emp_no;
	    
	if new.salario != old.salario then
		if new.salario > salMax then
			signal sqlstate '45001'
				set message_text = 'No se puede aumentar el salario de un empleado más del 20%',
				mysql_errno = 45001;
		end if;
    end if;
end; $$