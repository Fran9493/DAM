use ventas;

/*
C01. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno
de los clientes. Es decir, el mismo cliente puede haber realizado varios pedidos de diferentes
cantidades el mismo día. Se pide que se calcule cuál es el pedido de máximo valor para cada
uno de los días en los que un cliente ha realizado un pedido. Muestra el identificador del cliente,
nombre, apellidos, la fecha y el valor de la cantidad.
*/
select c.id, c.nombre, c.apellido1, c.apellido2, p.fecha fecha_pedido, p.ped_max pedido_máximo
	from cliente c inner join (select max(total) ped_max, fecha, id_cliente
									from pedido
								   group by fecha, id_cliente) p
		on c.id = p.id_cliente;


/*
C02. Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno
de los clientes, teniendo en cuenta que sólo queremos mostrar aquellos pedidos que superen la
cantidad de 2000 €.
*/
select max(total) ped_max, fecha, id_cliente
	from pedido
   group by fecha, id_cliente
  having max(total) > 2000;


/*
C03. Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante
la fecha 2016-08-17. Muestra el identificador del comercial, nombre, apellidos y total.
*/
select c.id, c.nombre, c.apellido1, c.apellido2, p.ped_max pedido_máximo
	from comercial c inner join (select max(total) ped_max, id_comercial
										from pedido
										  where fecha like '2016-08-17'
									  group by id_comercial) p
		on c.id = p.id_comercial;


/*
C04. Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de
pedidos que ha realizado cada uno de clientes. Tenga en cuenta que pueden existir clientes que
no han realizado ningún pedido. Estos clientes también deben aparecer en el listado indicando
que el número de pedidos realizados es 0.
*/    
select c.id, c.nombre, c.apellido1, c.apellido2, count(p.id_cliente) total_pedidos
	from cliente c left join pedido p
		on c.id = p.id_cliente
   group by c.id;


/*
C05. Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de
pedidos que ha realizado cada uno de clientes durante el año 2017.
*/
select c.id, c.nombre, c.apellido1, c.apellido2, count(p.id_cliente) total_pedidos
	from cliente c inner join pedido p
		on c.id = p.id_cliente
	  where year(p.fecha) = 2017
   group by c.id;


/*
C06. Devuelve un listado que muestre el identificador de cliente, nombre, primer apellido y el valor
de la máxima cantidad del pedido realizado por cada uno de los clientes. El resultado debe
mostrar aquellos clientes que no han realizado ningún pedido indicando que la máxima cantidad
de sus pedidos realizados es 0. Puede hacer uso de la función IFNULL.
*/   
select c.id, c.nombre, c.apellido1, ifnull(max(p.total), '0') total_máximo_pedido
	from cliente c left join pedido p 
		on c.id = p.id_cliente
   group by c.id;   


/*
C07. Devuelve el nombre y apellidos (no debe estar repetido) de aquellos comerciales que son jefe
de algún compañero.
*/
select comercial.nombre, comercial.apellido1, comercial.apellido2
	from comercial
    where id in (select distinct comercial_jefe
					from comercial
				   where comercial_jefe is not null);
                   

/*
C07.1. Devuelve cuál ha sido el pedido de máximo valor que se ha realizado cada año.
*/
select p.*
	from pedido p inner join (select max(total) ped_max
									from pedido
								  group by year(fecha)) m
		on p.total = m.ped_max;


/*
C08. Devuelve el número total de pedidos que se han realizado cada año.
*/
select year(fecha) año, count(*) total_pedidos
	from pedido
   group by year(fecha);


/*
C09. Devuelve el nombre y apellidos del comercial, así como el nombre y apellidos de su comercial
jefe (únicamente para aquellos comerciales que tiene un comercial jefe).
*/
select c1.nombre, c1.apellido1, c1.apellido2, c2.nombre nombre_responsable, c2.apellido1 apellido1_responsable, 
	   c2.apellido2 apellido2_responsable
	from comercial c1 inner join comercial c2
		on c1.comercial_jefe = c2.id;
    


/*
C10. Devuelve el nombre y apellidos del comercial, así como el nombre y apellidos de su comercial
jefe (este debe aparecer en una única columna). En caso de no tener un comercial jefe debe
aparecer en dicha columna Sin jefe.
*/
select c1.nombre, c1.apellido1, c1.apellido2, ifnull(concat(c2.nombre, ' ', c2.apellido1, ' ', c2.apellido2), 'Sin jefe') responsable
	from comercial c1 left join comercial c2
		on c1.comercial_jefe = c2.id;


/*
C11. Devuelve un listado con todos los pedidos que ha realizado Adela Salas Díaz. (Sin utilizar
INNER JOIN).
*/
select p.*
	from pedido p, cliente c 
   where p.id_cliente = c.id
	and (c.nombre = 'Adela' && c.apellido1 = 'Salas' && c.apellido2 = 'Díaz');

/*C12. Devuelve el número de pedidos en los que ha participado el comercial Daniel Sáez Vega. (Sin
utilizar INNER JOIN)
*/
select count(*) número_pedidos_DanielComercial
	from pedido
   where id_comercial = (select id
							from comercial c
						   where (c.nombre = 'Daniel' and c.apellido1 = 'Sáez' and c.apellido2 = 'Vega'));


/*
C13. Devuelve los datos del cliente que realizó el pedido más caro en el año 2019. (Sin utilizar
INNER JOIN)
*/
select c.*
	from cliente c, pedido p
   where c.id = p.id_cliente
	and p.total = (select max(total)
						from pedido
					   where year(fecha) = '2019')
	 and year(p.fecha) = 2019;


/*
C14. Devuelve la fecha y la cantidad del pedido de menor valor realizado por el cliente Pepe Ruiz
Santana.
*/
select p.fecha, p.total
	from pedido p inner join cliente c 
		on p.id_cliente = c.id
	 where c.nombre = 'Pepe' and c.apellido1 = 'Ruiz' and c.apellido2 = 'Santana'
   and p.total in (select min(p.total) ped_min
						from pedido p inner join cliente c 
							on p.id_cliente = c.id
					   where c.nombre = 'Pepe' and c.apellido1 = 'Ruiz' and c.apellido2 = 'Santana'
					  group by c.id
					 having min(p.total));


/*
C15. Devuelve un listado con los datos de los clientes y los pedidos, de todos los clientes que han
realizado un pedido durante el año 2017 con un valor mayor o igual al valor medio de los
pedidos realizados durante ese mismo año.
*/
select c.*, p.id id_pedido, p.total total_pedido, p.fecha fecha_pedido, p.id_comercial comercial_venta
	from cliente c inner join pedido p 
		on c.id = p.id_cliente
	  where year(p.fecha) = '2017'
		and p.total >= (select avg(total) media_2017
							from pedido
						   where year(fecha) = '2017');


/*
C16. Devuelve el pedido más caro que existe en la tabla pedido sin hacer uso de MAX, ORDER BY
ni LIMIT.
*/
select *
	from pedido
   where total >= all (select total
						from pedido);
                        

/*
C17. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando ANY o
ALL).
*/
select *
	from cliente
   where id = any (select c.id
	from cliente c left join pedido p
		on c.id = p.id_cliente
	  where p.id is null);


/*
C18. Devuelve un listado de los comerciales que no han realizado ningún pedido. (Utilizando ANY
o ALL).
*/
select *
	from comercial
   where id = any (select c.id
						from comercial c left join pedido p 
							on c.id = p.id_comercial
					   where p.id is null);


/*
C19. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando IN o NOT
IN).
*/
select c.*
	from cliente c left join pedido p 
		on c.id = p.id_cliente
   where c.id not in (select c.id
							from cliente c inner join pedido p
								on c.id = p.id_cliente);
                                

/*
C20. Devuelve un listado de los comerciales que no han realizado ningún pedido. (Utilizando IN o
NOT IN).
*/
select c.*
	from comercial c left join pedido p
		on c.id = p.id_comercial
   where c.id not in (select c.id
							from comercial c inner join pedido p
								on c.id = p.id_comercial);


#Utilizando la base de datos ligabaloncesto.sql con la que hemos trabajado en clase. Realiza las
#siguientes consultas.

use ligabaloncesto;

/*
C21. Obtener el nombre, apellido, nombre de equipo y puesto de todos los jugadores a excepción
de los que juegan en el equipo 1 y 2. Ordenar estos por el nombre del equipo y por el apellido
de estos.
*/
select j.nombre nombre_jugador, j.apellido apellido_jugador, e.nombre equipo, j.puesto puesto_jugador
	from jugador j inner join equipo e 
		on j.num_equipo = e.id_equipo
   where j.num_equipo not in(1,2)
  order by e.nombre asc, j.apellido;
  

/*
C22. Obtener el número de ciudades en las que hay equipos
*/
select count(distinct ciudad) num_ciudades_con_equipos
	from equipo;

/*
C23. Obtener el número de nombres diferentes de jugador que tenemos.
*/
select count(distinct nombre) número_nombres_diferentes
	from jugador;


/*
C24. Obtener el nombre y apellido de los jugadores que participaron en el último encuentro (ya sea
de local o de visitante)
*/                     
select j.nombre, j.apellido
	from jugador j inner join partido p 
		on j.num_equipo = p.elocal
   where p.fecha = (select fecha
						from partido
					  order by fecha desc
					  limit 1)
Union                 
select j.nombre, j.apellido
	from jugador j inner join partido p 
		on j.num_equipo = p.evisitante
   where p.fecha = (select fecha
						from partido
					  order by fecha desc
					  limit 1);
        

/*
C25. Obtener el nombre y la ciudad de los equipos que no hayan jugado ningún partido como
visitante.
*/
select nombre, ciudad
	from equipo
   where id_equipo not in (select distinct evisitante
								from partido);


/*
C26. Obtener el nombre y apellido de jugadores que NO hayan jugado nunca como visitante.
*/
select nombre, apellido
	from jugador
   where num_equipo not in (select distinct evisitante
								from partido);


/*
C27. Obtener el nombre de equipos que hayan jugado como local y les haya pitado un árbitro que
haya pitado más de un partido.
*/
select distinct e.nombre
	from equipo e inner join partido p
		on e.id_equipo = p.elocal
   where p.arbitro in (select arbitro
							from partido
						   group by arbitro
						  having count(arbitro) > 1);


/*
C28. Obtener el número de equipos que pagan a algún jugador igual o más de 97000
*/
select count(distinct e.id_equipo) num_equipos_sueldo_mas_de_97000
	from jugador j inner join equipo e 
		on j.num_equipo = e.id_equipo
   where j.salario >= 97000;


/*
C29. Obtener el nombre del equipo local, nombre del equipo visitante, fecha y resultado de todos
los partidos que se han jugado de 2012 en adelante ordenados por fecha de la más actual a la
más antigua.
*/   
select distinct l.equipo_local, v.equipo_visitante, l.fecha, l.resultado
	from (select e. id_equipo, e.nombre equipo_visitante, p.fecha, p.resultado
			from partido p inner join equipo e 
				on p.evisitante = e.id_equipo) v inner join (select e. id_equipo, e.nombre equipo_local, p.fecha, p.resultado
																from partido p inner join equipo e 
																	on p.elocal = e.id_equipo) l
		on v.id_equipo = l.id_equipo
   where year(l.fecha) >= 2012
   order by l.fecha desc;


/*
C30. Obtener nombre del equipo y el total de partidos que ha jugado como local aquellos equipos
que tienen jugadores que cobran más o igual a 105000 y tiene jugadores para los que
desconocemos su altura.
*/
select e.nombre_equipo, count(e.id_equipo) partidos_como_local
	from partido p inner join (select e.id_equipo id_equipo, e.nombre nombre_equipo
									from jugador j inner join equipo e 
										on j.num_equipo = e.id_equipo
								   where j.salario >= 105000
									  and j.altura is null) e
		on p.elocal = e.id_equipo
   group by e.id_equipo;


