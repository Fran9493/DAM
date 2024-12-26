package com.mycompany.garciacutillasfranciscojoseut03;

import java.util.Scanner;
import java.math.*;

public class GarciaCutillasFranciscoJoseUT03 {

    public static void main(String[] args) {
        
    
       /* ejercicio1();
        ejercicio2();
        ejercicio3();*/
        ejercicio4();
        /*ejercicio5();
        ejercicio6();
        ejercicio7();
        ejercicio8();
        ejercicio9();
        ejercicio10();
        ejercicio11();*/
    
    }

    public static void ejercicio1() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 1****");
        System.out.println("");

        //Inicialización de las variables
        int numPantalla = 0;
        double calcMedia = 0;
        double suma = 0;
        double media = 0;
        int i = 0;

        //Introducción del número por pantalla
        System.out.println("Introduce la cantidad de números para hacer media: ");
        numPantalla = sc.nextInt();

        //Condición y cálculo
        if (numPantalla > 0 && numPantalla <= 10) {
            for (i = 1; i <= numPantalla; i++) {
                System.out.println("Introduce el número " + i + " : ");
                calcMedia = sc.nextDouble();
                suma += calcMedia;
            }
            media = suma / numPantalla;

            System.out.println("La media de los números introducidos es: " + media);
        } else {
            System.out.println("El número introducido debe ser mayor que 0 y menor de 10");
        }
    }

    public static void ejercicio2() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 2****");
        System.out.println("");

        //Inicialización de las variables
        int numPantalla = 0;
        int multiplo = 0;
        int contador = 25;

        //Introducción del número por pantalla
        System.out.println("Introduce un número entre 25 y 50: ");
        numPantalla = sc.nextInt();

        //Condición y cálculo
        if (numPantalla > 25 && numPantalla <= 50) {

            System.out.println("Los múltiplos de 3 son:");

            do {
                multiplo = contador % 3;
                if (multiplo == 0) {
                    System.out.println(contador);
                }
                contador++;
            } while (contador <= numPantalla);
        } else {
            System.out.println("El número introducido debe ser mayor que 25 y menor de 50");
        }
    }

    public static void ejercicio3() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 3****");
        System.out.println("");

        //Inicialización de las variables
        double nota = 0.0;
        int i = 0;
        int insuficiente = 0;
        int suficiente = 0;
        int bien = 0;
        int notable = 0;
        int sobresaliente = 0;

        //Introducción de la nota por pantalla
        for (i = 1; i <= 8; i++) {
            System.out.println("Introduce la nota del alumno " + i + ": ");
            nota = sc.nextDouble();
            if (nota >= 0.0 && nota <= 4.5) {
                insuficiente++;
            } else if (nota > 4.5 && nota < 5.75) {
                suficiente++;
            } else if (nota >= 5.75 && nota < 7) {
                bien++;
            } else if (nota >= 7 && nota < 8.8) {
                notable++;
            } else if (nota >= 8.8 && nota <= 10) {
                sobresaliente++;
            } else {
                System.out.println("La nota debe ser de 0 a 10");
            }
        }
        //muestra del informe por pantalla
        System.out.println("*****************************");
        System.out.println("**Informe de calificaciones**");
        System.out.println("*****************************");
        System.out.println("");
        System.out.println("Insuficientes: " + insuficiente);
        System.out.println("Suficientes: " + suficiente);
        System.out.println("Bien: " + bien);
        System.out.println("Notables: " + notable);
        System.out.println("Sobresalientes: " + sobresaliente);

    }

    public static void ejercicio4() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 4****");
        System.out.println("");

        //Inicialización de las variables
        int numero = 0;
        int i = 0;
        int menor = 0;
        int mayor = 0;

        //Introducción del número por pantalla
        for (i = 1; i <= 5; i++) {
            System.out.println("Introduce el número " + i + ": ");
            numero = sc.nextInt();
            
            if(i == 1){
                mayor = numero;
                menor = numero;
            }

            if (numero > mayor) {
                mayor = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }
        //muestra del mayor y menor por pantalla        
        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);

    }

    public static void ejercicio5() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 5****");
        System.out.println("");

        //Inicialización de las variables
        int numIntroducido = 0;
        int i = 0;
        int sumaImpar = 0;
        int sumaPar = 0;

        //Introducción del número por pantalla
        System.out.println("Introduce un número entre 140 y 160:");
        numIntroducido = sc.nextInt();

        //Condición y cálculo
        if (numIntroducido >= 140 && numIntroducido <= 160) {
            for (i = 1; i <= numIntroducido; i++) {
                if (i % 2 == 0) {
                    sumaPar += i;
                } else {
                    sumaImpar += i;
                }
            }
            System.out.println("La suma de los números impares desde 1 hasta " + numIntroducido + " es: " + sumaImpar);
            System.out.println("La suma de los números pares desde 1 hasta " + numIntroducido + " es: " + sumaPar);

        } else {
            System.out.println("Debes introducir un número entre 140 y 160");
        }
    }

    public static void ejercicio6() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);
        Scanner letra = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 6****");
        System.out.println("");

        //Inicialización de las variables
        String nombre = "";
        String nombreMayor = "";
        double sueldo = 0;
        double sueldoMayor = 0;
        double sueldoMenor = Math.pow(1.7976931348623157, 308); //límite superior de la variable tipo double
        double media = 0;
        double sumaSueldo = 0;
        double diferencia = 0;
        int i = 0;

        //Introducción de los datos del trabajador
        for (i = 1; i <= 5; i++) {
            System.out.println("Introduce el nombre del trabajador: " + i);
            nombre = letra.nextLine();

            System.out.println("Introduce su sueldo:");
            sueldo = sc.nextDouble();

            //Cálculo del total para luego calcular la media
            sumaSueldo += sueldo;

            //Trabajador con el sueldo más alto
            if (sueldo > sueldoMayor) {
                sueldoMayor = sueldo;
                nombreMayor = nombre;
            }

            //Sueldo más bajo
            if (sueldo < sueldoMenor) {
                sueldoMenor = sueldo;
            }
        }

        //Media de los sueldos
        media = sumaSueldo / 5;

        //Diferencia entre el más alto y el más bajo
        diferencia = sueldoMayor - sueldoMenor;

        //Salida por pantalla de los resultados
        System.out.println("El empleado con el sueldo más alto es " + nombreMayor);
        System.out.println("La media de los sueldos es: " + media + " €");
        System.out.println("La diferencia entre el sueldo más alto y el más bajo es de " + diferencia + " €");

    }

    public static void ejercicio7() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);
        Scanner letra = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 7****");
        System.out.println("");

        //Inicialización de las variables
        String nombre = "";
        String nombreMayor1 = "";
        String nombreMayor2 = "";
        double sueldo = 0;
        double sueldoMayor1 = 0;
        double sueldoMayor2 = 0;
        int numTrabajadores = 0;
        int i = 0;

        //Condición de número de trabajadores
        System.out.println("Introduce el número de trabajadores entre 5 y 10");
        numTrabajadores = sc.nextInt();

        //Cálculo de los dos trabajadores con mayor sueldo
        if (numTrabajadores >= 5 && numTrabajadores <= 10) {
            for (i = 1; i <= numTrabajadores; i++) {
                System.out.println("Introduce el nombre del trabajador " + i);
                nombre = letra.nextLine();
                System.out.println("Introduce su sueldo");
                sueldo = sc.nextDouble();

                //Sueldo mayor de todos
                if (sueldo > sueldoMayor1 && sueldo > sueldoMayor2) {
                    sueldoMayor2 = sueldoMayor1;
                    nombreMayor2 = nombreMayor1;
                    sueldoMayor1 = sueldo;
                    nombreMayor1 = nombre;

                    //Segundo sueldo mayor
                } else if (sueldo > sueldoMayor2 && sueldo < sueldoMayor1) {
                    sueldoMayor2 = sueldo;
                    nombreMayor2 = nombre;
                }

            }
            System.out.println("Los empleados con el mayor sueldo son:");
            System.out.println(nombreMayor1);
            System.out.println(nombreMayor2);
        } else {
            System.out.println("El número de trabajadores debe ser entre 5 y 10");
        }
    }

    public static void ejercicio8() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 8****");
        System.out.println("");

        //Inicialización de las variables
        int numero = 1;
        int negativo = 0;
        int positivo = 0;

        //Listado de números introducidos
        while (numero != 0) {
            System.out.println("Introduce un número. Para finalizar pulse 0");
            numero = sc.nextInt();

            if (numero < 0) {
                negativo++;
            } else {
                positivo++;
            }
        }

        System.out.println("El total de números introducidos es:");
        System.out.println("Negativos -> " + negativo);
        System.out.println("Positivos -> " + (positivo - 1));
    }

    public static void ejercicio9() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 9****");
        System.out.println("");

        //Inicialización de las variables
        int numero = 1;
        int i = 0;
        int contMayor10 = 0;
        int contMenor10 = 0;
        boolean error = false;

        //Listado de números introducidos
        for (i = 1; i <= 8; i++) {

            System.out.println("Introduce el " + i + "º número positivo:");
            numero = sc.nextInt();
            if (numero > 0 && numero <= 10) {
                contMenor10++;
            }

            if (numero > 10) {
                contMayor10++;
            }

            if (numero < 0) {
                error = true;
                break;
            }
        }
        if (error == false) {
            System.out.println("Hay " + contMayor10 + " números mayores de 10 y " + contMenor10 + " números entre 1 y 10");
        } else {
            System.out.println("Error");
        }
    }

    public static void ejercicio10() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 10****");
        System.out.println("");

        //Inicialización de las variables
        int numero = 0;
        int esMayor = 0;
        boolean cumpleRequisitos = false;

        //Entrada por pantalla
        while (!cumpleRequisitos) {
            System.out.println("Introduce un número:");
            numero = sc.nextInt();

            if (numero > 0 && numero > esMayor) {
                esMayor = numero;
            } else {
                cumpleRequisitos = true;
                break;
            }
        }

        if (cumpleRequisitos) {
            System.out.println("Debes introducir un entero positivo y que sea mayor que el anterior introducido");
        }
    }

    public static void ejercicio11() {

        //Creación de la variable Scanner para la entrada por pantalla
        Scanner sc = new Scanner(System.in);
        Scanner letra = new Scanner(System.in);

        System.out.println("****RESOLUCIÓN EJERCICIO 11****");
        System.out.println("");

        //Inicialización de las variables
        int numAleatorio = 0;
        int rangoBajo = 1;
        int rangoAlto = 100;
        boolean finPrograma = false;
        String inicio = "";
        String acierto = "";
        String mayorMenor = "";

        //Generación del número aleatorio y pregunta al usuario
        System.out.println("Piensa un número entero del 1 al 100. Escribe 'si' cuando lo hayas pensado");
        inicio = letra.nextLine();

        if (inicio.equals("si")) {
            while (!finPrograma) {
                numAleatorio = (int) (Math.random() * ((rangoAlto - rangoBajo) + 1)) + rangoBajo;
                System.out.println("¿Es " + numAleatorio + " el número que has pensado? ('si'/'no')");
                acierto = letra.nextLine();

                //Acierto del número
                if (acierto.equals("si")) {
                    System.out.println("Las máquinas dominaremos el mundo");
                    finPrograma = true;
                    
                //Si no acierta
                } else if (acierto.equals("no")) {
                    System.out.println("Escribe 'mayor' o 'menor', dependiendo de si el número que has pensado es mayor o menor al que te he dicho:");
                    mayorMenor = letra.nextLine();

                    //Condición de que sea menor
                    if (mayorMenor.equals("menor")) {
                        rangoAlto = numAleatorio - 1;
                    
                    //Condición de que sea mayor
                    } else if (mayorMenor.equals("mayor")) {
                        rangoBajo = numAleatorio + 1;
                        
        //No se introducen bien las condiciones
                    } else {
                        System.out.println("No has introducido 'mayor' o 'menor'");
                        finPrograma = true;
                    }
                } else {
                    System.out.println("No has introducido 'si' o 'no'");
                    finPrograma = true;
                }
            }
        } else {
            System.out.println("No has escrito 'si' para comenzar");
        }
    }

}
