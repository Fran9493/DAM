use empleados;

-- C01
select e.nombre, e.apellido1, e.apellido2, d.id id_dep, d.nombre nombre_dep, d.presupuesto, d.gastos
	from empleado e left join departamento d
    on e.id_departamento = d.id;

-- C02
select e.nombre, e.apellido1, e.apellido2, d.id id_dep, d.nombre nombre_dep, d.presupuesto, d.gastos
	from empleado e left join departamento d
    on e.id_departamento = d.id
    order by d.nombre asc, e.apellido1 asc, e.apellido2 asc, e.nombre asc;
    
-- C03
select distinct d.id id_dep, d.nombre nombre_dep
	from empleado e inner join departamento d
    on e.id_departamento = d.id;

-- C04
select distinct d.id id_dep, d.nombre nombre_dep, (d.presupuesto - d.gastos) ppto_actual_dep
	from empleado e inner join departamento d
    on e.id_departamento = d.id;

-- C05
select d.nombre nombre_dep
	from empleado e inner join departamento d
    on e.id_departamento = d.id
    where e.nif like '38382980M';

-- C06
select d.nombre nombre_dep
	from empleado e inner join departamento d
    on e.id_departamento = d.id
     where (e.nombre like 'Pepe') and (e.apellido1 like 'Ruiz') and (e.apellido2 like 'Santana');
     
-- C07
select e.*
	from empleado e inner join departamento d
    on e.id_departamento = d.id
    where d.nombre like 'I+D'
    order by e.apellido1 asc, e.apellido2 asc, e.nombre asc;

-- C08
select e.*
	from empleado e inner join departamento d
    on e.id_departamento = d.id
    where (d.nombre like 'Sistemas') or (d.nombre like 'Contabilidad') or (d.nombre like 'I+D')
    order by e.apellido1 asc, e.apellido2 asc, e.nombre asc;
   
select e.*
	from empleado e inner join departamento d
    on e.id_departamento = d.id
    where d.nombre in( 'Sistemas', 'Contabilidad', 'I+D')
    order by e.apellido1 asc, e.apellido2 asc, e.nombre asc;
    
-- C09
select e.nombre nombre_empleado
	from empleado e inner join departamento d
    on e.id_departamento = d.id
	where (d.presupuesto <100000) or (d.presupuesto >200000);

select e.nombre nombre_empleado
	from empleado e inner join departamento d
    on e.id_departamento = d.id
	where d.presupuesto not between 100000 and 200000;
    
-- C10
select distinct d.nombre
	from empleado e inner join departamento d
    on e.id_departamento = d.id
    where e.apellido2 is null;

-- C11
select 	e.id id_empl, e.nif, e.nombre nombre_empl, e.apellido1 apellido1_empl, e.apellido2 apellido2_empl,
		d.id id_depto, d.nombre nombre_depto, d.presupuesto ppto_depto, d.gastos gastos_depto
	from empleado e left join departamento d
    on e.id_departamento = d.id;

-- C12
select e.*
	from empleado e left join departamento d
    on e.id_departamento = d.id
    where e.id_departamento is null;
    
select *
	from empleado 
		where id_departamento is null;
    
-- C13
select d.*
	from empleado e right join departamento d
    on e.id_departamento = d.id
    where e.id_departamento is null;

#NO ORDENA POR NOMBRE, PREGUNTAR
-- C14
((select *
	from empleado e left join departamento d
    on e.id_departamento = d.id
	order by d.nombre asc) 
union
(select *
	from empleado e right join departamento d
    on e.id_departamento = d.id
	order by d.nombre asc));

-- C15
((select *
	from empleado e left join departamento d
    on e.id_departamento = d.id
    where e.id_departamento is null
    order by d.nombre)
union
(select *
	from empleado e right join departamento d
    on e.id_departamento = d.id
    where e.id_departamento is null
    order by d.nombre asc));

-- C16
select 	concat(e.id, ', ', e.nif, ', ', e.nombre, ' ', e.apellido1, ' ', ifnull(e.apellido2, ' ')) datos_empleado, p.nombre, 
		ifnull(d.nombre, 'DESCONOCIDO') nombre_depto
	from empleado e left join departamento d
    on e.id_departamento = d.id
    inner join provincia p
    on p.codigo = e.cod_provincia;
    
-- C17
select e.nombre, d.nombre nombre_depto
	from empleado e left join departamento d
    on e.id_departamento = d.id
    where (e.cod_provincia like '8' or e.cod_provincia like '23' or e.cod_provincia like '30') and (d.nombre like 'Desarrollo');
    
-- C18
select distinct d.nombre nombre_depto, d.presupuesto ppto_depto, d.gastos gastos_depto
	from empleado e inner join departamento d
    on e.id_departamento = d.id
    where e.cod_provincia like '30';

-- C19
select distinct p.codigo cod_prov, p.nombre nombre_prov
	from empleado e inner join provincia p 
    on e.cod_provincia = p.codigo
    inner join departamento d
    on e.id_departamento = d.id
    where (e.apellido1 like 'R%') and (d.presupuesto > d.gastos);

-- C20
select e.id, e.nombre, e.apellido1, e.apellido2, p.nombre nombre_prov, ifnull(d.nombre, 'DESCONOCIDO') nombre_depto
	from empleado e left join departamento d
    on e.id_departamento = d.id
    inner join provincia p 
    on e.cod_provincia = p.codigo
    where 	((d.gastos > d.presupuesto) and (e.apellido1 like 'F%'))
			or ((d.presupuesto > d.gastos) and (e.nombre like 'A%'));






















