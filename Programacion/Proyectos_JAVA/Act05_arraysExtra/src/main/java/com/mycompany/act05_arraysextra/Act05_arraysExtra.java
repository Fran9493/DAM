package com.mycompany.act05_arraysextra;

import java.util.Arrays;

/**
 *
 * @author pakiq
 */
public class Act05_arraysExtra {

    public static void main(String[] args) {

        int array5[] = {-2, -2, -2, -2, -2};
        int array10[] = {-2, 4, 12, -5, 110, 110, 14, -10, 128, -10};
        int array210[] = {-5, 4, 10, 52, 110, -10, 18, -100, 2, 0};
        double arrayD10[] = {-5.5, 56.2, -15.3, -5.1, 125.8, 200.2, -68.9, 87.1, -3.2, 0.5};
        

        Funciones fun = new Funciones();

        //Ejercicio 1        
        /*int res = fun.compruebaDistintosConSort(array5);

        if (res != -1) {

            System.out.println("El array introducido contiene " + res + " números distintos");

        } else {

            System.out.println("Los elementos del array son todos iguales");

        }*/
        //Ejercicio 2
        /*int res = fun.compruebaDistintos(array5);

        if (res != -1) {

            System.out.println("El array introducido contiene " + res + " números distintos");

        } else {

            System.out.println("Los elementos del array son todos iguales");

        }*/
        
        //Ejercicio 3
        //fun.resumenArray(array5);
        
        //Ejercicio 4
        String entrada[] = {"hola","programacion","sistemas","aula","juan"};
        /*char res[] = fun.convierteStringChar(entrada);
        System.out.println(Arrays.toString(res));*/
       
        
        //Ejercicio 5
        fun.ahorcado();
        
        //Ejercicio 6
       /* char array1[] = {'a','b','c','d','e'};
        char array2[] = {'d','c','b'};
        boolean res = fun.comparaArray(array1, array2);
        boolean res1 = fun.comparaArrayInverso(array1, array2);
        boolean res2 = fun.comparaArrayAmbosSentidos(array1, array2);
        
        System.out.println("El array "+Arrays.toString(array2)+" está contenido en el"
                + " array "+Arrays.toString(array1)+": "+res);
        
        System.out.println("El array "+Arrays.toString(array2)+" está contenido en el"
                + " array "+Arrays.toString(array1)+": "+res1);
        
        System.out.println("El array "+Arrays.toString(array2)+" está contenido en el"
                + " array "+Arrays.toString(array1)+": "+res2);
        
        */
        

    }
}
