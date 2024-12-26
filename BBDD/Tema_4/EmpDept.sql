Drop database if exists EmpDept;
Create database if not exists EmpDept;

Use EmpDept;

Create table Departamento (
	id		numeric(3) primary key,
    nombre	varchar(100) not null unique);

Create table Empleado (
	id 				numeric(4) primary key,
    nombre			varchar(50) not null,
    id_departamento numeric(3) null,
    constraint fk_empl_depto Foreign key (id_departamento) 
		References Departamento(id) 
				On Delete set null On update cascade);
                
Insert Into Departamento Values(1, 'Desarrollo');
Insert Into Departamento Values(2, 'Sistemas');
Insert Into Departamento Values(3, 'Recursos Humanos');
    
Insert Into Empleado Values (1,'Pepe',1);
Insert Into Empleado Values (2,'María',2);
Insert Into Empleado Values (3, 'Juan',null);
