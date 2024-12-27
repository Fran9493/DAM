package com.mycompany.garcia_cutillas_franciscojose_act02_05arrays;

import java.util.Arrays;

/**
 *
 * @author fran
 */
public class Ejercicios {

    //Creación de la variable fun para usar la clase Funciones 
    Funciones fun = new Funciones();

    //Ejercicio 1
    public void ej01() {

        int resultado[] = fun.creaArrayAleatorio(1, 10, 10);

        System.out.println(Arrays.toString(resultado));

    }

    //Ejercicio 2
    public void ej02() {

        int resultado[] = fun.aleatoriosFecha(10, 8);
        System.out.println(Arrays.toString(resultado));

    }

    //Ejercicio 3
    public void ej03() {

        fun.menuComida();

    }

    //Ejercicio 4
    public void ej04() {

        double calActividades[] = {7.2, 6.3, 4.5, 9.5};
        int porcActividades[] = {30, 40, 20, 10};

        double resultado = fun.calificacionFinal(5.5, calActividades, porcActividades, 60, 40);

        if (resultado != -1) {

            System.out.println("La calificación final es: " + resultado);

        }

    }

    //Ejercicio 5
    public void ej05() {

        fun.juegoAciertaNum();

    }

    public void ej06() {

        fun.ahorcado();

    }

    public void ej07() {

        char array1[] = {'a', 'b', 'c', 'd', 'e'};
        char array2[] = {'b', 'a', 'c'};

        //Si el array principal es de menor longitud que el secundario
        if (array2.length > array1.length) {

            System.out.println("El array principal no puede ser de menor tamaño que el secundario");

        } else {

            boolean res = fun.arrayContenido(array1, array2);
            System.out.println("El array " + Arrays.toString(array2) + " está contenido en el "
                    + "array " + Arrays.toString(array1) + ": " + res);

        }

    }

}
