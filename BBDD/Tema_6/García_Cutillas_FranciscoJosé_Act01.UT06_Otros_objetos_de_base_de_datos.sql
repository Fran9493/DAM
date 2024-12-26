use ligabaloncesto;

/*
1. Crea una vista que se llamará vw_capitan_basket que contenga el nombre,
apellido, puesto, salario y nombre del equipo de todos aquellos jugadores
que son capitanes.
*/
create or replace view vw_capitan_basket as
	select j.nombre, j.apellido, j.puesto, j.salario, e.nombre nombre_equipo
		from jugador j inner join equipo e
			on j.num_equipo = e.id_equipo
	   where id_capitan = id_jugador;
       

/*
2. En función de los puntos que tienen los equipos, crea una nueva vista que
se llame vw_clasificacion que contenga el nombre del equipo junto con los
puntos que tiene, de tal manera que en la primera posición aparezca el
mejor equipo en puntuación.
*/
create or replace view vw_clasificacion as
	select nombre, puntos
		from equipo
	   order by puntos desc;


/*
3. Inserta una nueva fila en la tabla equipo (puedes inventarte los datos salvo
que tienes que indicarle 15 puntos). Tras una consulta sobre la vista
vw_clasificacion reflexiona sobre si es necesario o no regenerar (volver a
generar) o refrescar esta vista.
*/
insert into equipo values (8, 'CB Molina', 'Molina de Segura', 'https://cbmolina.net/', 15);

select *
	from vw_clasificacion;
 
/*
4. Crea una nueva vista llamada vw_mejor_pagados que contenga aquellos
jugadores que ganen más que la media de todos. Solamente deberemos
indicar su id_jugador, nombre, apellido y puesto. Ordena esta vista de tal
manera que salga en primer lugar en la consulta aquel jugador que más
gane.
*/
create or replace view vw_mejor_pagados as
	select id_jugador, nombre, apellido, puesto
		from jugador
	   where salario > (select avg(salario) media_salarios
							from jugador)
	   order by salario desc;

       
/*
5. Crea una nueva llamada vw_num_jug_equipo que contenga el nombre de
los equipos y el número de los jugadores que tiene dados de alta. Ordena
la vista por nombre de equipo
*/
create or replace view vw_num_jug_equipo as
	select e.nombre nombre_equipo, count(e.id_equipo) jugadores_dados_alta
		from equipo e inner join jugador j 
			on e.id_equipo = j.num_equipo
		  group by e.id_equipo
		order by e.nombre;
        

/*
6. Crea una nueva vista vw_murcia que contenga todos aquellos jugadores
que jueguen en el BALONCESTO MURCIA (puedes hacer la consulta por
código del equipo). Añade un campo final que indique S o N en función de
si ese jugador es o no el capitán.
*/
create or replace view vw_murcia as
	select j.*, if(j.id_jugador = j.id_capitan, 'S', 'N') es_capitan
		from jugador j inner join equipo e 
			on j.num_equipo = e.id_equipo
		  where e.nombre = 'Baloncesto Murcia';


/*
7. Haz cambios en los datos de la base de datos para que la vista creada en
el apartado 6 muestre un mayor número de registros.
*/
insert into jugador values (17, 'Juan', 'Aniorte', 'Base', 15, '2023-04-19', 85000, 7, 1.9);
insert into jugador values (18, 'Antonio', 'Muñoz', 'Pivot', 15, '2022-05-22', 100000, 7, 2.2);
insert into jugador values (19, 'Pepe', 'Gimenez', 'Escolta', 15, '2023-04-01', 90000, 7, 2.0);


/*
8. Hemos revisado la vista anterior (apartado 6) y hemos pensado que
también nos gustaría tener el nombre del equipo en la vista.
*/
alter view vw_murcia as
	select j.*, if(j.id_jugador = j.id_capitan, 'S', 'N') es_capitan, e.nombre nombre_equipo
		from jugador j inner join equipo e 
			on j.num_equipo = e.id_equipo
		  where e.nombre = 'Baloncesto Murcia';


/*
9. Crea una vista de los partidos que se han jugado, pero junto al código del
equipo y en la misma columna separado por un – debe aparecer el
nombre. No queremos que aparezca el árbitro del encuentro. Llamaremos
a esta vista vw_partidos y la ordenaremos de tal manera que los
encuentros más antiguos salgan en los primeros resultados.
*/
create or replace view vw_partidos as
	select concat(e.id_equipo, ' - ', e.nombre) eq_local, concat(e1.id_equipo, ' - ', e1.nombre) eq_visitante, p.resultado, p.fecha
		from partido p inner join equipo e
			on p.elocal = e.id_equipo
		inner join equipo e1
			on e1.id_equipo = p.evisitante
		order by p.fecha asc;

        
/*
10. Obtener una vista que se llame salarios_equipo que contenga el nombre
de cada equipo junto al salario máximo de sus jugadores, el salario mínimo
y la media de sus salarios. Los campos se deberán llamar nombre_equipo,
sal_maximo, sal_minimo y sal_media.
*/
create or replace view salarios_equipo as
	select e.nombre nombre_equipo, max(j.salario) sal_maximo, min(j.salario) sal_minimo, avg(j.salario) sal_media
		from equipo e inner join jugador j
			on e.id_equipo = j.num_equipo
		group by e.id_equipo;


/*
11. La vista realmente queríamos llamarla vw_salarios_equipo.
*/
Rename table salarios_equipo to vw_salarios_equipo;


/*
12. Vamos a crear una nueva vista vw_local100 que muestre el nombre del
equipo y el total de partidos que ha jugado como local para aquellos
equipos que tienen jugadores que cobran más o igual a 90000 y tiene
jugadores para los que desconocemos su altura. Ordena la misma por el
nombre del equipo.
*/
create or replace view vw_local100 as
	select e.nombre nombre_equipo, count(e.id_equipo) total_partidos_local
		from partido p inner join equipo e 
			on p.elocal = e.id_equipo
		  where e.id_equipo in (select distinct e.id_equipo
									from jugador j inner join equipo e
										on j.num_equipo = e.id_equipo
									  where j.salario >= 90000
									  and j.altura is null)
		group by e.id_equipo
		order by e.nombre;


/*
13. Realiza los cambios oportunos para que te aparezcan dos filas más como
resultado en la fila anterior.
*/
update jugador
		set altura = null
	  where id_jugador in (2,3);

  
/*
14. Elimina la vista vw_local100
*/
drop view if exists vw_local100;


/*
15. Define con tu vocabulario que es un SINÓNIMO y qué utilidad tienen.
*/