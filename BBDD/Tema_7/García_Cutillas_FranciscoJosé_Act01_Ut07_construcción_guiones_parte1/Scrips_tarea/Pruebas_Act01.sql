use ligabaloncesto;
SET GLOBAL log_bin_trust_function_creators = 1;
/*
Ejercicio 1
Crea una función f_es_vocal que recibe una letra y retorna un TRUE si lo es y un FALSE en caso contrario
*/
select f_es_vocal('a') esVocal;
select f_es_vocal('E') esVocal;
select f_es_vocal('t') esVocal;

/*
Ejercicio 2
Crea una función que tendrá como parámetros de entradas dos enteros y tendrá que devolver si el primer número es divisible de manera exacta por el segundo, es decir, si se pasa un 7 y un 3 deberá devolver FALSE, pero si se pasa un 9 y un 3 deberá devolver TRUE.
*/
select f_divisible_exacto(7, 3) divisible;
select f_divisible_exacto(9, 3) divisible;
select f_divisible_exacto(12, 4) divisible;

/*
Ejercicio 3
Crea una función que, al pasar una cadena por parámetro, devuelve la misma en minúscula y al final tiene concatenado el tamaño de la longitud de la cadena. Por ejemplo, si se pasa hola, debería devolver hola4
*/
select f_minuscula_mide('cadena') min_mide;
select f_minuscula_mide('HOLA') min_mide;
select f_minuscula_mide('PrUeBa') min_mide;

/*
Ejercicio 4
Crea un procedimiento que tenga tres parámetros, dos de entrada y uno de salida. El tercer parámetro tendrá el resultado de multiplicar los dos primeros. 
Este procedimiento se llamará p_multiplica
*/
call p_multiplica (5, 3, @salida);
select @salida resultado;

call p_multiplica (8, 8, @salida);
select @salida resultado;

call p_multiplica (-2, 3, @salida);
select @salida resultado;

/*
Ejercicio 5
Utilizando el procedimiento creado anteriormente de nombre p_multiplica crea una función que se llamará f_multiplica que tendrá dos parámetros de entrada 
y devolverá el resultado de la multiplicación.
*/
select f_multiplica (3,3) resultado;
select f_multiplica (6,3) resultado;
select f_multiplica (7,9) resultado;

/*
Ejercicio 6
Crea una función que se llame f_media_equipo que devuelva la media del salario del código de equipo que se pasa como parámetro.
*/
select f_media_equipo(1) salario_medio;
select f_media_equipo(5) salario_medio;
select f_media_equipo(6) salario_medio;

/*
Ejercicio 7
Crea una función que se llame f_puesto_equipo que devuelva la posición en la que se encuentra ese equipo en la liga (se pasará el código). 
Ya sabéis que para saber su posición se debe revisar la columna puntos de la tabla equipo.
*/
select f_puesto_equipo (7) puesto_clasificacion;
select f_puesto_equipo (2) puesto_clasificacion; 
select f_puesto_equipo (5) puesto_clasificacion;

/*
Ejercicio 8
Crea un procedimiento que pasando el código de un equipo devuelva en dos parámetros de salida el número de partidos que ha jugado como local y los que ha jugado como visitante. El procedimiento p_partidos_equipo
*/
call p_partidos_equipo (1, @p_loc, @p_vis);
select @p_loc partidos_local, @p_vis partidos_visitante;

call p_partidos_equipo (2, @p_loc, @p_vis);
select @p_loc partidos_local, @p_vis partidos_visitante;

call p_partidos_equipo (6, @p_loc, @p_vis);
select @p_loc partidos_local, @p_vis partidos_visitante;

/*
Ejercicio 9
Crea una función que se llame f_num_partidos_equipos que devuelva el número total de partidos que ha jugado ese equipo 
(se pasará el NOMBRE del equipo). Se debe tener en cuenta tanto los partidos que ha jugado como local como visitante por 
lo que se aconseja hacer uso del procedimiento p_partidos_equipo
*/
select f_num_partidos_equipos ('REGAL BARCELONA') total_partidos;
select f_num_partidos_equipos ('REAL MADRID') total_partidos;
select f_num_partidos_equipos ('GRAN CANARIA') total_partidos;

/*
Ejercicio 10
Crea una función que se llame f_encima_media_eq que indique para un código de equipo el número de jugadores que 
cobran más de la media del salario de dicho equipo. Se debe hacer uso de la función f_media_equipo que hemos creado anteriormente.
*/
select f_encima_media_eq (1) total_jug_sueldo_mayor_media_eq;
select f_encima_media_eq (2) total_jug_sueldo_mayor_media_eq;
select f_encima_media_eq (4) total_jug_sueldo_mayor_media_eq;

/*
Ejercicio 11
Crea un procedimiento llamado p_jug_capitan que muestre por pantalla todos los jugadores que tienen como capitán al jugador que se pasa como parámetro (se pasa el código).
*/
call p_jug_capitan (6);
call p_jug_capitan (2);
call p_jug_capitan (3);

/*
Ejercicio 12
Crea una función que dado un código de equipo devuelva su nombre. Pon de nombre f_nom_equipo.
*/
select f_nom_equipo (1) nombre_Equipo;
select f_nom_equipo (4) nombre_Equipo;
select f_nom_equipo (7) nombre_Equipo;

/*
Ejercicio 13
Crea una función que dado un código de equipo y un salario (ambos son parámetros) nos indique el número de jugadores que para ese equipo cobran más de ese salario.
*/
select f_cobran_mas_que(1, 70000) jug_sueldo_mayor;
select f_cobran_mas_que(2, 110000) jug_sueldo_mayor;
select f_cobran_mas_que(4, 80000) jug_sueldo_mayor;

/*
Ejercicio 14
Crea una función f_fecha_equipo que recibiendo el NOMBRE de un equipo nos indique el número de partidos que ha jugado con fecha anterior a la fecha 
que también va a recibir como parámetro.
*/
select f_fecha_equipo ('REAL MADRID', '2018-01-01') num_part_anteriores;
select f_fecha_equipo ('VALENCIA BASKET', '2011-12-01') num_part_anteriores;
select f_fecha_equipo ('CAJA LABORAL', '2012-02-01') num_part_anteriores;

                           



















