package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Fran
 */
public class Ejercicio04 {

    public static int ejercicio04(String nombreFichero, String cadenaBuscar) throws FileNotFoundException, IOException {

        int salida;
        boolean encontrado = false;
        int posEncontrado = 0;
        int posicion = 0;

        File fichero = new File(nombreFichero);

        FileReader fr = new FileReader(fichero);

        BufferedReader br = new BufferedReader(fr);

        String cadena = br.readLine();

        while (cadena != null) {

            if (cadena.equals(cadenaBuscar)) { //Mejor utilizar contains 

                encontrado = true;
                posEncontrado = posicion + 1;

            }

            posicion++;

            cadena = br.readLine();

        }

        if (!encontrado) {

            salida = -1;

        } else {

            salida = posEncontrado;

        }

        fr.close();
        br.close();

        return salida;

    }

}
