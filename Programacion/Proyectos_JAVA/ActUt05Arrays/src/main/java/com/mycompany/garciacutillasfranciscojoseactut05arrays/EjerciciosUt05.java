package com.mycompany.garciacutillasfranciscojoseactut05arrays;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class EjerciciosUt05 {

    //Creación de arrays que se pueden utilizar a lo largo de la tarea
    int array5[] = {-2, 0, 7, 8, 11};
    int array10[] = {-2, 4, 12, -5, 110, 110, 14, -10, 128, -10};
    int array210[] = {-5, 4, 10, 52, 110, -10, 18, -100, 2, 0};
    double arrayD10[] = {-5.5, 56.2, -15.3, -5.1, 125.8, 200.2, -68.9, 87.1, -3.2, 0.5};

    public void ejercicio01() {

        System.out.println("****RESOLUCIÓN EJERCICIO 1****");
        System.out.println("");

        //Creación de la variable para llamar al método de este ejercicio
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Llamada a la función
        int mayoresMedia = fun05.mayorMedia(array5);

        //Salida por pantalla del resultado
        System.out.println("Hay " + mayoresMedia + " números mayores que la media");

    }

    public void ejercicio02() {

        System.out.println("****RESOLUCIÓN EJERCICIO 2****");
        System.out.println("");

        //Creación de la variable para llamar al método de este ejercicio
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Llamada a la función
        fun05.mayorMenorRepite(array10);

    }

    public void Ejercicio3() {

        System.out.println("****RESOLUCIÓN EJERCICIO 3****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Llamada a la función para que me devuelva el array inverso
        int arrayResultado[] = fun05.arrayInverso(array10);

        //Salida por pantalla del resultado        
        System.out.println("El array inverso de:");
        fun05.imprimeArray(array10);

        System.out.println("");
        System.out.println("Es: ");
        fun05.imprimeArray(arrayResultado);

    }

    public void Ejercicio4() {

        System.out.println("****RESOLUCIÓN EJERCICIO 4****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Petición del número y llamada a la función para contar las veces que se repite 
        int numeroVeces = 0;
        int numeroIntroducido = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número para ver cuántas veces se repite:");
        numeroIntroducido = sc.nextInt();

        numeroVeces = fun05.cuentaNumeroArray(array10, numeroIntroducido);

        //Salida por pantalla del resultado        
        System.out.println("El número " + numeroIntroducido + " se encuentra " + numeroVeces + " veces.");

    }

    public void Ejercicio5() {

        System.out.println("****RESOLUCIÓN EJERCICIO 5****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Petición del número y llamada a la función para buscar en qué posición se encuentra 
        int posicion = 0;
        int numeroIntroducido = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número para ver en qué posición está:");
        numeroIntroducido = sc.nextInt();

        posicion = fun05.buscaNumeroArray(array10, numeroIntroducido);

        //Salida por pantalla del resultado   
        if (posicion == 0) {

            System.out.println("El número introducido no se encuentra en el array");

        } else {

            System.out.println("El número " + numeroIntroducido + " se encuentra en la posición "
                    + posicion + " del array.");

        }

    }

    public void Ejercicio6() {

        System.out.println("****RESOLUCIÓN EJERCICIO 6****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Llamada al método
        fun05.sumaPositivosNegativos(arrayD10);

    }

    public void Ejercicio7() {

        System.out.println("****RESOLUCIÓN EJERCICIO 7****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        //Petición del número y llamada a la función para buscar en qué posición se encuentra 
        int numElementos = 0;
        int valorMax = 0;
        int valorMin = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de elementos del array:");
        numElementos = sc.nextInt();

        System.out.println("Introduce el valor máximo:");
        valorMax = sc.nextInt();

        System.out.println("Introduce el valor mínimo:");
        valorMin = sc.nextInt();

        //Salida por pantalla del resultado   
        if (numElementos <= 0) {

            System.out.println("El número de elementos debe ser mayor de 0");

        } else {

            int arraySalida[] = fun05.creaArray(numElementos, valorMax, valorMin);

            //Muestra el array creado por pantalla
            System.out.println("El array creado es el siguiente:");
            fun05.imprimeArray(arraySalida);

        }

    }

    public void Ejercicio8() {

        System.out.println("****RESOLUCIÓN EJERCICIO 8****");
        System.out.println("");

        int primerArray[] = array10;
        int segundoArray[] = array210;
        int resultado[] = new int[primerArray.length];

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        if (primerArray.length != segundoArray.length) {

            System.out.println("Los arrays deben de tener el mismo número de elementos");

        } else {

            //Llamada al método
            resultado = fun05.sumaArray(primerArray, segundoArray);

            //Salida por pantalla del array resultado
            System.out.println("El resultado de la suma es:");
            fun05.imprimeArray(resultado);

        }

    }

    public void Ejercicio9() {

        System.out.println("****RESOLUCIÓN EJERCICIO 9****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        int arrayOrdenado[] = fun05.ordenaMayorMenor();

        //Salida por pantalla del resultado
        System.out.println("El array introducido ordenado de mayor a menor sería el siguiente:");
        fun05.imprimeArray(arrayOrdenado);

    }

    public void Ejercicio10() {

        System.out.println("****RESOLUCIÓN EJERCICIO 10****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        String arrayParImpar[] = fun05.parImpar(array5);

        //Salida por pantalla del resultado
        System.out.println("El contenido del array introducido como Par o Impar sería el siguiente");

        for (int i = 0; i < arrayParImpar.length; i++) {

            System.out.println(arrayParImpar[i]);

        }

    }

    public void Ejercicio11() {

        System.out.println("****RESOLUCIÓN EJERCICIO 11****");
        System.out.println("");

        //Creación de la variable necesaria para llamar a la función
        FuncionesUt05 fun05 = new FuncionesUt05();

        int array1[] = array5;
        int array2[] = array210;

        //Salida por pantalla del resultado        
        if (fun05.comparaArray(array1, array2) < 0) {

            System.out.println("Los arrays deben de ser de la misma dimensión");

        } else {

            System.out.println("Los arrays introducidos coinciden en "
                    + fun05.comparaArray(array1, array2) + " índices");

        }
    }
}
