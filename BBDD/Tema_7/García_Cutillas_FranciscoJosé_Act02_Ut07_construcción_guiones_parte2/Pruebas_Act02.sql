
-- Ejercicio 1
call p_genera_aleatorio (20, 2, @sal1, @sal2, @sal3);
select @sal1 aleatorio1, @sal2 aleatorio2, @sal3 aleatorio3;

-- Ejercicio 2
select f_aleatorio_suma (5, 20) suma_aleatorios;

-- Ejercicio 3
call p_mejor_puntuacion (1, 15, @sal1, @sal2);
select @sal1 id_equipo, @sal2 nombre_equipo;

-- Ejercicio 4
select f_mejor_codigo (1,7) mejor_equipo;

-- Ejercicio 4_1
select f_mejor_nombre (-5,6) mejor_equipo;

-- Ejercicio 5
select f_inserta_partido (7, 7, 100, 100, 3) info;

-- Ejercicio 6
select f_partidos_local (7) res_partidos_local;

-- Ejercicio 7
select f_actualiza_jugador (1,8) info;

-- Ejercicio 8
select f_total_salarios (30) total_salarios;

-- Ejercicio 9
select f_abreviatura() apellido_abreviado;

-- Ejercicio 10
call p_recorta_salario ('v');
select substr(nombre, 1, 1) inicial, salario
	from jugador;

-- Ejercicio 11
call p_total_salarios (5, @sal1);
select @sal1 total_salarios_equipo;

-- Ejercicio 12
select f_salarios_cadena() salarios_equipos;



    

