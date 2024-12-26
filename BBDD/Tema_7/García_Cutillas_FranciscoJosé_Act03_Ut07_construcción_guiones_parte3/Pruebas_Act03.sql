use empleados;
SET GLOBAL log_bin_trust_function_creators = 1;

-- Ejercicio 1
update emple
	set dir = 7698
   where emp_no = 7934;

update emple
	set dir = 7839
   where emp_no = 7369;

insert into emple values (8000, 'CANO', 'Vendedor', 7839, current_date(), 3000, 0, 10);
insert into emple values (8000, 'CANO', 'Vendedor', 7566, current_date(), 3000, 0, 10);


-- Ejercicio 2
update emple 
	set salario = 1250
   where emp_no = 7369;

update emple 
	set salario = 1248
   where emp_no = 7369;


-- Ejercicio 3 
update emple 
	set dept_no = 10
   where emp_no = 7369;

update emple 
	set dept_no = 20
   where emp_no = 7369;

insert into emple values (8001, 'PEREZ', 'Vendedor', 7566, current_date(), 900, 0, 10);
insert into emple values (8001, 'PEREZ', 'Vendedor', 7566, current_date(), 900, 0, 20);
   

-- Ejercicio 4
update emple
	set salario = 700
   where emp_no = 7900;
   
update emple
	set salario = 900
   where emp_no = 7900;

insert into emple values (8002, 'GIMENEZ', 'Empleado', 7566, current_date(), 1200, 0, 20);
insert into emple values (8003, 'ALBALADEJO', 'Empleado', 7566, current_date(), 1050, 0, 20);


-- Ejercicio 5
update emple 
	set dept_no = 10, salario = 1800
   where emp_no = 7698;


-- Ejercicio 6
delete from emple where emp_no = 7499;
delete from emple where emp_no = 7521;
delete from emple where emp_no = 7654;
delete from emple where emp_no = 7844;
delete from emple where emp_no = 7900;

update emple 
	set dept_no = 10
  where emp_no = 7900;

update emple 
	set dept_no = 10
  where emp_no = 8003;


-- Ejercicio 7
update emple
	set comision = 1265
  where emp_no = 7369;

update emple
	set comision = 1300
  where emp_no = 7369;

insert into emple values (8008, 'ALEJO', 'Vendedor', 7782, current_date(), 1000, 1155, 10);
insert into emple values (8008, 'ALEJO', 'Vendedor', 7782, current_date(), 1000, 1150, 10);

