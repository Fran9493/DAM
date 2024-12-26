package com.mycompany.garciacutillasfranciscojoseactut04funciones;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class funcionesTarea04 {

    public int devuelveMayor(int num1, int num2, int num3) {

        int mayor = 0;

        if (num1 >= num2 && num1 >= num3) {
            mayor = num1;
        } else if (num1 <= num2 && num2 <= num3) {
            mayor = num3;
        } else {
            mayor = num2;
        }

        return mayor;
    }

    public boolean multiplo(int num1, int num2) {

        boolean multiplo = false;

        if (num1 % num2 == 0) {
            multiplo = true;
        }

        return multiplo;
    }

    public int aleatorioSinParametros() {

        int aleatorio = (int) (Math.random() * ((100 - 1) + 1)) + 1;

        return aleatorio;
    }

    public int aleatorio(int max, int min) {

        int aleatorio = (int) (Math.random() * ((max - min) + 1)) + min;

        return aleatorio;
    }

    public void pide5PreciosDevuelveIva() {

        Scanner sc = new Scanner(System.in);
        final double IVA = 1.21;

        for (int i = 0; i < 5; i++) {

            System.out.println("Introduce el precio " + (i + 1));
            double precioSinIva = sc.nextDouble();
            double precioConIva = 0.0;

            if (precioSinIva <= 0) {

                System.out.println("Error, has introducido un precio no válido");

            } else {

                precioConIva = precioSinIva * IVA;
                System.out.println("El precio con IVA de " + precioSinIva + " € es " + precioConIva + " €");

            }

        }

    }

    public void tablaMultiplicar(int tabla) {

        System.out.println("**** Tabla de multiplicar del " + tabla + " ****");
        System.out.println("");

        for (int i = 0; i < 11; i++) {

            int resultado = tabla * i;
            System.out.println(tabla + " * " + i + " = " + resultado);

        }

    }

    public String numeroDni(int numDni, String accionARealizar) {

        int modulo = numDni % 23;
        char letraDni = ' ';
        boolean errorDni = false;
        String salida = "";

        //Condición para DNI correcto y cálculo de letra
        if ((numDni / 10000000 != 0) && (numDni <= 99999999 && numDni > 0)) {

            switch (modulo) {
                case 0:
                    letraDni = 'T';
                    break;
                case 1:
                    letraDni = 'R';
                    break;
                case 2:
                    letraDni = 'W';
                    break;
                case 3:
                    letraDni = 'A';
                    break;
                case 4:
                    letraDni = 'G';
                    break;
                case 5:
                    letraDni = 'M';
                    break;
                case 6:
                    letraDni = 'Y';
                    break;
                case 7:
                    letraDni = 'F';
                    break;
                case 8:
                    letraDni = 'P';
                    break;
                case 9:
                    letraDni = 'D';
                    break;
                case 10:
                    letraDni = 'X';
                    break;
                case 11:
                    letraDni = 'B';
                    break;
                case 12:
                    letraDni = 'N';
                    break;
                case 13:
                    letraDni = 'J';
                    break;
                case 14:
                    letraDni = 'Z';
                    break;
                case 15:
                    letraDni = 'S';
                    break;
                case 16:
                    letraDni = 'Q';
                    break;
                case 17:
                    letraDni = 'V';
                    break;
                case 18:
                    letraDni = 'H';
                    break;
                case 19:
                    letraDni = 'L';
                    break;
                case 20:
                    letraDni = 'C';
                    break;
                case 21:
                    letraDni = 'K';
                    break;
                case 22:
                    letraDni = 'E';
                    break;
            }

            //DNI erróneo
        } else {
            // System.out.println("Error. No has introducido un DNI válido");
            salida = "Error. No has introducido un DNI válido";
            errorDni = true;
        }

        //Tipo de acción a realizar 
        if (!errorDni) {

            switch (accionARealizar) {

                case "L":
                    salida = "Al DNI introducido le corresponde la letra: " + letraDni;
                    break;

                case "C":
                    salida = "El DNI completo introducido sería: " + numDni + letraDni;
                    break;

                default:
                    salida = "Debes introducir el carácter 'L' o 'C' únicamente";
            }
        }
        return salida;
    }

    public int devuelveMayor2(int num1, int num2) {

        int mayor = 0;

        if (num1 >= num2) {
            mayor = num1;
        } else {
            mayor = num2;
        }

        return mayor;

    }

    public int devuelveMayor4(int num1, int num2, int num3, int num4) {

        int mayor1 = 0;
        int mayor2 = 0;
        int mayor3 = 0;

        mayor1 = devuelveMayor2(num1, num2);
        mayor2 = devuelveMayor2(num3, num4);
        mayor3 = devuelveMayor2(mayor1, mayor2);

        return mayor3;

    }

    public boolean vocal(String vocal) {

        boolean esVocal = false;

        if ("a".equals(vocal) || "e".equals(vocal)
                || "i".equals(vocal) || "o".equals(vocal) || "u".equals(vocal)) {
            esVocal = true;
        }

        return esVocal;
    }

    public double potencia(double num, int potencia) {

        double pot = potencia;

        double resultado = Math.pow(num, pot);

        return resultado;
    }

    public int devuelveSegundos(int dias, int horas, int minutos) {

        int segundos = (dias * (24 * 3600)) + (horas * 3600) + (minutos * 60);

        return segundos;
    }

    public int devuelveMinutos(int horas1, int minutos1, int horas2, int minutos2) {

        int totalMinutos1 = (horas1 * 60) + minutos1;
        int totalMinutos2 = (horas2 * 60) + minutos2;
        int minutoSalida = 0;

        if (minutos1 >= 60 || minutos2 >= 60) {

            minutoSalida = -1;

        } else if (totalMinutos1 < totalMinutos2) {

            minutoSalida = -2;

        } else {

            minutoSalida = totalMinutos1 - totalMinutos2;

        }

        return minutoSalida;
    }

    public int devuelveMinutosAbsoluto(int horas1, int minutos1, int horas2, int minutos2) {

        int totalMinutos1 = (horas1 * 60) + minutos1;
        int totalMinutos2 = (horas2 * 60) + minutos2;
        int minutoSalida = 0;

        if (minutos1 >= 60 || minutos2 >= 60) {

            minutoSalida = -1;

        } else {

            minutoSalida = Math.abs(totalMinutos1 - totalMinutos2);

        }

        return minutoSalida;
    }

    public boolean esPrimo(int numero) {

        boolean esPrimo = true;

        for (int i = 2; i <= numero - 1; i++) {

            if (numero % i == 0) {

                esPrimo = false;
                break;

            }

        }

        return esPrimo;
    }

    public void primosIntervalo(int numeroInicio, int numeroFin) {

        for (int i = numeroInicio; i <= numeroFin; i++) {

            if (esPrimo(i)) {
                System.out.println(i);
            }
        }
    }
}
