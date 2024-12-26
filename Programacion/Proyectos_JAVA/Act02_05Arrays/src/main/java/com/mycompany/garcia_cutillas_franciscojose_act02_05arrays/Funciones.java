package com.mycompany.garcia_cutillas_franciscojose_act02_05arrays;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author fran
 */
public class Funciones {

    public int[] creaArrayAleatorio(int min, int max, int longitud) {

        int arraySalida[] = new int[longitud];
        int numAleatorio = 0;
        boolean arrayCompleto = false;
        int ind = 0;

        //Condiciones de error
        if (min > max) {

            System.out.println("El valor mínimo del array no puede ser mayor que el del máximo");
            arraySalida = null;

        } else if (max - min < longitud - 1) {

            System.out.println("El rango de valores no es suficiente para crear un array "
                    + "sin que se repitan valores");
            arraySalida = null;

            //Proceso si no hay errores
        } else {

            //Genera número aleatorio y lo guardas en el índice 0
            numAleatorio = (int) (Math.random() * ((max - min) + 1)) + min;
            arraySalida[0] = numAleatorio;

            //Proceso de relleno del array para el resto de índices
            for (int i = 1; i < arraySalida.length; i++) {

                boolean diferente = false;

                //Busca número aleatorio y hasta que no sea diferente de los que ya hay no guardes
                do {

                    numAleatorio = (int) (Math.random() * ((max - min) + 1)) + min;

                    for (int j = 0; j < i; j++) {

                        if (arraySalida[j] == numAleatorio) {

                            break;

                        } else if (arraySalida[j] != numAleatorio && (j == i - 1)) {

                            arraySalida[i] = numAleatorio;
                            diferente = true;

                        }

                    }

                } while (!diferente);

            }

        }

        return arraySalida;

    }

    public int[] aleatoriosFecha(int min, int max) {

        int arraySalida[] = new int[23];

        //Creación del array aleatorio de 20 dígitos
        int array20[] = creaArrayAleatorio(min, max, 20);

        //Condición si el método anterior no devuelve error
        if (array20 != null) {

            //Copia del array de 20 aleatorio al array salida
            for (int i = 0; i < array20.length; i++) {

                arraySalida[i] = array20[i];

            }

            //Addición de la fecha al array de 23
            Calendar fecha = Calendar.getInstance();
            int dia_actual = fecha.get(Calendar.DAY_OF_MONTH);
            int mes_actual = fecha.get(Calendar.MONTH);
            int año_actual = fecha.get(Calendar.YEAR);

            arraySalida[arraySalida.length - 3] = dia_actual;
            arraySalida[arraySalida.length - 2] = mes_actual + 1;
            arraySalida[arraySalida.length - 1] = año_actual;

            //Si el método devuelve null
        } else {

            arraySalida = null;

        }

        return arraySalida;

    }

    public void menuComida() {

        int numPersonas = 0;

        //Creación variable Scanner para introducir los datos
        Scanner sc = new Scanner(System.in);

        //Pregunta cuántas personas van a comer
        System.out.println("¿Cuántas personas van a comer?");
        numPersonas = sc.nextInt();

        //Array en el que se va a guardar los nombres de los comensales
        String nombres[] = new String[numPersonas];

        //Array en el que se va a guardar el menú elegido por cada comensal
        int menu[] = new int[numPersonas];
        int sumaMenu[] = {0, 0, 0, 0};

        //Pregunta nombre y menú elegido por el comensal
        for (int i = 0; i < nombres.length; i++) {

            System.out.println("Introduce el nombre del comensal " + (i + 1) + ":");
            nombres[i] = sc.next();

            //Pide el número de menú y sólo permite que se introduzca 1, 2, 3 o 4
            boolean menuCorrecto = false;

            do {

                System.out.println("Elige menú 1, 2, 3 o 4:");
                menu[i] = sc.nextInt();

                if (menu[i] > 0 && menu[i] <= 4) {

                    menuCorrecto = true;

                    //Suma la cantidad de menús elegidos
                    int auxSuma = menu[i] - 1;
                    sumaMenu[auxSuma]++;

                } else {

                    System.out.println("Sólo es posible elegir entre el menú 1, 2, 3 o 4");

                }

            } while (!menuCorrecto);
        }

        //Cálculo del menú más elegido
        int menuElegido[] = calculaMayor(sumaMenu);

        System.out.println("El menú más elegido ha sido el " + menuElegido[1]);
        System.out.println("Ha sido elegido por " + menuElegido[0] + " personas:");
        System.out.println("Las personas que han elegido el menú " + menuElegido[1] + " son:");

        for (int i = 0; i < menu.length; i++) {

            if (menu[i] == menuElegido[1]) {

                System.out.println(nombres[i]);

            }

        }

    }

    //Este método se le introduce un array de enteros y devuelve un array de enteros en el que
    //el primer índice indica el mayor y en el segundo el índice en el que se encuentra.
    //En caso de empate, devuelve el de índice menor
    public int[] calculaMayor(int arrayEntrada[]) {

        int arraySalida[] = new int[2];

        int mayor = arrayEntrada[0];
        int indice = 0;

        //Busca el mayor y guarda su índice. En el caso de encontrar otro número igual,
        //al usar el > y no >= siempre se va a quedar guardado el número de índice menor, 
        //aunque encuentre otro igual
        for (int i = 1; i < arrayEntrada.length; i++) {

            if (arrayEntrada[i] > mayor) {

                mayor = arrayEntrada[i];
                indice = i;

            }

        }

        //Rellenado del array de salida        
        arraySalida[0] = mayor; //número de personas que eligen el menú
        arraySalida[1] = indice + 1; //Con esto ya tenemos el menú elegido ganador

        return arraySalida;

    }

    public double calificacionFinal(double calEx, double calActividades[],
            int porcActividades[], int pondEx, int pondAc) {

        double calFinal = 0.0;

        //Calificación final examen
        double calFinEx = (calEx * ((double) pondEx / 100));

        //Suma ponderaciones totales
        int sumaPondFin = pondEx + pondAc;
        int sumaPondAct = 0;
        boolean errorCalAct = false;

        //Caso en el que la nota del examen sea negativa o mayor de 10
        if (calEx < 0 || calEx > 10) {

            System.out.println("La calificación del examen debe de ser entre 0 y 10");
            calFinal = -1;

        }

        //Busca si hay algún error en las calificaciones de las actividades y sus ponderaciones
        //Caso en el que no se introduzca el mismo número de calificaciones que de ponderaciones de las mismas
        if (calActividades.length != porcActividades.length) {

            System.out.println("Debes introducir el mismo número de calificaciones de "
                    + "actividades, como sus respectivas ponderaciones");
            calFinal = -1;

            //Si no se cumple lo de arriba, comprueba que las calificaciones están entre 0 y 10
        } else {

            for (int i = 0; i < calActividades.length; i++) {

                if (calActividades[i] < 0 || calActividades[i] > 10) {

                    System.out.println("La nota de las calificaciones debe ser entre 0 y 10");
                    calFinal = -1;
                    break;

                }

            }

        }

        //Caso en el que la suma de la ponderación de las actividades sea mayor o menor de 100
        for (int i = 0; i < porcActividades.length; i++) {

            sumaPondAct += porcActividades[i];

        }

        if (sumaPondAct > 100 || sumaPondAct < 100) {

            System.out.println("La suma de la ponderación de las actividades debe ser 100");
            calFinal = -1;

        }

        //Caso en el que la suma de la ponderación final sea mayor o menor de 100
        if (sumaPondFin > 100 || sumaPondFin < 100) {

            System.out.println("La suma de las ponderaciones finales debe ser 100");
            calFinal = -1;

        }

        //Cálculo de la calificación final de las actividades
        if (calFinal != -1) {

            //Notas actividades ya ponderadas
            double calPond[] = new double[calActividades.length];

            for (int i = 0; i < calActividades.length; i++) {

                calPond[i] = calActividades[i] * ((double) porcActividades[i] / 100);

            }

            //Nota final actividades
            double calFinAc = 0.0;

            for (int i = 0; i < calPond.length; i++) {

                calFinAc += calPond[i];

            }

            //Calificación final examen + actividades
            calFinal = calFinEx + (calFinAc * ((double) pondAc / 100));

        }

        return calFinal;

    }

    public void juegoAciertaNum() {

        boolean finJuego = false;
        int contadorJuego = 0;

        //El juego se ejecutará hasta que los jugadores decidan no seguir jugando
        do {

            //Genera array aleatorio de longitud 10 sin repeticiones
            int numAdivinar[] = creaArrayAleatorio(1, 50, 10);

            //Condición para preguntar primero a un jugador u otro            
            boolean jugPrincipal = true;//Si está a true el principal es el jugador 1
            int jugador1[] = new int[5];
            int jugador2[] = new int[5];

            if (contadorJuego % 2 == 0) {

                System.out.println("****Jugador 1****");
                jugador1 = pide5Num();

                System.out.println("****Jugador 2****");
                jugador2 = pide5Num();

                contadorJuego++;

            } else {

                jugPrincipal = false;//Jugador principal el jugador 2

                System.out.println("****Jugador 2****");
                jugador2 = pide5Num();

                System.out.println("****Jugador 1****");
                jugador1 = pide5Num();

                contadorJuego++;

            }

            //Muestra arrays de jugadores y el aleatorio
            System.out.println("jugador 1 ->" + Arrays.toString(jugador1));
            System.out.println("jugador 2 ->" + Arrays.toString(jugador2));
            System.out.println("Array generado ->" + Arrays.toString(numAdivinar));

            //Comprobar aciertos de cada jugador
            int acJugador1 = 0;
            int acJugador2 = 0;

            acJugador1 = compruebaCoincidencias(jugador1, numAdivinar);
            acJugador2 = compruebaCoincidencias(jugador2, numAdivinar);

            System.out.println("Aciertos jugador 1: " + acJugador1);
            System.out.println("Aciertos jugador 2: " + acJugador2);

            //Determina el jugador ganador
            if (acJugador1 > acJugador2) {

                System.out.println("Ganador -> jugador 1");

            } else if (acJugador1 < acJugador2) {

                System.out.println("Ganador -> jugador 2");

                //En caso de empate, gana el jugador principal
            } else if (acJugador1 == acJugador2) {

                if (acJugador1 == 0) {

                    System.out.println("Ningún jugador ha acertado");

                } else if (jugPrincipal) {

                    System.out.println("Ganador jugador -> 1");

                } else if (!jugPrincipal) {

                    System.out.println("Ganador jugador -> 2");

                }

            }

            //Condición para finalizar el juego
            String jugar = "";

            do {

                System.out.println("¿Deseas seguir jugando? (s/n)");
                Scanner sc = new Scanner(System.in);
                jugar = sc.next();

                //Sólo se permite contestar con s/n, de lo contrario indica que no es correcto
                //y vuelve a preguntar hasta que se escriba correctamente
                if (jugar.equals("n") || jugar.equals("N")) {

                    finJuego = true;
                    break;

                } else if (jugar.equals("S") || jugar.equals("s")) {

                    break;

                } else {

                    System.out.println("Sólo se permite contestar con s/n");

                }

            } while (!"n".equals(jugar) || !"N".equals(jugar)
                    || !"S".equals(jugar) || !"s".equals(jugar));

        } while (!finJuego);

    }

    //Este método te pide 5 números en un rango del 1 al 50 y los devuelve en un array
    public int[] pide5Num() {

        int arraySalida[] = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce 5 números enteros del 1 al 50");

        for (int i = 0; i < arraySalida.length; i++) {

            boolean numCorrecto = false;

            do {

                System.out.println("Número " + (i + 1));
                arraySalida[i] = sc.nextInt();

                if (arraySalida[i] > 0 && arraySalida[i] <= 50) {

                    numCorrecto = true;

                } else {

                    System.out.println("Debes introducir un número del 1 al 50");

                }

            } while (!numCorrecto);

        }

        return arraySalida;
    }

    //Este método nos permite saber si los números del array 1 están contenidos en el array 2
    //y devuelve los aciertos
    public int compruebaCoincidencias(int array1[], int array2[]) {

        int aciertos = 0;

        //Recorre array del jugador 
        for (int i = 0; i < array1.length; i++) {

            //Recorre array aleatorio buscando coincidencias
            for (int j = 0; j < array2.length; j++) {

                if (array1[i] == array2[j]) {

                    aciertos++;//Si hay alguna coincidencia, añade acierto al jugador 
                    break; //En este caso no haría falta porque no se repite ningún número
                    //Pero en el caso de que se repitiera, lo contaría dos veces

                }

            }

        }

        return aciertos;

    }

    public void ahorcado() {

        Scanner sc = new Scanner(System.in);

        String entrada[] = {"hola", "programacion", "sistemas", "aula", "juan"};

        boolean juego = true;

        System.out.println("******Juego del ahorcado******");

        while (juego) {

            //Genera palabra aleatoria
            char palabraAleatoria[] = convierteStringChar(entrada);

            //Encripta la palabra
            char palabraEncriptada[] = encriptaArray(palabraAleatoria);

            //Tenemos 7 intentos para adivinar y el juego termina cuando el usuario decida
            int intentos = 0;

            //Variable para saber cuándo está la palabra descubierta del todo
            int contadorLetra = cuentaLetras(palabraEncriptada);

            //Muestra la pista            
            System.out.println("Pista de la palabra que tienes que adivinar");
            System.out.println(Arrays.toString(palabraEncriptada));

            do {

                //Pregunta una letra para ver si se encuentra y búscala
                System.out.println("Introduce una letra para ver si se encuentra en la palabra:");
                char letraIntroducida = sc.next().charAt(0);

                boolean letraEncontrada = false;//Variable para determinar si se encuentra la letra en la palabra

                for (int i = 0; i < palabraAleatoria.length; i++) {

                    //Si encuentra la letra, colócala en el array resultado
                    if (letraIntroducida == palabraAleatoria[i]) {

                        palabraEncriptada[i] = letraIntroducida;
                        letraEncontrada = true;

                    }

                }

                //Muestra cómo quedaría el array después y resta uno al contador de letras por descubrir
                if (letraEncontrada) {

                    System.out.println("La letra introducida se encuentra en la palabra. "
                            + "Te muestro el resultado:");
                    System.out.println(Arrays.toString(palabraEncriptada));
                    contadorLetra = cuentaLetras(palabraEncriptada);//Calcula las letras que quedan

                    //Si no se encuentra la letra, suma un intento y muestra gráficamente
                } else {

                    intentos++;
                    System.out.println("La letra introducida no se encuentra en la palabra. "
                            + "Te quedan " + (7 - intentos) + " intentos.");
                    muñeco(intentos);

                }

                //Palabra adivinada. Se acaba el juego
                if (contadorLetra == 0) {

                    System.out.println("Has adivinado la palabra");
                    break;

                }

            } while (intentos < 7 || contadorLetra == 0);

            //Condición para seguir jugando cuando se adivine la palabra o se acaben los intentos
            boolean respuestaCorrecta = false;

            do {

                System.out.println("¿Quieres seguir jugando? s/n");

                char respuesta = sc.next().charAt(0);

                switch (respuesta) {

                    case 'n', 'N' -> {
                        System.out.println("Fin del juego");
                        juego = false;
                        respuestaCorrecta = true;
                    }

                    case 's', 'S' -> {
                        System.out.println("**Nueva palabra**");
                        respuestaCorrecta = true;
                    }

                    default ->
                        System.out.println("Debes elegir sólo s/n");
                }

            } while (!respuestaCorrecta);

        }

    }

    //Este método recibe un array de String y devuelve una de esas palabras aletatoriamente en forma de
    //array de char
    public char[] convierteStringChar(String entrada[]) {

        int palabraAleatoria = (int) (Math.random() * (((entrada.length - 1) - 0) + 1));

        char[] res = entrada[palabraAleatoria].toCharArray();

        return res;

    }

    //Método para encriptar un array de char salvo primera y última letra
    //si alguna letra de la palabra contiene la primera o la última también es mostrada
    public char[] encriptaArray(char entrada[]) {

        char arraySalida[] = new char[entrada.length];

        //Guarda primera y última letra para buscar coincidencias en el array
        arraySalida[0] = entrada[0];
        arraySalida[entrada.length - 1] = entrada[entrada.length - 1];

        //Recorre el array y si encuentras una letra igual que la primera o la última,
        //la muestras. De lo contrario la encriptas
        for (int i = 1; i < entrada.length - 1; i++) {

            if (entrada[i] == arraySalida[0] || entrada[i] == arraySalida[entrada.length - 1]) {

                arraySalida[i] = entrada[i];

            } else {

                arraySalida[i] = '*';

            }

        }

        return arraySalida;

    }

    //Método para contar las letras que hay que adivinar
    public int cuentaLetras(char entrada[]) {

        int letras = 0;

        for (int i = 0; i < entrada.length; i++) {

            if (entrada[i] == '*') {

                letras++;

            }

        }

        return letras;

    }

    //Método para mostrar gráficamente el muñeco del ahorcado
    public void muñeco(int intentos) {

        switch (intentos) {

            case 0:
                System.out.println("***************");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("******");
                break;

            case 1:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("******");
                break;

            case 2:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*           *   *");
                System.out.println("*             *");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("******");
                break;

            case 3:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*           *   *");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("******");
                break;

            case 4:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*           *   *");
                System.out.println("*             *");
                System.out.println("*           ***");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("******");
                break;

            case 5:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*           *   *");
                System.out.println("*             *");
                System.out.println("*           *****");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*");
                System.out.println("*");
                System.out.println("*");
                System.out.println("******");
                break;

            case 6:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*           *   *");
                System.out.println("*             *");
                System.out.println("*           *****");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*            *");
                System.out.println("*           *");
                System.out.println("*");
                System.out.println("******");
                break;

            case 7:
                System.out.println("***************");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*           *   *");
                System.out.println("*             *");
                System.out.println("*           *****");
                System.out.println("*             *");
                System.out.println("*             *");
                System.out.println("*            * *");
                System.out.println("*           *   *");
                System.out.println("*");
                System.out.println("******     Muerto");
                break;

        }

    }

    //Este método devuelve true si el array2 está contenido en el 1 en ambos sentidos
    public boolean arrayContenido(char array1[], char array2[]) {

        boolean salida = false;

        if (array1.length < array2.length) {

            System.out.println("El array 2 es más grande que el 1, por lo tanto no es posible"
                    + "buscar elementos contenidos");

            salida = false;

        } else {

            boolean derechaIzquierda = compruebaArray(array1, array2);
            boolean izquierdaDerecha = compruebaArrayInverso(array1, array2);

            //Devuelve true si cualquiera de las dos condiciones es true
            if (derechaIzquierda || izquierdaDerecha) {
                salida = true;
            }
            
        }
        return salida;

    }

    //Este método recorre el array1 de izquierda a derecha y comprueba si el array2 está contenido
    public boolean compruebaArray(char array1[], char array2[]) {

        boolean salida = false;

        //Recorre el array1 en busca de la primera coincidencia con el elemento 0 del array2 
        //Busca hasta que exista la posibilidad de que el array2 esté contenido en el array1
        for (int i = 0; i < array1.length - (array2.length - 1); i++) {

            //Caso en el que encuentra coincidencia en el primer índice del array2
            if (array1[i] == array2[0]) {

                //Recorre array secundario y comprueba que los siguientes están en el principal
                for (int j = 1; j < array2.length; j++) {

                    if (array1[i + j] != array2[j]) {

                        salida = false;

                    } else {

                        salida = true;

                    }

                }

            }

        }

        return salida;

    }

    //Este método recorre el array1 de derecha a izquierda y comprueba si está contenido el array2
    public boolean compruebaArrayInverso(char array1[], char array2[]) {

        boolean salida = false;

        //Recorre el array1 en sentido inverso en busca de la primera coincidencia con el elemento 0 del array2
        //Busca hasta que exista la posibilidad de que el array2 esté contenido en el array1
        for (int i = array1.length - 1; i >= array2.length - 1; i--) {

            //Caso en el que encuentra coincidencia en el primer índice del array2
            if (array1[i] == array2[0]) {

                //Recorre array secundario y comprueba que los siguientes están en el principal
                for (int j = 1; j < array2.length; j++) {

                    if (array1[i - j] != array2[j]) {

                        salida = false;

                    } else {

                        salida = true;

                    }

                }

            }

        }

        return salida;

    }

}
