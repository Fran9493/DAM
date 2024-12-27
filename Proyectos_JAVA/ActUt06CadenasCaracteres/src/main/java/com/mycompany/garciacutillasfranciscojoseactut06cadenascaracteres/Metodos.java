package com.mycompany.garciacutillasfranciscojoseactut06cadenascaracteres;

import java.util.Arrays;

/**
 *
 * @author Fran
 */
public class Metodos {

    public int[] cuentaLetras(String entrada) {

        int resultado[] = new int[5]; //Array que va a devolver el método
        char arrayTemp[] = new char[entrada.length()]; //Array temporal con el que vamos a hacer las operaciones en el método       
        arrayTemp = entrada.toCharArray(); //Convertimos el String de entrada en un array de char

        //Recorremos el array en busca de las vocales y las contamos
        for (int i = 0; i < arrayTemp.length; i++) {

            switch (arrayTemp[i]) {

                case 'a', 'á', 'A', 'Á':

                    resultado[0]++;
                    break;

                case 'e', 'é', 'E', 'É':

                    resultado[1]++;
                    break;

                case 'i', 'í', 'I', 'Í':

                    resultado[2]++;
                    break;

                case 'o', 'ó', 'O', 'Ó':

                    resultado[3]++;
                    break;

                case 'u', 'ú', 'U', 'Ú':

                    resultado[4]++;
                    break;

            }

        }

        return resultado;

    }

    public String concatena(String cadena1, String cadena2, String cadena3) {

        String salida = ""; //Cadena que va a devolver el método

        //Caso de error. Cadenas 1 y 3 menores de 3 caracteres o cadena 2 menor de 2
        if ((cadena1.length() < 3 || cadena2.length() < 2 || cadena3.length() < 3)) {

            salida = "Error, la cadena 1 y 3 no pueden tener menos de tres caracteres y la 2 no puede tener menos de 2.";

            //Si no hay error
        } else {

            salida = cadena1.substring(0, 3) + cadena2.substring(cadena2.length() - 2, cadena2.length())
                    + cadena3.substring(0, 3);

        }

        return salida;

    }

    public char[] arrayCharAleatorio(String cadena1, String cadena2, String cadena3) {

        /*Cadena temporal para realizar las operaciones. Aquí vamos a sacar el resultado de generar la concatenación
        de las tres cadenas, habiendo obtenido de cada una de ellas los caracteres aleatoriamente. Puede darse el caso
        de que no salga ningún carácter de alguna cadena puesto que el aleatorio es entre 0 y longitud de cadena*/
        String temp = cadena1.substring(0, (int) (Math.random() * ((cadena1.length() - 0) + 1)) + 0)
                + cadena2.substring(0, (int) (Math.random() * ((cadena2.length() - 0) + 1)) + 0)
                + cadena3.substring(0, (int) (Math.random() * ((cadena3.length() - 0) + 1)) + 0);

        //Creación del array salida con la longitud de la cadena aleatoria anterior
        char salida[] = new char[temp.length()];

        //Paso de la cadena a un array de char para que lo devuelva el método
        salida = temp.toCharArray();

        return salida;

    }

    public int[] longitudCadena(String arrayEntrada[]) {

        int salida[] = new int[arrayEntrada.length + 1]; //Array de salida
        int longMayor = arrayEntrada[0].length(); //Variable para guardar la longitud mayor
        salida[salida.length - 1] = 0; // Suponemos que el mayor es el del índice 0

        //Recorremos el array para contar la longitud de las cadenas, buscamos la mayor y guardamos su índice
        for (int i = 0; i < arrayEntrada.length; i++) {

            salida[i] = arrayEntrada[i].length();

            if (arrayEntrada[i].length() > longMayor) {

                salida[salida.length - 1] = i;
                longMayor = arrayEntrada[i].length();

            }

        }

        return salida;

    }

    public String[] mitadCadena(String cadenaEntrada) {

        String salida[] = new String[2]; //Array salida

        //Primer elemento del array salida, desde el índice 0 hasta la mitad de la cadena de entrada
        salida[0] = cadenaEntrada.substring(0, cadenaEntrada.length() / 2);

        //Segundo elemento del array salida, desde el índice mitad de cadena de entrada hasta el índice final
        salida[1] = cadenaEntrada.substring(cadenaEntrada.length() / 2, cadenaEntrada.length());

        return salida;

    }

    public char[] cuentaCaracteres(String cadenaEntrada, boolean distingueMayMin) {

        //Array salida
        char salida[] = new char[3];

        //Creamos un array temporal de char para operar con él en el método
        char arrayTemp[] = new char[cadenaEntrada.length()];

        //Pasamos la cadena de entrada a un array de char 
        arrayTemp = cadenaEntrada.toCharArray();

        //Caso en el que distigamos entre mayúsculas y minúsculas        
        if (distingueMayMin) {

            salida[0] = cuentaLetraVocalCons(arrayTemp);
            salida[1] = cuentaVocalMax(arrayTemp);
            salida[2] = cuentaVocalMin(arrayTemp);

            //Sin distinción entre mayúsculas y minúsculas
        } else {

            //Primero pasamos todos los caracteres a minúscula, para buscar después
            for (int i = 0; i < arrayTemp.length; i++) {

                arrayTemp[i] = Character.toLowerCase(arrayTemp[i]);

            }

            salida[0] = cuentaLetraVocalCons(arrayTemp);
            salida[1] = cuentaVocalMax(arrayTemp);
            salida[2] = cuentaVocalMin(arrayTemp);

        }

        return salida;

    }

    //Este método devuelve la letra que más se ha repetido. Si se da el caso de que haya dos letras que se repitan las mismas
    //veces, devuelve la primera que haya visto
    public char cuentaLetraVocalCons(char arrayEntrada[]) {

        //Primeramente suponemos que la letra más repetida, vocal más repetida y menos repetida, va a ser la 
        //primera del array
        char letraRep = arrayEntrada[0];

        //También vamos a usar un contador para saber las veces que se repite cada letra y un contador temporal
        int contadorLetra = 0;
        int conTemp = 0;

        //Recorremos el array de char para contar las letras que más se repiten
        for (int i = 0; i < arrayEntrada.length; i++) {

            //Primero vemos que el caracter sea una letra
            if (Character.isLetter(arrayEntrada[i])) {

                //Recorremos de nuevo para comparar con el índice i
                for (int j = 0; j < arrayEntrada.length; j++) {

                    //Si la letra coincide con la del índice "i" suma al contador temporal
                    if (arrayEntrada[j] == arrayEntrada[i]) {

                        conTemp++;

                    }

                }

                //Si al finalizar la búsqueda está más veces que la anterior, sobreescribe la nueva
                if (conTemp > contadorLetra) {

                    contadorLetra = conTemp;
                    letraRep = arrayEntrada[i];

                }

                //Reinicializamos contador temporal para la siguiente vuelta
                conTemp = 0;

            }

        }

        return letraRep;

    }

    //Este método devuelve la vocal que más se repite de un array de char de entrada
    public char cuentaVocalMax(char arrayEntrada[]) {

        char salida = ' ';

        //Inicializamos las variables al primer valor del array
        salida = arrayEntrada[0];

        //Contadores
        int contVocalMax = 0;
        int conTempMax = 0;

        //Recorremos el array en busca de las vocales
        for (int i = 0; i < arrayEntrada.length; i++) {

            //Tenemos que discriminar sólo vocales
            if (Character.isLetter(arrayEntrada[i]) && esVocal(arrayEntrada[i])) {

                for (int j = 0; j < arrayEntrada.length; j++) {

                    if (arrayEntrada[j] == arrayEntrada[i]) {

                        conTempMax++;

                    }

                }

                if (conTempMax > contVocalMax) {

                    contVocalMax = conTempMax;
                    salida = arrayEntrada[i];

                }

                //Reinicializamos contador
                conTempMax = 0;

            }

        }

        return salida;

    }

    //Este método devuelve la vocal que menos se repite de un array de entrada
    public char cuentaVocalMin(char arrayEntrada[]) {

        char salida = ' ';

        //Creamos un array para guardar las vocales y otro para su conteo
        char vocalesMin[] = {'a', 'e', 'i', 'o', 'u'};
        char vocalesMay[] = {'A', 'E', 'I', 'O', 'U'};
        int numVocalesMin[] = new int[5];
        int numVocalesMay[] = new int[5];

        //Recorremos el array para contar las vocales
        for (int i = 0; i < arrayEntrada.length; i++) {

            //Caso en el que las vocales sean minúsculas
            if (esVocal(arrayEntrada[i]) && Character.isLowerCase(arrayEntrada[i])) {

                switch (arrayEntrada[i]) {

                    case 'a':
                        numVocalesMin[0]++;
                        break;
                    case 'e':
                        numVocalesMin[1]++;
                        break;
                    case 'i':
                        numVocalesMin[2]++;
                        break;
                    case 'o':
                        numVocalesMin[3]++;
                        break;
                    case 'u':
                        numVocalesMin[4]++;
                        break;

                }

                //Caso en el que las vocales sean mayúsculas
            } else if (esVocal(arrayEntrada[i]) && Character.isUpperCase(arrayEntrada[i])) {

                switch (arrayEntrada[i]) {

                    case 'A':
                        numVocalesMay[0]++;
                        break;
                    case 'E':
                        numVocalesMay[1]++;
                        break;
                    case 'I':
                        numVocalesMay[2]++;
                        break;
                    case 'O':
                        numVocalesMay[3]++;
                        break;
                    case 'U':
                        numVocalesMay[4]++;
                        break;

                }

            }

        }

        //Ahora vamos a buscar la que menos se repite
        int contVocMay = 0;
        int contVocMin = 0;
        int indiceMin = 0;
        int indiceMay = 0;

        //Minúsculas
        for (int i = 0; i < numVocalesMin.length; i++) {

            if (contVocMin == 0 && numVocalesMin[i] > 0) {

                contVocMin = numVocalesMin[i];
                indiceMin = i;

            } else if (numVocalesMin[i] < contVocMin && numVocalesMin[i] > 0) {

                contVocMin = numVocalesMin[i];
                indiceMin = i;

            }

        }

        //Mayúsculas
        for (int i = 0; i < numVocalesMay.length; i++) {

            if (contVocMay == 0 && numVocalesMay[i] > 0) {

                contVocMay = numVocalesMay[i];
                indiceMay = i;

            } else if (numVocalesMay[i] < contVocMay) {

                contVocMay = numVocalesMay[i];
                indiceMay = i;

            }

        }

        //Si la vocal que menos se repite es mayúscula
        if (contVocMay < contVocMin && contVocMay > 0) {

            salida = vocalesMay[indiceMay];

            //Si la vocal que menos se repite es minúscula
        } else {

            salida = vocalesMin[indiceMin];

        }

        return salida;
    }

    //Método para saber si un carácter es vocal
    public boolean esVocal(char entrada) {

        char caracter = ' ';
        boolean salida = false;

        //Primero lo pasamos a minúscula
        caracter = Character.toLowerCase(entrada);

        switch (caracter) {

            case 'a', 'e', 'i', 'o', 'u':

                salida = true;
                break;

        }

        return salida;

    }

}
