package com.mycompany.garciacutillasfranciscojoseactut04funciones;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class ejerciciosUt04 {

    public void ejercicio01() {

        System.out.println("****RESOLUCIÓN EJERCICIO 1****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número entero:");
        int num1 = sc.nextInt();
        System.out.println("Introduce un número entero:");
        int num2 = sc.nextInt();
        System.out.println("Introduce un número entero:");
        int num3 = sc.nextInt();

        //Creación del método que vamos a utilizar en el ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Cálculo del mayor usando la función devuelveMayor
        int mayor = fun04.devuelveMayor(num1, num2, num3);

        //Salida por pantalla del mayor
        System.out.println("El número mayor introducido es: " + mayor);
    }

    public void ejercicio02() {

        System.out.println("****RESOLUCIÓN EJERCICIO 2****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número entero:");
        int num1 = sc.nextInt();
        System.out.println("Introduce un número entero:");
        int num2 = sc.nextInt();

        //Condición de error si se introduce el número 0
        if (num1 == 0 || num2 == 0) {

            System.out.println("Error. Debes introducir un valor distinto de 0");

        } else {

            //Creación del método que vamos a utilizar en el ejercicio
            funcionesTarea04 fun04 = new funcionesTarea04();

            //Cálculo si es múltiplo o no con la función "multiplo"
            boolean multiplo = fun04.multiplo(num1, num2);

            //Salida por pantalla
            System.out.println("El número " + num2 + " es múltiplo de " + num1 + ": " + multiplo);

        }
    }

    public void ejercicio03() {

        System.out.println("****RESOLUCIÓN EJERCICIO 3****");
        System.out.println("");

        //Cálculo del aleatorio
        funcionesTarea04 fun04 = new funcionesTarea04();
        int aleatorio = fun04.aleatorioSinParametros();

        System.out.println("El número aleatorio entre 1 y 100 calculado es: " + aleatorio);

    }

    public void ejercicio04() {

        System.out.println("****RESOLUCIÓN EJERCICIO 4****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número entero para el mínimo del aleatorio:");
        int num1 = sc.nextInt();
        System.out.println("Introduce un número entero para el máximo del aleatorio:");
        int num2 = sc.nextInt();

        //Cálculo del aleatorio
        funcionesTarea04 fun04 = new funcionesTarea04();
        int aleatorio = fun04.aleatorio(num2, num1);

        System.out.println("El número aleatorio entre " + num1 + " y " + num2 + " calculado es: " + aleatorio);

    }

    public void ejercicio05() {

        System.out.println("****RESOLUCIÓN EJERCICIO 5****");
        System.out.println("");

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Llamada al método
        fun04.pide5PreciosDevuelveIva();

    }

    public void ejercicio06() {

        System.out.println("****RESOLUCIÓN EJERCICIO 6****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de la tabla de multiplicar por consola
        System.out.println("Introduce la tabla de multiplicar que quieras resolver:");
        int tabla = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Llamada al método
        fun04.tablaMultiplicar(tabla);

    }

    public void ejercicio07() {

        System.out.println("****RESOLUCIÓN EJERCICIO 7****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición del número de DNI y acción a realizar
        System.out.println("Introduce el número del DNI:");
        int numDni = sc.nextInt();

        System.out.println("Introduce 'L' para recibir la letra del DNI únicamente, "
                + "o 'C' para recibir el DNI completo:");
        String accionARealizar = sc.next();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Llamada al método
        String salida = fun04.numeroDni(numDni, accionARealizar);

        System.out.println(salida);

    }

    public void ejercicio08() {

        System.out.println("****RESOLUCIÓN EJERCICIO 8****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los números por consola
        System.out.println("Introduce el primer número:");
        int num1 = sc.nextInt();

        System.out.println("Introduce el segundo número:");
        int num2 = sc.nextInt();

        System.out.println("Introduce el tercer número:");
        int num3 = sc.nextInt();

        System.out.println("Introduce el cuarto número:");
        int num4 = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Llamada al método y asignación del mayor
        int mayor = fun04.devuelveMayor4(num1, num2, num3, num4);

        System.out.println("El mayor de " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + " es: " + mayor);

    }

    public void ejercicio09() {

        System.out.println("****RESOLUCIÓN EJERCICIO 9****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los números por consola
        System.out.println("Introduce un carácter en minúscula:");
        String letra = sc.next();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Llamada al método 
        boolean vocal = fun04.vocal(letra);

        //Condición vocal o no vocal
        if (vocal) {
            System.out.println("El carácter introducido es una vocal");
        } else {
            System.out.println("El carácter introducido no es una vocal");
        }
    }

    public void ejercicio10() {

        System.out.println("****RESOLUCIÓN EJERCICIO 10****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los números por consola
        System.out.println("Introduce un número:");
        double num = sc.nextDouble();

        System.out.println("Introduce su potencia:");
        int potencia = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Condición error o potencia correcta
        if (potencia > 0) {

            //Llamada al método 
            double resultado = fun04.potencia(num, potencia);

            System.out.println("El resultado del número " + num + " elevado a " + potencia + " es: " + resultado);

        } else {
            System.out.println("La potencia debe ser un número positivo");
        }
    }

    public void ejercicio11() {

        System.out.println("****RESOLUCIÓN EJERCICIO 11****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los datos por pantalla
        System.out.println("Introduce los días:");
        int dias = sc.nextInt();

        System.out.println("Introduce las horas:");
        int horas = sc.nextInt();

        System.out.println("Introduce los minutos:");
        int minutos = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Condición para cálculo o error
        if (dias >= 0 && horas >= 0 && minutos >= 0) {

            //Llamada al método 
            int segundosTotales = fun04.devuelveSegundos(dias, horas, minutos);

            System.out.println("El resultado de " + dias + " días, " + horas + " horas y "
                    + minutos + " minutos en segundos es: " + segundosTotales);

        } else {
            System.out.println("Los días, horas y minutos no pueden ser negativos");
        }
    }

    public void ejercicio12() {

        System.out.println("****RESOLUCIÓN EJERCICIO 12****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los datos por pantalla
        System.out.println("Introduce las horas del primer instante:");
        int horas1 = sc.nextInt();

        System.out.println("Introduce los minutos del primer instante:");
        int minutos1 = sc.nextInt();

        System.out.println("Introduce las horas del segundo instante:");
        int horas2 = sc.nextInt();

        System.out.println("Introduce los minutos del segundo instante:");
        int minutos2 = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        /*Cálculo de la diferencia. Si no se cumple primer valor de horas y minutos
        mayor que el segundo, la función devuelve el valor -2. Si no se cumple minutos menor de 60 devuelve -1*/
        int resultado = fun04.devuelveMinutos(horas1, minutos1, horas2, minutos2);

        //Condición para cálculo o error
        if (resultado >= 0) {

            System.out.println("La diferencia en minutos de " + horas1 + " horas y " + minutos1 + " minutos, menos "
                    + horas2 + " horas y " + minutos2 + " minutos es: " + resultado + " minutos");

        } else if (resultado == -1) {

            System.out.println("Los minutos no pueden ser mayores de 59");

        } else if (resultado == -2) {

            System.out.println("Los primeros valores de horas y minutos deben ser mayores que los segundos");

        }
    }

    public void ejercicio13() {

        System.out.println("****RESOLUCIÓN EJERCICIO 13****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los datos por pantalla
        System.out.println("Introduce las horas del primer instante:");
        int horas1 = sc.nextInt();

        System.out.println("Introduce los minutos del primer instante:");
        int minutos1 = sc.nextInt();

        System.out.println("Introduce las horas del segundo instante:");
        int horas2 = sc.nextInt();

        System.out.println("Introduce los minutos del segundo instante:");
        int minutos2 = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Cálculo de la diferencia. Si no se cumple minutos menor de 60 devuelve -1
        int resultado = fun04.devuelveMinutosAbsoluto(horas1, minutos1, horas2, minutos2);

        //Condición para cálculo o error
        if (resultado != -1) {

            System.out.println("La diferencia en minutos de " + horas1 + " horas y " + minutos1 + " minutos, menos "
                    + horas2 + " horas y " + minutos2 + " minutos en valor absoluto es: " + resultado + " minutos");

        } else {

            System.out.println("Los minutos no pueden ser mayores de 59");

        }
    }

    public void ejercicio14() {

        System.out.println("****RESOLUCIÓN EJERCICIO 14****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los datos por pantalla
        System.out.println("Introduce un número para calcular si es primo o no:");
        int numero = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Cálculo para saber si es primo o no
        boolean resultado = fun04.esPrimo(numero);

        //Condición para cálculo o error
        if (numero > 1) {

            System.out.println("El número introducido es primo: " + resultado);

        } else {

            System.out.println("El número que introduzcas debe ser mayor de 1");

        }
    }

    public void ejercicio15() {

        System.out.println("****RESOLUCIÓN EJERCICIO 15****");
        System.out.println("");

        //Creación de la variable Scanner para introducir valores por consola
        Scanner sc = new Scanner(System.in);

        //Petición de los datos por pantalla
        System.out.println("Introduce el rango bajo para calcular los primos:");
        int numeroInicio = sc.nextInt();

        System.out.println("Introduce el rango alto para calcular los primos:");
        int numeroFin = sc.nextInt();

        //Creación de la variable para usar el método del ejercicio
        funcionesTarea04 fun04 = new funcionesTarea04();

        //Condición para cálculo o error
        if (numeroInicio > 1 && numeroFin > 1) {

            System.out.println("Los números primos del rango desde el " + numeroInicio + " al " + numeroFin + " son:");

            //Llamada a la función para que muestre los primos del rango
            fun04.primosIntervalo(numeroInicio, numeroFin);

        } else {

            System.out.println("El número que introduzcas debe ser mayor de 1");

        }
    }
}
