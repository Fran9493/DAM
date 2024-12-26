-- Drop database EmpDeptv2;
Create database EmpDeptv2;
Use EmpDeptv2;

Create table Aula(
	id		numeric(3) primary key,
    nombre	varchar(50)	not null unique);
Create table Departamento (
	id		numeric(3) primary key,
    nombre	varchar(100) not null unique,
    aula	numeric(3) null,
    constraint fk_depto_aula Foreign Key (aula)
      References Aula(id) On delete set null 
						  On update cascade);
Create table Empleado (
	id 				numeric(4) primary key,
    nombre			varchar(50) not null,
    id_departamento numeric(3) null,
    id_empl_respons	numeric(4) null,
    constraint fk_empl_depto Foreign key (id_departamento) 
		References Departamento(id) 
				On Delete set null On update cascade,
    constraint fk_empl_empleado Foreign key (id_empl_respons)
		References Empleado(id) On delete set null
                   On update cascade);

Insert Into Aula Values (1, 'Aula 4.0');
Insert Into Aula Values (2, 'Aula 3.0');
Insert Into Aula Values (3, 'Sala Magna');
Insert Into Aula Values (4, 'Sala Reuniones');
			
Insert Into Departamento Values(1, 'Desarrollo',3);
Insert Into Departamento Values(2, 'Sistemas',null);
Insert Into Departamento Values(3, 'Recursos Humanos',2);
    
Insert Into Empleado Values (1,'Pepe',1,null);
Insert Into Empleado Values (2,'María',2,1);
Insert Into Empleado Values (3, 'Juan',null,1);



