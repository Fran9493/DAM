package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Ejercicio05 {

    public static void ejercicio05() {

        String ficheroPalabras = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio5.txt";

        int numIntentos = 3;
        int aciertos = 0;
        boolean finJuego = false;

        //Juega mientras tengas intentos o aciertes 4 seguidas
        do {

            try {

                boolean acierta = mostrarPalabraEs(ficheroPalabras);

                if (acierta) {

                    aciertos++;

                } else {

                    aciertos = 0;
                    numIntentos--;

                }

            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            if (aciertos == 4 || numIntentos == 0) {

                finJuego = true;

            }

        } while (!finJuego);

        if (aciertos == 4) {

            System.out.println("¡Enhorabuena, has ganado!");

        } else {

            System.out.println("Has agotado los intentos. Más suerte la próxima vez");

        }

    }

    //Método para mostrar una palabra en español(Mejor desordenar con Collections.shuffle
    private static boolean mostrarPalabraEs(String ficheroPalabras) throws FileNotFoundException, IOException {

        boolean correcto = false;
        int numPalabras = contarPalabraEs(ficheroPalabras);

        //Aleatorio para mostrar una palabra en español aleatoriamente
        int aleatorio = (int) (Math.floor(Math.random() * (numPalabras - 1 + 1)));

        //Usa el siguiente fichero
        File fichero = new File(ficheroPalabras);

        //Leo fichero
        FileReader fr = new FileReader(fichero);

        //Guardo en un buffer
        BufferedReader br = new BufferedReader(fr);

        String[] palabraElegida = new String[2];

        String caracter;

        for (int i = 0; i <= aleatorio; i++) {

            caracter = br.readLine();
            palabraElegida = (caracter.split("\t"));

        }
        
        fr.close();
        br.close();

        //Mostrar la palabra al usuario
        System.out.println("Indica cómo sería la traducción de " + palabraElegida[0] + " en inglés");

        //Entrada del usuario
        Scanner sc = new Scanner(System.in);
        String palabraIngles = sc.nextLine();

        if (palabraIngles.equalsIgnoreCase(palabraElegida[1])) {

            correcto = true;

        }

        return correcto;

    }

    //Método para contar las palabras del fichero
    private static int contarPalabraEs(String ficheroPalabras) throws FileNotFoundException, IOException {

        int numPalabras = 0;

        //Fichero en el que se va a buscar las palabras
        File fichero = new File(ficheroPalabras);

        //Leo fichero
        FileReader fr = new FileReader(fichero);

        //Guardo en un buffer
        BufferedReader br = new BufferedReader(fr);

        String caracter = br.readLine();

        while (caracter != null) {

            caracter = br.readLine();

            numPalabras++;

        }
        
        fr.close();
        br.close();

        return numPalabras;

    }

}
