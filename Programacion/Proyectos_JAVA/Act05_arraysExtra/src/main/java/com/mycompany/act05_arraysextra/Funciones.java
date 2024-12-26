package com.mycompany.act05_arraysextra;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pakiq
 */
public class Funciones {

    public int compruebaDistintosConSort(int arrayEntrada[]) {

        int distintos = 1;
        int arrayAux[] = new int[arrayEntrada.length];

        //Copia y ordena el array de menor a mayor
        arrayAux = arrayEntrada;
        Arrays.sort(arrayAux);

        //Crea una variable auxiliar y le asignas el primer valor del array copiado
        int valorAnt = arrayAux[0];

        //Realiza comprobaciones de los elementos del array
        for (int i = 1; i < arrayAux.length; i++) {

            //Incrementa "distintos" si el valor es distinto al anterior
            if (arrayAux[i] != valorAnt) {

                distintos++;
                valorAnt = arrayAux[i];

            }

        }

        //Si todos los elementos del array son iguales
        if (valorAnt == arrayAux[0]) {

            distintos = -1;

        }

        return distintos;

    }

    public int[] ordenaArray(int arrayEntrada[]) {

        //Crea y copia el array de entrada para trabajar con él
        int arrayAux[] = new int[arrayEntrada.length];
        arrayAux = arrayEntrada;

        int menor = arrayAux[0];
        int indice = 0;
        int aux = 0;
        int puntero = 0;

        //Recorre el array tantas veces como elementos tenga, menos el último
        for (int i = 0; i < arrayAux.length - 1; i++) {

            for (int j = puntero; j < arrayAux.length; j++) {

                //Calcula el menor en cada recorrido y guarda el índice en el que se encuentra
                if (arrayAux[j] <= menor) {
                    menor = arrayAux[j];
                    indice = j;
                }
            }

            //Sustituye el valor menor encontrado por el que hay en el índice actual
            //actualiza el menor hipotético para la siguente vuelta. Los elementos ordenados ya no se
            //vuelven a comprobar
            aux = arrayAux[i];
            arrayAux[i] = menor;
            arrayAux[indice] = aux;
            puntero++;
            menor = arrayAux[puntero];

        }

        return arrayAux;

    }

    public int compruebaDistintos(int arrayEntrada[]) {

        int distintos = 1;
        int arrayAux[] = new int[arrayEntrada.length];

        //Copia y ordena el array de menor a mayor
        arrayAux = arrayEntrada;
        ordenaArray(arrayAux);

        //Crea una variable auxiliar y le asignas el primer valor del array copiado
        int valorAnt = arrayAux[0];

        //Realiza comprobaciones de los elementos del array
        for (int i = 1; i < arrayAux.length; i++) {

            //Incrementa "distintos" si el valor es distinto al anterior
            if (arrayAux[i] != valorAnt) {

                distintos++;
                valorAnt = arrayAux[i];

            }

        }

        //Si todos los elementos del array son iguales
        if (valorAnt == arrayAux[0]) {

            distintos = -1;

        }

        return distintos;

    }

    public void resumenArray(int arrayEntrada[]) {

        int contador = 0;
        int aux;
        boolean comprobado[] = new boolean[arrayEntrada.length];

        for (int i = 0; i < arrayEntrada.length; i++) {

            comprobado[i] = false;

        }

        //Recorre el array tantas veces como elementos tenga 
        for (int i = 0; i < arrayEntrada.length; i++) {

            //En cada recorrido, guarda el valor del elemento e inicializa contador a 0
            aux = arrayEntrada[i];
            contador = 0;

            //Recorre el array completo y busca las coincidencias
            for (int j = 0; j < arrayEntrada.length; j++) {

                if (aux == arrayEntrada[j]) {

                    contador++;

                    //En el array booleano pon a true los números que están repetidos y ya se han comprobado
                    if (j != i) {

                        comprobado[j] = true;

                    }

                }

            }

            //Imprime sólo los principales
            if (!comprobado[i]) {

                //Muestra el resultado de coincidencias
                System.out.println("El número " + arrayEntrada[i] + " se encuentra " + contador + " veces en el array");

            }

        }

    }

    public char[] convierteStringChar(String entrada[]) {

        //Calcula una palabra aleatoria y la devuelves en un array de char               
        int palabraAleatoria = (int) (Math.random() * (((entrada.length-1) - 0) + 1));
                
        char[] res = entrada[palabraAleatoria].toCharArray();

        return res;

    }

    public void ahorcado() {

        Scanner sc = new Scanner(System.in);
        String entrada[] = {"hola","programacion","sistemas","aula","juan"};

        boolean juego = true;

        while (juego) {

            //Convierte el String en un array de char y crea un array 
            //encriptado para ir mostrando el resultado
            Funciones fun = new Funciones();
            char palabraChar[] = fun.convierteStringChar(entrada);
            char palabraEncriptada[] = new char[palabraChar.length];

            //Rellena el array encriptado con asteriscos y deja alguna descubierta para pista
            for (int i = 0; i < palabraEncriptada.length; i++) {

                if (i == 0 || i == palabraChar.length - 1) {

                    palabraEncriptada[i] = palabraChar[i];

                } else {

                    palabraEncriptada[i] = '*';

                }

            }

            //Tenemos 7 intentos para adivinar y el juego termina cuando el usuario decida
            int intentos = 0;

            //Variable para saber cuándo está la palabra descubierta del todo
            int contadorLetra = palabraChar.length - 2;

            //Muestra la pista
            System.out.println("******Juego del ahorcado******");
            System.out.println("Pista de la palabra que tienes que adivinar");
            System.out.println(Arrays.toString(palabraEncriptada));

            do {
                
                //Pregunta una letra para ver si se encuentra y búscala
                System.out.println("Introduce una letra para ver si se encuentra en la palabra:");
                char letraIntroducida = sc.next().charAt(0);

                boolean letraEncontrada = false;

                for (int i = 0; i < palabraChar.length; i++) {

                    //Si encuentra la letra, colócala en el array resultado
                    if (palabraChar[i] == letraIntroducida) {

                        palabraEncriptada[i] = letraIntroducida;
                        letraEncontrada = true;

                    }

                }

                if (letraEncontrada) {

                    System.out.println("La letra introducida se encuentra en la palabra. "
                            + "Te muestro el resultado:");
                    System.out.println(Arrays.toString(palabraEncriptada));
                    contadorLetra--;

                } else {

                    intentos++;
                    System.out.println("La letra introducida no se encuentra en la palabra. "
                            + "Te quedan " + (7 - intentos) + " intentos.");

                }

                //Palabra adivinada. Se acaba el juego
                if (contadorLetra == 0) {
                    System.out.println("Has adivinado la palabra");
                    break;
                }

            } while (intentos < 7);

            //Condición para seguir jugando cuando se adivine la palabra o se acaben los intentos
            System.out.println("¿Quieres seguir jugando? s/n");
            char siNo = sc.next().charAt(0);

            if (siNo == 'n') {

                juego = false;
                System.out.println("Fin del juego");
            }

        }

    }

    public boolean encuentraArray(char array1, char array2) {

        boolean esIgual = false;

        return esIgual;

    }

    public boolean comparaArrayAmbosSentidos(char array1[], char array2[]) {

        boolean contiene = false;

        if (comparaArray(array1, array2) || comparaArrayInverso(array1, array2)) {
            contiene = true;
        }

        return contiene;
    }

    public boolean comparaArray(char array1[], char array2[]) {

        boolean coincide = true;

        //Recorro el array principal para encontrar coincidencias con el secundario de izquierda a derecha
        for (int i = 0; i < array1.length; i++) {

            //Encuentra una coincidencia
            if (array1[i] == array2[0]) {

                //Compara con los elementos contiguos del array principal
                for (int j = 0, aux = i; j < array2.length; j++, aux++) {

                    //Límite de búsqueda. Si quedan menos elementos que el array a buscar, no sigas
                    if (aux < array1.length) {

                        //En cuanto ve un elemento diferente, no es igual, por lo tanto sale de buscar
                        if (array1[aux] != array2[j]) {

                            coincide = false;
                            break;

                        }

                    } else {

                        coincide = false;
                        break;

                    }

                }

            }

        }

        return coincide;

    }

    public boolean comparaArrayInverso(char array1[], char array2[]) {

        boolean coincide = true;

        //Recorro el array principal para encontrar coincidencias con el secundario de derecha a izquierda
        for (int i = array1.length - 1; i >= 0; i--) {

            //Encuentra una coincidencia
            if (array1[i] == array2[0]) {

                //Compara con los elementos contiguos del array principal
                for (int j = 0, aux = i; j < array2.length; j++, aux--) {

                    //Límite de búsqueda. Si quedan menos elementos que el array a buscar, no sigas
                    if (aux >= 0) {

                        //En cuanto ve un elemento diferente, no es igual, por lo tanto sale de buscar
                        if (array1[aux] != array2[j]) {

                            coincide = false;
                            break;

                        }

                    } else {
                        System.out.println("por aquí");
                        coincide = false;
                        break;

                    }

                }

            }

        }

        return coincide;

    }

    /*for (int i = 0; i < 7; i++) {

                System.out.println("Intento " + (i + 1));

                //Pregunta una letra para ver si se encuentra                
                System.out.println("Introduce una letra para ver si se encuentra en la palabra:");
                char letraIntroducida = sc.next().charAt(0);

                for (int j = 0; j < palabraChar.length; j++) {

                    //Comprueba si está
                    if (letraIntroducida == (palabraChar[j])) {

                        palabraEncriptada[j] = letraIntroducida;
                        contadorLetra++;

                    }

                }

                //Condición si encuentra alguna letra o no
                if (contadorLetra > 0) {

                    System.out.println("La letra introducida se encuentra en la palabra. Te muestro"
                            + "las letras que has descubierto");

                    System.out.println(Arrays.toString(palabraEncriptada));

                } else {

                    System.out.println("La letra que has introducido no se encuentra en la palabra");

                }

            }

            //Pregunta para seguir el juego o no
            System.out.println("¿Quieres probar de nuevo? s/n");
            char siNo;
            siNo = sc.next().charAt(0);

            if (siNo == 'n' || siNo == 'N') {

                juego = false;

            }*/
}
