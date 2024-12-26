use ligabaloncesto;

show variables like '%autocommit%';
set autocommit = 0;

select num_equipo
	from jugador
    order by salario desc;
    
select *
	from jugador
    limit 5;
 
select *
	from equipo
    order by puntos desc
    limit 1,4;
    
select nombre, apellido, puesto, salario/12 salario_mensual
	from jugador
    order by salario_mensual desc;

-- Obtener los 5 primeros registros de la tabla jugador
select *
	from jugador 
    limit 5;
    
-- Obtener los datos de los equipos clasificados entre el 2º y 5º puesto
select *
	from equipo
    order by puntos desc
    limit 1,4;
    
-- Obtén el mayor salario de todos los jugadores de baloncesto (debes hacer uso de MAX)
select max(salario) salario_máximo
	from jugador;
    
-- Obtén la menor altura de todos los jugadores de baloncesto (debes hacer uso del MIN)
select min(altura) altura_mínima
	from jugador;
    
-- Obtén el salario medio de todos los jugadores de baloncesto
select avg(salario) salario_medio
	from jugador;
    
-- Obtén el salario máximo y mínimo de los jugadores de cada equipo
select num_equipo, max(salario), min(salario)
	from jugador
    group by(num_equipo);
    
-- Consultar para cada altura el número de jugadores distintos que tienen esa altura
select altura, count(*)
	from jugador
    group by(altura);
    
-- Consulta el salario medio de cada posición que puede tener un jugador
select puesto, avg(salario)
	from jugador
    group by(puesto);

-- Consulta el número de partidos que ha pitado cada árbitro
select arbitro, count(*)
	from partido
    group by arbitro;

-- Devuelve el nombre del equipo y el sueldo medio de los jugadores de aquellos equipos cuyo salario medio es
-- esté por debajo de 85000 y debe estar ordenado por salario medio de mayor a menor
select e.nombre, avg(salario) sueldo_medio
	from equipo e inner join jugador j
    on e.id_equipo = j.num_equipo
 group by(j.num_equipo)
having avg(salario) < 85000
order by 2 desc; 

-- Devuelve aquellas posiciones de jugadores cuya media de salario esté por encima de 80000,
-- ordenadas de manera alfabética por el puesto.

select puesto, avg(salario)
	from jugador
    group by puesto
    having avg(salario > 80000)
    order by puesto asc;

-- Devuelve el nombre del equipo y la suma de los salarios de sus jugadores, de aquellos equipos cuya
-- suma total de salario este por encima de 200000, ordenando por la suma de salarios de menor a
-- mayor

select num_equipo, e.nombre, sum(salario)
	from equipo e inner join jugador j
		on e.id_equipo = j.num_equipo
    group by num_equipo
    having sum(salario) > 200000
    order by 3 asc;
    
-- Devuelve el nombre del equipo de aquellos que tengan 3 posiciones distintas de jugadores,
-- ordenados por el nombre del equipo alfabéticamente de mayor a menor

select e.nombre, count(distinct j.puesto) posiciones_distintas
	from equipo e inner join jugador j
		on e.id_equipo = j.num_equipo
	group by j.num_equipo
    having count(distinct j.puesto) = 3
    order by 1 desc;

/*Devuelve el nombre y apellidos de los jugadores que tengan la mayor de las alturas y tengan un 
salario que esté por encima de la media de los jugadores ordenado alfabéticamente primero 
por el apellido y luego por el nombre*/

select nombre, apellido
	from jugador
    where altura = (select max(altura) from jugador)
    and salario > (select avg(salario) from jugador)
    order by 2,1;

/*
Devuelve el nombre de aquellos equipos que tengan más puntos que la media de todos los equipos y cuyo
nombre comience por la letra ‘C’ ordenado de mayor a menor puntos.
*/

select nombre
	from equipo
    where puntos > (select avg(puntos) from equipo)
		and nombre like 'c%'
    order by puntos desc;

/*
Devuelve el nombre y apellido del jugador y nombre del equipo de aquellos jugadores que ganen al menos
20000 más que el jugador que menos gana y además jueguen en un equipo cuyo código sea el 2, 3, 4 o 5.
*/

select j.nombre, j.apellido, e.nombre
	from equipo e inner join jugador j 
		on e.id_equipo = j.num_equipo
	where j.salario >= (select min(salario) + 20000 from jugador)
		and j.num_equipo in(2,3,4,5);

/*
DIFICULTAD ALTA: Devuelve el nombre del equipo y el salario medio de aquellos equipos que tienen un
salario medio mayor o igual al que tiene el VALENCIA BASKET ordenado por nombre de equipo
*/

select e.nombre, avg(j.salario) salario_medio
	from jugador j inner join equipo e
		on j.num_equipo = e.id_equipo
	group by e.id_equipo
    having avg(j.salario) >= (Select avg(j.salario)
								from jugador j inner join equipo e 
									on j.num_equipo = e.id_equipo
								and e.nombre = 'valencia basket')
	order by 1;

/*
Queremos obtener aquellos jugadores que ganan menos que la media de su equipo,
pero sin contar el salario de dicho jugador a la hora de calcular esa media
*/	
select *
	from jugador j1
    where j1.salario < (select avg(j2.salario)
							from jugador j2
						   where j1.num_equipo = j2.num_equipo
								and j1.id_jugador != j2.id_jugador) ;
use ligabaloncesto;

select *
	from jugador;
    
/*
1. Insertar en la tabla jugadores a Jesús Ruíz que tendrá el código 19 del equipo 9 cuyo id de
capitán es el 17, fecha de alta el 14 de Octubre de 2013, salario 53000, altura desconocida y
cuyo puesto es BASE.
*/
insert into jugador (id_jugador, nombre, apellido, puesto, id_capitan, fecha_alta, salario,
						num_equipo, altura) values (19, 'Jesús', 'Ruiz', 'Base', 17, '2013-10-14',
													53000, 9, null);

/*
2. Insertar en la tabla equipo el equipo número 8, que será el estudiantes cuya web es
https://www.clubestudiantes.com/, es de Madrid y lleva 17 puntos.
*/   
select *
		from equipo;

insert into equipo (id_equipo, nombre, ciudad, web, puntos) values (8, "Estudiantes", 'Madrid', "https://www.clubestudiantes.com/", 17);


/*
3. Insertar en la tabla partido, el partido que ha jugado el equipo 2 como local contra el
equipo 3 de visitante, cuyo resultado ha sido 100.105 y se jugo el 4 de enero de 2012 a las
20:30. Se desconoce el árbitro.
*/
select *
	from partido;
    
insert into partido (elocal, evisitante, resultado, fecha, arbitro)
				values (2, 3, "100-105", '2012-01-04 20:30:00', null);
    
select *
	from partido
   where elocal = 2 and evisitante = 3;

/*
5. Crea una nueva tabla que se llamará jugador_capitan. Esta tabla solo tendrá cuatro campos:
id_capitan, nombre, apellido e id_equipo. Crea las FK que consideres e inserta los datos de todos
aquellos jugadores que sean capitan. Ojo, no hagas las insercinoes de manera manual sino con un
Select.
*/
create table jugador_capitan (
	id_capitan  int(5) primary key,    
    nombre		varchar(100) not null,
    apellido	varchar(100) not null,    
    id_equipo	int(4) not null,
    constraint fk_jc_jugador foreign key (id_capitan) references jugador (id_capitan)
				on delete restrict on update cascade,
    constraint fk_jc_equipo foreign key (id_equipo) references equipo (id_equipo) 
				on delete restrict on update cascade);
                
insert into jugador_capitan    
    select distinct j1.id_jugador, j1.nombre, j1.apellido, j1.num_equipo
		from jugador j1 inner join jugador j2
			on j1.id_jugador = j2.id_capitan;

select *
	from jugador_capitan;
    
/*
6. Utilizando el SET, inserta en la tabla jugadores a Jesús Ruíz que tendrá el código 19 del equipo 8
cuyo id de capitán es el 19, fecha de alta el 14 de Octubre de 2013, salario 53000, altura
desconocida y cuyo puesto es BASE.
*/
insert into jugador set id_jugador = 19,
						nombre = 'Jesús',
						apellido = 'Ruíz',
                        id_capitan = 19,
                        puesto = 'BASE',
                        fecha_alta = '2013-10-14',
                        salario = 53000,
                        num_equipo = 8,
                        altura = null;

select *
	from jugador;

/*
1. Cambia la posición del jugador con id 11 para que sea ALERO
*/
update jugador set puesto = 'ALERO' where id_jugador = 11;

/*
2. Sube el salario de los jugadores del equipo 5 en 1.000 euros
*/
update jugador set salario = salario + 1000 where num_equipo = 5;

select *
	from jugador;

/*
3. Cambia la estatura de FELIPE REYES para que sea nula
*/
update jugador set altura = null where nombre = 'FELIPE' and apellido = 'REYES';

select * 
	from jugador;

/*
4. Añade a la tabla EQUIPO un campo id_capitan que será clave ajena a la tabla jugador.
Actualiza ese campo que inicialmente estará a nulo para que almacene el dato del capitán
correspondiente.
*/
alter table equipo add column id_capitan int(5);
alter table equipo add constraint fk_equipo_capitan foreign key (id_capitan) references jugador(id_capitan)
on update cascade on delete restrict;

update equipo set id_capitan = (select id_capitan from jugador where num_equipo = id_equipo);

/*
5. Modificar el jugador con id 3 para que juegue en el CAJA LABORAL
*/  

create or replace view aleros as    
	select *
		from jugador
	   where puesto = 'Alero';

select *
	from aleros;
/*
• 1. Cree una vista jugador_equipo en la que salgan todos los datos de los jugadores junto con
el nombre de su equipo. Además nos gustaría que estuviera ordenada por el nombre del
equipo.
*/
create or replace view jugador_equipo as
select j.*, e.nombre nombre_equipo
	from jugador j inner join equipo e 
		on j.num_equipo = e.id_equipo
	  order by e.nombre;

select * 	
	from jugador_equipo;
    
/*
• 2. Cree una vista que se llamará jugador100 que contenga de los jugadores los datos:
id_jugador, nombre, apellido y además el nombre del equipo, pero solo para aquellos jugadores
que ganan más o igual a 100. En la vista jugadores100 los campos no se llamarán como en la
tabla sino que tendrán de nombre codigo, nomb_jug, apellido_jug y nomb_equipo.
*/
create or replace view jugador100 (codigo, nomb_jug, apellido_jug, nomb_equipo) as
select j.id_jugador, j.nombre nombre_jug, j.apellido apellido_jug, e.nombre nom_equipo
	from jugador j inner join equipo e
		on j.num_equipo = e.id_equipo
	  where j.salario >= 100000;

/*
• 3. Realiza una consulta de la vista y apunta el resultado obtenido. Ordénalos por apellido del
jugador
*/
select *
	from jugador100
   order by apellido_jug;
   
/*
4. Inserta un nuevo jugador con el código 92, de nombre Ricardo, de apellido Riquer y que
juega en la posición PIVOT. Su id_capitan y num_equipo será el 2 y la fecha de alta el 28 de
Febrero de 2019. No sabemos cuál será su altura y su salario ascenderá a 150000.
*/
insert into jugador set id_jugador = 92,
						nombre = 'Ricardo',
						apellido = 'Riquer',
                        id_capitan = 2,
                        puesto = 'PIVOT',
                        fecha_alta = '2019-02-28',
                        salario = 150000,
                        num_equipo = 2,
                        altura = null;
                        
/*
• 5. Realiza la misma consulta del apartado 3. ¿Han cambiado los resultados?
*/
select *
	from jugador100
   order by apellido_jug;

/*
• 6. Inserta en la vista jugador100 el siguiente jugador: Código: 95, Nombre: Antonio, Apellido:
Salgado y nombre de equipo REAL MADRID.
*/
insert into jugador100 set codigo = 95,
						nomb_jug = 'Antonio',
						apellido_jug = 'Salgado',
                        nomb_equipo = 'Real Madrid';

/*
• 7. Crea una vista con todos los equipos que tengan igual o más de 10 puntos. Deben salir los
mismos campos que tiene la propia tabla y se llamará equipo10
*/