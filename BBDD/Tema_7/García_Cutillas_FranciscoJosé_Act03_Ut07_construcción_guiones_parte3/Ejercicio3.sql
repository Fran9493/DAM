use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

/*
3. Crear un trigger para impedir que un empleado y su jefe 
	pertenezcan a departamentos distintos.
*/
DELIMITER $$
drop trigger if exists tr_bu_empJefeDept; $$
create trigger tr_bu_empJefeDept before update
					on emple for each row
begin
	declare jefe int;
    declare dept_jefe int;
    
    select dir into jefe
		from emple
	   where emp_no = new.emp_no;
	
    select dept_no into dept_jefe
		from emple
	   where emp_no = jefe;
       
	if new.dept_no != dept_jefe then
		signal sqlstate '45002'
			set message_text = 'Un empleado no puede pertenecer a un departamento 
									distinto del de su jefe',
            mysql_errno = 45002;
	end if;
end; $$

DELIMITER $$
drop trigger if exists tr_bi_empJefeDept; $$
create trigger tr_bi_empJefeDept before insert
					on emple for each row
begin
	declare jefe int;
    declare dept_jefe int;
    
    set jefe = new.dir;
    
    select dept_no into dept_jefe
		from emple
	   where emp_no = jefe;
      
	if new.dept_no != dept_jefe then
		signal sqlstate '45002'
			set message_text = 'Un empleado no puede pertenecer a un departamento 
									distinto del de su jefe',
            mysql_errno = 45002;
	end if;
end; $$
