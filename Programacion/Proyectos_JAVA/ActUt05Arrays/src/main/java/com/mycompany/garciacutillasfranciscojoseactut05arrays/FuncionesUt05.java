package com.mycompany.garciacutillasfranciscojoseactut05arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class FuncionesUt05 {

    public int mayorMedia(int arrayEntrada[]) {

        int sumaMedia = 0;
        int mayorMedia = 0;

        //Recorrido del array para hacer la suma para calcular la media
        for (int i = 0; i < arrayEntrada.length; i++) {
            sumaMedia += arrayEntrada[i];
        }

        //Cálculo de la media
        double media = (double)sumaMedia / arrayEntrada.length;

        //Recorrido del array para ver qué valores del mismo son mayores que la media obtenida
        for (int i = 0; i < arrayEntrada.length; i++) {

            if (arrayEntrada[i] > media) {
                mayorMedia++;
            }
        }

        return mayorMedia;
    }

    public void mayorMenorRepite(int arrayEntrada[]) {

        int mayor = 0;
        int menor = 0;
        int repMayor = 0;
        int repMenor = 0;

        //Recorrido del array
        for (int i = 0; i < arrayEntrada.length; i++) {

            //Guardado del mayor y menor en la primera vuelta
            if (i == 0) {

                mayor = arrayEntrada[i];
                menor = arrayEntrada[i];

                /*Esto es lo mismo
                mayor = arrayEntrada[0];
                menor = arrayEntrada[0];
                 */
            }

            //Condición para calcular el mayor y veces que se repite
            if (arrayEntrada[i] > mayor) {

                mayor = arrayEntrada[i];
                repMayor = 1;

            } else if (arrayEntrada[i] == mayor) {

                repMayor++;

            }

            //Condición para calcular el menor y veces que se repite
            if (arrayEntrada[i] < menor) {

                menor = arrayEntrada[i];
                repMenor = 1;

            } else if (arrayEntrada[i] == menor) {

                repMenor++;

            }
        }

        //Salida por pantalla del resultado
        System.out.println("El número mayor del array es el " + mayor
                + " y se repite " + repMayor + " veces");
        System.out.println("El número menor del array es el " + menor + " "
                + "y se repite " + repMenor + " veces");

    }

    public int[] arrayInverso(int arrayEntrada[]) {

        int arraySalida[] = new int[arrayEntrada.length];

        int j = arrayEntrada.length - 1;

        for (int i = 0; i < arrayEntrada.length; i++) {

            arraySalida[i] = arrayEntrada[j];
            j--;

        }

        return arraySalida;

    }

    //Función creada para usarla cada vez que queramos imprimir un array por pantalla
    public void imprimeArray(int arrayEntrada[]) {

        for (int i = 0; i < arrayEntrada.length; i++) {
            System.out.println(arrayEntrada[i]);
        }

    }

    public int cuentaNumeroArray(int arrayEntrada[], int numero) {

        int vecesNumero = 0;

        for (int i = 0; i < arrayEntrada.length; i++) {

            if (arrayEntrada[i] == numero) {
                vecesNumero++;
            }

        }

        return vecesNumero;

    }

    public int buscaNumeroArray(int arrayEntrada[], int numero) {

        int posicion = 0;

        for (int i = 0; i < arrayEntrada.length; i++) {

            if (arrayEntrada[i] == numero) {
                posicion = i + 1;
                break;
            }

        }

        return posicion;

    }

    public void sumaPositivosNegativos(double arrayEntrada[]) {

        double sumaPos = 0.0;
        double sumaNeg = 0.0;

        for (int i = 0; i < arrayEntrada.length; i++) {

            if (arrayEntrada[i] >= 0) {

                sumaPos += arrayEntrada[i];

            } else {

                sumaNeg += arrayEntrada[i];

            }

        }

        //Salida de los resultados por pantalla
        System.out.println("La suma del total de positivos es: " + sumaPos);
        System.out.println("La suma del total de negativos es: " + sumaNeg);

    }

    public int[] creaArray(int numElementos, int valorMax, int valorMin) {

        //Creación array de longitud variable dependiendo del valor "numElementos"
        int arraySalida[] = new int[numElementos];

        /*Formación del array con valores aleatorios máximos y mínimos preestablecidos
          en valorMax y valorMin*/
        for (int i = 0; i < arraySalida.length; i++) {

            arraySalida[i] = (int) (Math.random() * ((valorMax - valorMin) + 1)) + valorMin;

        }

        return arraySalida;

    }

    public int[] sumaArray(int[] primerArray, int[] segundoArray) {

        int sumaArray[] = new int[primerArray.length];

        for (int i = 0; i < primerArray.length; i++) {

            sumaArray[i] = primerArray[i] + segundoArray[i];

        }

        return sumaArray;

    }

    public int[] ordenaMayorMenor() {

        //Creación de la variable Scanner para introducir datos por pantalla
        Scanner sc = new Scanner(System.in);

        int arrayEntrada[] = new int[10];
        int arraySalida[] = new int[10];

        //Petición de los datos para rellenar el array
        for (int i = 0; i < arrayEntrada.length; i++) {

            System.out.println("Introduce el elemento número " + (i + 1) + " del array");
            arrayEntrada[i] = sc.nextInt();

        }

        Arrays.sort(arrayEntrada);

        int j = (arrayEntrada.length) - 1;

        for (int i = 0; i < arrayEntrada.length; i++) {

            arraySalida[i] = arrayEntrada[j];
            j--;

        }

        return arraySalida;
    }

    public String[] parImpar(int arrayEntrada[]) {

        String salida[] = new String[arrayEntrada.length];

        for (int i = 0; i < arrayEntrada.length; i++) {

            if (arrayEntrada[i] % 2 == 0) {

                salida[i] = "Par";

            } else {

                salida[i] = "Impar";

            }

        }

        return salida;

    }

    public int comparaArray(int array1[], int array2[]) {

        int vecesRepite = 0;

        if (array1.length != array2.length) {

            vecesRepite = -1;

        } else {

            for (int i = 0; i < array1.length; i++) {

                if (array1[i] == array2[i]) {

                    vecesRepite++;

                }

            }

        }

        return vecesRepite;

    }

}
