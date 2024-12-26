use tienda_inf;

-- C01
select nombre
	from producto;
    
-- C02
select nombre, precio
	from producto;
    
-- C03
select *
	from producto;

-- C04
select nombre, precio, precio*1.08 precio_dolar
	from producto;

-- C05
select nombre nombre_de_producto, precio euros, precio*1.08 dolares
	from producto;
    
-- C06
select id_fabricante 
	from producto;

-- C07
select distinct id_fabricante 
	from producto;
    
-- C08
select nombre	
    from fabricante
    order by nombre asc;
    
-- C09
select nombre	
    from fabricante
    order by nombre desc;

-- C10
select nombre
	from producto
    order by id_fabricante asc, precio desc;

-- C11
select *
	from fabricante
    limit 5;

-- C12
select *
	from fabricante
    order by nombre asc
    limit 5;
    
-- C13
select *
	from fabricante
    order by nombre asc
    limit 3, 2;
    
-- C14
select nombre, precio
	from producto
    order by precio asc
    limit 1;

-- C15
select nombre, precio
	from producto
    order by precio desc
    limit 1;

-- C16
select nombre, precio*3 precio_3_unid
	from producto;

-- C17
select concat(id,' - ',nombre) id_nombre, web
	from fabricante;
    
-- C18
select id, nombre, precio,
	case 
		when (precio < 100)							then 'barato'
		when (precio >= 100 && precio < 300)		then 'medio'
		when (precio > 300)							then 'alto'
	end tipo_precio
	from producto;
    
-- C19
select id, nombre, precio,
	case 
		when (precio < 300)							then 'barato'   
		when (precio > 300)							then 'caro'
    end estimacion
	from producto;

-- C20
select id, nombre, ifnull(web, 'https://www.google.es') web
	from fabricante;
    
-- C21
select lower(nombre) nombre_min, upper(substr(nombre, 1, 2)) dos_siglas_may
	from fabricante;
    
-- C22
select nombre, round(precio) precioRed
	from producto;

-- C23
select nombre, truncate(precio,0) precioSinDecimales
	from producto;
    
-- C24
select nombre, length(nombre) longitud_nombre
	from fabricante;
    
-- C25
select nombre, if(length(nombre) >= 8,'long. larga','long. corta') longitud_nombre
	from fabricante;

-- C26
select nombre, adddate(current_date(), interval -id_fabricante day) resta_Fecha_ID_Fabricante
	from producto;

-- C27
select concat(upper(substr(nombre, 1,2)),lower(substr(nombre, 3,1)),upper(substr(nombre, 4, length(nombre)))) nombre_3min
	from producto;
    
-- C28
select *	
	from producto
    where id_fabricante = 3;
    
-- C29
select *
	from fabricante
    where substr(nombre, 1, 1) like 'S%';
    
-- C30
select *
	from producto
    where precio < 200;
    
-- C31
select id, nombre, round(precio) precio_redondeado, id_fabricante
	from producto
    where precio > 150
    order by round(precio) asc    
    limit 3;
    
-- C32
select nombre, precio
	from producto
    where nombre like '%HP%';
    
-- C33
select nombre, precio * 100 centimos
	from producto;
    
-- C34
select *
	from producto
    where (precio >= 80 && precio <= 300);
    
-- C35
select *
	from producto
    where precio between 80 and 300;
    
-- C36
select *
	from producto
    where (precio > 220 && id_fabricante = 1);

-- C37
select *
	from fabricante
    where (web is null && id <= 6 );

-- C38
select *
	from producto
    where (length(nombre) < 21 or precio < 100);
    
-- C39
select *
	from fabricante
    where web is not null 
    && (substr(reverse(nombre), 1,1) = 'D' or substr(reverse(nombre), 1,1) = 'G');

-- Otra opción más sencilla
select *
	from fabricante
    where web is not null
    and (nombre like '%D' or nombre like '%G');
    
-- C40
select *
	from producto
    where nombre like '%Monitor%' && precio < 215;

-- C41
select nombre, precio
	from producto
    where precio >= 180
    order by precio desc, nombre asc;
    
-- C42
select id, nombre, precio
	from producto
    where (id_fabricante >= 5 and precio > 500)
    or (id_fabricante like 2 and precio > 500);
    
#Consultas parte 2

-- C01
select p.nombre nombre_producto, p.precio, f.nombre nombre_fabricante
	from fabricante f inner join producto p
    on f.id = p.id_fabricante;

-- C02
select p.nombre, p.precio, f.nombre
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    order by f.nombre asc, p.nombre asc;

-- C03
select p.id, p.nombre, f.id, f.nombre
	from fabricante f inner join producto p
    on f.id = p.id_fabricante;
    
-- C04
select p.nombre nombre_producto, p.precio, f.nombre nombre_fabricante
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    order by p.precio limit 1;

-- C05
select p.nombre nombre_producto, p.precio, f.nombre nombre_fabricante
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    order by p.precio desc limit 1;
    
-- C06
select p.*
	from fabricante f inner join producto p
    on p.id_fabricante = f.id
    where f.nombre = 'lenovo';
    
-- C07
select p.*
	from fabricante f inner join producto p
    on p.id_fabricante = f.id
    where f.nombre = 'crucial' and p.precio > 200;
    
-- C08
select p.*
	from fabricante f inner join producto p 
    on p.id_fabricante = f.id
    where f.nombre = 'asus' or f.nombre = 'hewlett-packard' or f.nombre = 'seagate';
    
-- C09
select p.*
	from fabricante f inner join producto p 
    on p.id_fabricante = f.id
    where f.nombre in ( 'asus','hewlett-packard','seagate');

-- C10
select p.nombre, p.precio
	from fabricante f inner join producto p
    on p.id_fabricante = f.id
    where f.nombre like '%e';

-- C11
select p.nombre, p.precio
	from fabricante f inner join producto p
    on p.id_fabricante = f.id
    where f.nombre like '%w%';
    
-- C12
select p.nombre nombre_producto, p.precio, f.nombre nombre_fabricante
	from fabricante f inner join producto p
    on p.id_fabricante = f.id
    where p.precio >= 180
    order by p.precio desc, p.nombre asc;

-- C13
select distinct f.id, f.nombre
	from fabricante f inner join producto p 
    on p.id_fabricante = f.id;
    
-- C14
select f.nombre nombre_fabricante, p.nombre nombre_producto
	from fabricante f left join producto p 
    on p.id_fabricante = f.id;

-- C15
select f.nombre, p.nombre	 
	from fabricante f left join producto p 
    on p.id_fabricante = f.id
    where p.id is null;

-- C16
# No, ya que en la tabla producto el id_fabricante es un campo que no puede ser nulo, 
# además de ser una clave ajena.

# Consultas 03
-- C01
select count(id) numero_productos
	from producto;
    
-- C02
select count(id) numero_fabricantes
	from fabricante;
    
-- C03
select count(distinct id_fabricante) valoresDistintosFabricante
	from producto;
    
-- C04
select format(avg(precio), 2) media_precios_productos
	from producto;
    
-- C05
select min(precio) precio_minimo
	from producto;
    
-- C06
select max(precio) precio_max
	from producto;

-- C07
select nombre, precio
	from producto
    order by precio asc
	limit 1;
    
-- C08
select nombre, precio
	from producto
    order by precio desc
    limit 1;

-- C09
select sum(precio) suma_precios
	from producto;
    
-- C10
select f.nombre, count(p.id) productos_Asus
	from fabricante f inner join producto p 
    on f.id = p.id_fabricante
    group by f.nombre
    having f.nombre like 'Asus';

-- C11
select  avg(precio) precio_medio
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    where f.nombre like 'Asus';
    
-- C12
select min(precio) precio_min
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    where f.nombre like 'Asus';
    
-- C13
select max(precio) precio_max
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    where f.nombre like 'Asus';
    
-- C14
select sum(precio) suma_precios
	from fabricante f inner join producto p
	on f.id = p.id_fabricante
    where f.nombre like 'Asus';

-- C15
select max(precio) precio_max, min(precio) precio_min, avg(precio) media_precios, count(*) total_productos
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    group by f.nombre
    having f.nombre like 'Crucial';
    
-- C16
select f.nombre, count(id_fabricante) productos
	from fabricante f left join producto p
    on f.id = p.id_fabricante
    group by f.id
    order by 2 desc;
    
-- C17
select f.nombre, max(p.precio) precio_max, min(p.precio) precio_min, avg(p.precio) precio_medio
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    group by f.id;

-- C18
select id_fabricante, max(precio) precio_max, min(precio) precio_min, avg(precio) media_precios, count(id) num_productos
	from  producto 
    group by id_fabricante
    having avg(precio) > 200;
    
-- C19
select f.nombre, max(precio) precio_max, min(precio) precio_min, avg(precio) precio_medio, count(*) num_productos
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    group by p.id_fabricante
    having avg(precio) > 200;
    
-- C20
select count(*) total_productos
	from producto
    where precio >= 180;

-- C21
select f.nombre, count(p.id) total_productos
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
   where p.precio >= 180
   group by f.id;
    
-- C22
select id_fabricante, avg(precio) media_precios
	from producto
    group by id_fabricante;
    
-- C23
select f.nombre, avg(p.precio) media_precios
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    group by f.id;
    
-- C24
select f.nombre, avg(p.precio) media_precios
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    group by f.id
    having avg(p.precio) >= 150;
    
-- C25
select f.nombre, count(*) total_productos
	from fabricante f inner join producto p 
    on f.id = p.id_fabricante
    group by f.id
    having count(*) >= 2;
    
-- C26
select f.nombre, count(p.id) total_productos
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    where p.precio >= 220
    group by f.id;
    
-- C27
select f.nombre, count(p.id) total_productos
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
    where p.precio >= 220    
    group by f.id;
    


select f.nombre, if(p.precio < 220, '0', count(*)) 
	from fabricante f inner join producto p
    on f.id = p.id_fabricante
        
    group by f.nombre;
    
-- C28
select f.nombre, sum(p.precio) suma_precios
	from fabricante f inner join producto p 
    on f.id = p.id_fabricante
    group by f.id
    having sum(precio) > 1000;
    
-- C29
select max(p.precio) precio, f.nombre
	from fabricante f inner join producto p 
    on f.id = p.id_fabricante
    group by f.id
    having max(p.precio)
    order by f.nombre asc;

#Consultas 04
-- C01
select *
	from producto
	where id_fabricante = (select id
								from fabricante
								where nombre like 'lenovo');
    
-- C02
select *
	from producto
    where precio = (select max(precio)
						from producto p, fabricante f 
                        where p.id_fabricante = f.id 
							and f.nombre = 'Lenovo');

-- C03
select *
		from producto 
        where id_fabricante = (select id
									from fabricante
									where nombre = 'Lenovo')
		order by precio desc
        limit 1;

-- C04
select *
	from producto
    where id_fabricante = (select id
								from fabricante
                                where nombre = 'Hewlett-Packard')
	order by precio asc
    limit 1;

-- C05
select *
	from producto
    where precio >= (select max(p.precio)
						from fabricante f inner join producto p
							on f.id = p.id_fabricante
						where f.nombre = 'Lenovo');

-- C06
select *
	from producto p inner join fabricante f
		on p.id_fabricante = f.id
    where precio > (select avg(p.precio)
						from fabricante f inner join producto p
							on f.id = p.id_fabricante
						where f.nombre = 'Asus')
		and f.nombre = 'Asus';    
    
-- C07
select *
		from producto
        where precio >= all(select precio
								from producto);

-- C08
select *
		from producto
        where precio <= all(select precio
								from producto);

-- C09
select nombre
	from fabricante
    where id = any (select id_fabricante
						from producto);
    
-- C10
select nombre
	from fabricante
    where id = any (select f.id
						from producto p right join fabricante f
							on p.id_fabricante = f.id
						where p.id_fabricante is null);
-- mejor opción
select nombre
	from fabricante
    where id != all (select id_fabricante
						from producto);
    
-- C11
select nombre
	from fabricante
    where id in (select id_fabricante
					from producto);

-- C12
select nombre
	from fabricante
    where id not in (select id_fabricante
						from producto);
                        
-- C13
select distinct *
	from fabricante f 		
    where exists (select *
					from producto p
					where p.id_fabricante = f.id);

-- C14
select distinct *
	from fabricante f 		
    where not exists (select *
					from producto p
					where p.id_fabricante = f.id);
    
 -- C15
select f.nombre, p.nombre, p.precio
	from producto p, fabricante f 
	where (id_fabricante, precio) in (select id_fabricante, max(precio)
										from producto
										group by id_fabricante)
	and p.id_fabricante = f.id;
 
-- C16
select *
	from producto p, (select id_fabricante fab, avg(precio) media
							from producto
                            group by id_fabricante) e
	where p.id_fabricante = e.fab
		and p.precio >= e.media;

select p1.*
	from producto p1
    where p1.precio >= (select avg(precio)
						from producto p2
                        where p1.id_fabricante = p2.id_fabricante);


-- C17
select *
		from producto 
        where id_fabricante = (select id
									from fabricante
									where nombre = 'Lenovo')
		order by precio desc
        limit 1;
    
-- C18
select f.nombre, count(f.id) total_productos
	from fabricante f inner join producto p 
		on f.id = p.id_fabricante
        group by f.id
        having count(f.id) = (select  count(*)
									from fabricante f inner join producto p
										on f.id = p.id_fabricante
									and f.nombre = 'Lenovo');
        
    
    
    
    
    
