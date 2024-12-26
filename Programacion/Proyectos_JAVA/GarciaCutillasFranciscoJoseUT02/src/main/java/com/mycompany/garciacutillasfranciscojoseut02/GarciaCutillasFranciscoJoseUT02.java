package com.mycompany.garciacutillasfranciscojoseut02;

import java.util.Scanner;
import java.lang.String;


public class GarciaCutillasFranciscoJoseUT02 {

    public static void main(String[] args) {
        /*ejercicio1();
        ejercicio2();
        ejercicio3();*/
        ejercicio4();
        /*ejercicio5();
        ejercicio6();
        ejercicio7();
        ejercicio8();
        ejercicio9();
        ejercicio10();
        ejercicio11();
        ejercicio12();
        ejercicio13();
        ejercicio14();*/
    }

    public static void ejercicio1() {

        //Declaración de variables
        boolean esPar = false;
        int modulo = 0;
        int numEntrada = 0;

        System.out.println("**** Resolución ejercicio 1 ****");
        System.out.println("");

        //Introducción del entero por consola
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un entero para comprobar si es par o impar");
        numEntrada = sc.nextInt();

        //Cálculo del módulo para saber si es par o impar
        modulo = numEntrada % 2;

        //Condición par o impar y salida por consola
        if (modulo == 0) {
            System.out.println("El número " + numEntrada + " es par");

        } else {
            System.out.println("El número " + numEntrada + " es impar");
        }
    }

    public static void ejercicio2() {

        //Declaración de variables
        int numero1 = 0;
        int numero2 = 0;

        System.out.println("**** Resolución ejercicio 2 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de números por consola
        System.out.println("Introduce el primer número: ");
        numero1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        numero2 = sc.nextInt();

        //Comparación de los dos números
        if (numero1 == numero2) {
            System.out.println("Los números " + numero1 + " y " + numero2 + " son iguales");

        } else {
            System.out.println("Los números " + numero1 + " y " + numero2 + " son distintos");
        }
    }

    public static void ejercicio3() {

        //Declaración de variables
        int numero1 = 0;
        int numero2 = 0;

        System.out.println("**** Resolución ejercicio 3 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de números por consola
        System.out.println("Introduce el primer número: ");
        numero1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        numero2 = sc.nextInt();

        //Comparación de los dos números
        if (numero1 > numero2) {
            System.out.println("El número " + numero1 + " " + "es mayor que el número " + numero2);

        }else if(numero1 == numero2){
            System.out.println("El número " + numero1 +" y el número "+ numero2 +" son iguales");
            
        }else {
            System.out.println("El número " + numero2 + " " + "es mayor que el número " + numero1);
        }

    }

    public static void ejercicio4() {

        //Declaración de variables
        int numero1 = 0;
        int numero2 = 0;
        final int DIANACIMIENTO = 9;
        boolean cumpleRequisito = false;

        System.out.println("**** Resolución ejercicio 4 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de números por consola
        System.out.println("Introduce el primer número: ");
        numero1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        numero2 = sc.nextInt();

        //Comparación de los dos números
        if (numero1 > numero2) {
            if ((numero1 + numero2) > DIANACIMIENTO) {
                cumpleRequisito = true;
                System.out.println("El número " + numero1 + " es mayor que " + numero2 + " y la suma de ambos es mayor que " + DIANACIMIENTO + ":" + cumpleRequisito);
            } else {
                System.out.println("El número " + numero1 + " es mayor que " + numero2 + " pero la suma de ambos no es mayor que " + DIANACIMIENTO);
            }
        } else {
            System.out.println("El número " + numero1 + " es mayor que " + numero2 + " y la suma de ambos es mayor que " + DIANACIMIENTO + ":" + cumpleRequisito);
        }

    }

    public static void ejercicio5() {

        //Declaración de variables
        int numeroEntradasNiño = 0;
        int numeroEntradasAdulto = 0;
        final double PRECIONIÑO = 12.25;
        final double PRECIOADULTO = 17.50;
        double totalEntradas = 0;
        double precioDescuento = 0;

        System.out.println("**** Resolución ejercicio 5 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de número de entradas por consola
        System.out.println("Introduce el número de entradas de niño: ");
        numeroEntradasNiño = sc.nextInt();
        System.out.println("Introduce el número de entradas de adulto: ");
        numeroEntradasAdulto = sc.nextInt();

        //Cálculo del precio total sin descuento
        totalEntradas = (numeroEntradasNiño * PRECIONIÑO) + (numeroEntradasAdulto * PRECIOADULTO);

        //Condición para calcular descuento
        if (totalEntradas > 80) {
            precioDescuento = totalEntradas - (totalEntradas * 0.07);
            System.out.println("El precio de " + numeroEntradasNiño + " entradas para niño y " + numeroEntradasAdulto + " entradas para adulto es de: " + precioDescuento + "€");

        } else {
            System.out.println("El precio de " + numeroEntradasNiño + " entradas para niño y " + numeroEntradasAdulto + " entradas para adulto es de: " + totalEntradas + "€");
        }

    }

    public static void ejercicio6() {

        //Declaración de variables
        int numero1 = 0;
        int numero2 = 0;
        int numero3 = 0;
        int numero4 = 0;
        int numero5 = 0;
        int diaNacimiento = 0;
        int contador = 0;

        System.out.println("**** Resolución ejercicio 6 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de números por consola
        System.out.println("Introduce el primer número: ");
        numero1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        numero2 = sc.nextInt();
        System.out.println("Introduce el tercer número: ");
        numero3 = sc.nextInt();
        System.out.println("Introduce el cuarto número: ");
        numero4 = sc.nextInt();
        System.out.println("Introduce el quinto número: ");
        numero5 = sc.nextInt();
        System.out.println("Introduce tu día de nacimiento: ");
        diaNacimiento = sc.nextInt();

        //Condición para calcular los mayores
        if (numero1 > diaNacimiento) {
            contador++;
        }
        if (numero2 > diaNacimiento) {
            contador++;
        }
        if (numero3 > diaNacimiento) {
            contador++;
        }
        if (numero4 > diaNacimiento) {
            contador++;
        }
        if (numero5 > diaNacimiento) {
            contador++;
        }
        if (contador != 0) {
            System.out.println("Hay " + contador + " número/s mayor/es que " + diaNacimiento);
        } else {
            System.out.println("No hay ningún número mayor que " + diaNacimiento);
        }
    }

    public static void ejercicio7() {

        //Declaración de variables
        int numero1 = 0;
        int numero2 = 0;
        int numero3 = 0;

        System.out.println("**** Resolución ejercicio 7 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de números por consola
        System.out.println("Introduce el primer número: ");
        numero1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        numero2 = sc.nextInt();
        System.out.println("Introduce el tercer número: ");
        numero3 = sc.nextInt();

        //Condición para calcular el orden             
        if ((numero1 < numero2) && (numero2 < numero3)) {
            System.out.println("Los números introducidos de menor a mayor son: " + numero1 + ", " + numero2 + ", " + numero3);
        } else if ((numero2 < numero1) && (numero1 < numero3)) {
            System.out.println("Los números introducidos de menor a mayor son: " + numero2 + ", " + numero1 + ", " + numero3);
        } else if ((numero3 < numero2) && (numero2 < numero1)) {
            System.out.println("Los números introducidos de menor a mayor son: " + numero3 + ", " + numero2 + ", " + numero1);
        } else if ((numero1 < numero3) && (numero3 < numero2)) {
            System.out.println("Los números introducidos de menor a mayor son: " + numero1 + ", " + numero3 + ", " + numero2);
        } else if ((numero2 < numero3) && (numero3 < numero1)) {
            System.out.println("Los números introducidos de menor a mayor son: " + numero2 + ", " + numero3 + ", " + numero1);
        } else if ((numero3 < numero1) && (numero1 < numero2)) {
            System.out.println("Los números introducidos de menor a mayor son: " + numero3 + ", " + numero1 + ", " + numero2);
        }
    }

    public static void ejercicio8() {

        //Declaración de variables
        int numero1 = 0;
        int division = 0;
        int digito = 0;

        System.out.println("**** Resolución ejercicio 8 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción del número por consola
        System.out.println("Introduce un número entre 0 y 999999: ");
        numero1 = sc.nextInt();

        //Condición para calcular el número de dígitos   
        if ((numero1 >= 0) && (numero1 <= 999999)) {
            division = numero1 / 10;
            digito++;
            if (division != 0) {
                division = division / 10;
                digito++;
            }
            if (division != 0) {
                division = division / 10;
                digito++;
            }
            if (division != 0) {
                division = division / 10;
                digito++;
            }
            if (division != 0) {
                division = division / 10;
                digito++;
            }
            if (division != 0) {
                division = division / 10;
                digito++;
            }

            System.out.println("El número introducido tiene " + digito + " dígitos.");

        } else {
            System.out.println("No has introducido un número entre 0 y 999999");
        }
    }

    public static void ejercicio9() {

        //Declaración de variables
        double nota = 0.0;

        System.out.println("**** Resolución ejercicio 9 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción del número por consola
        System.out.println("Introduce la nota: ");
        nota = sc.nextDouble();

        //Condición para calcular la nota        
        if ((nota >= 0) && (nota <= 10)) {
            if ((nota >= 0) && (nota <= 4.5)) {
                System.out.println("La calificación es: insuficiente.");
            } else if ((nota >= 4.51) && (nota <= 5.74)) {
                System.out.println("La calificación es: suficiente.");
            } else if ((nota >= 5.75) && (nota <= 6.99)) {
                System.out.println("La calificación es: bien.");
            } else if ((nota >= 7) && (nota <= 8.79)) {
                System.out.println("La calificación es: notable.");
            } else if (nota >= 8.8) {
                System.out.println("La calificación es: sobresaliente.");
            }
        } else {
            System.out.println("Debes introducir una nota entre 0 y 10");
        }
    }

    public static void ejercicio10() {

        //Declaración de variables
        int nota = 0;
        String notaCaracter = "";
        boolean error = false;

        System.out.println("**** Resolución ejercicio 10 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción del número por consola
        System.out.println("Introduce la nota: ");
        nota = sc.nextInt();

        //Condición para calcular la nota        
        switch (nota) {
            case 0, 1, 2, 3, 4:
                notaCaracter = "insuficiente";
                break;
            case 5:
                notaCaracter = "suficiente";
                break;
            case 6:
                notaCaracter = "bien";
                break;
            case 7, 8:
                notaCaracter = "notable";
                break;
            case 9, 10:
                notaCaracter = "sobresaliente";
                break;
            default:
                error = true;
        }
        if (error != false) {
            System.out.println("La nota que has introducido no es correcta");
        } else {
            System.out.println("La nota es: " + notaCaracter);
        }
    }

    public static void ejercicio11() {

        //Declaración de variables
        int numDNI = 0;
        int modulo = 0;
        String letraDNI = "";

        System.out.println("**** Resolución ejercicio 11 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción del número del DNI por consola
        System.out.println("Introduce el número del DNI: ");
        numDNI = sc.nextInt();

        //Condición para calcular la letra 
        modulo = numDNI % 23;
        switch (modulo) {
            case 0:
                letraDNI = "T";
                break;
            case 1:
                letraDNI = "R";
                break;
            case 2:
                letraDNI = "W";
                break;
            case 3:
                letraDNI = "A";
                break;
            case 4:
                letraDNI = "G";
                break;
            case 5:
                letraDNI = "M";
                break;
            case 6:
                letraDNI = "Y";
                break;
            case 7:
                letraDNI = "F";
                break;
            case 8:
                letraDNI = "P";
                break;
            case 9:
                letraDNI = "D";
                break;
            case 10:
                letraDNI = "X";
                break;
            case 11:
                letraDNI = "B";
                break;
            case 12:
                letraDNI = "N";
                break;
            case 13:
                letraDNI = "J";
                break;
            case 14:
                letraDNI = "Z";
                break;
            case 15:
                letraDNI = "S";
                break;
            case 16:
                letraDNI = "Q";
                break;
            case 17:
                letraDNI = "V";
                break;
            case 18:
                letraDNI = "H";
                break;
            case 19:
                letraDNI = "L";
                break;
            case 20:
                letraDNI = "C";
                break;
            case 21:
                letraDNI = "K";
                break;
            case 22:
                letraDNI = "E";
                break;

        }
        if ((numDNI / 10000000 != 0) && (numDNI <= 99999999 && numDNI > 0)) {
            System.out.println("La letra que le corresponde es la: " + letraDNI);
        } else {
            System.out.println("El número introducido no es correcto");
        }
    }

    public static void ejercicio12() {

        //Declaración de variables
        int dia = 0;
        int mes = 0;
        int año = 0;
        final int AÑOACTUAL = 2022;

        System.out.println("**** Resolución ejercicio 12 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de la fecha por consola
        System.out.println("Introduce el día: ");
        dia = sc.nextInt();
        System.out.println("Introduce el mes: ");
        mes = sc.nextInt();
        System.out.println("Introduce el año: ");
        año = sc.nextInt();

        //Condición para calcular la fecha
        if ((dia > 0 && dia < 31) && (mes > 0 && mes <= 12) && (año > 0 && año < AÑOACTUAL)) {
            System.out.println("La fecha " + dia + "/" + mes + "/" + año + " es correcta");
        } else {
            System.out.println("La fecha introducida es incorrecta");
        }
    }

    public static void ejercicio13() {

        //Declaración de variables
        int dia = 0;
        int mes = 0;
        int año = 0;
        final int AÑOACTUAL = 2022;
        boolean condicion = false;

        System.out.println("**** Resolución ejercicio 13 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de la fecha por consola
        System.out.println("Introduce el día: ");
        dia = sc.nextInt();
        System.out.println("Introduce el mes: ");
        mes = sc.nextInt();
        System.out.println("Introduce el año: ");
        año = sc.nextInt();

        //Condición para calcular la fecha
        if ((dia > 0) && (año > 0 && año < AÑOACTUAL)) {
            switch (mes) {
                case 1,3,5,7,8,10,12:
                    if (dia <= 31) {
                        condicion = true;
                    }
                    break;
                case 2:
                    if (dia <= 28) {
                        condicion = true;
                    }
                    break;
                case 4,6,9,11:
                    if (dia <= 30) {
                        condicion = true;
                    }
                    break;
            }
            if (condicion == true) {
                System.out.println("La fecha " + dia + "/" + mes + "/" + año + " es correcta");
            } else {
                System.out.println("La fecha introducida no es correcta");
            }
        } else {
            System.out.println("La fecha introducida no es correcta");
        }
    }

    public static void ejercicio14() {

        //Declaración de variables
        int horas = 0;
        int minutos = 0;
        int segundos = 0;
        int totalSegundos = 0;

        System.out.println("**** Resolución ejercicio 14 ****");
        System.out.println("");

        //Creación de la variable Scanner para introducir por consola
        Scanner sc = new Scanner(System.in);

        //introducción de horas, minutos y segundos por consola
        System.out.println("Introduce las horas: ");
        horas = sc.nextInt();
        System.out.println("Introduce los minutos: ");
        minutos = sc.nextInt();
        System.out.println("Introduce los segundos: ");
        segundos = sc.nextInt();

        //Condición para calcular lo introducido añadiendo un segundo
        if ((horas >= 0) && (minutos >= 0) && (segundos >= 0)){
            totalSegundos = (horas * 3600) + (minutos * 60) + segundos;
            ++totalSegundos;
            horas = totalSegundos / 3600;
            minutos = (totalSegundos % 3600) / 60;
            segundos = (totalSegundos % 3600) % 60;
        
            System.out.println("El resultado de añadir un segundo a lo introducido es: " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos");
                
        }else{
           System.out.println("El formato de horas, minutos y segundos introducido no es válido"); 
        }      
    }
}
