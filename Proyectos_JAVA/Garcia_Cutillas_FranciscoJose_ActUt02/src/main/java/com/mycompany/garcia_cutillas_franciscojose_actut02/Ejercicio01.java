package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fran
 */
public class Ejercicio01 {

    public static void metodoEj1(String ruta, ArrayList<String> cadena, char ordenacion) throws IOException {

        boolean paramOrdCorrecto = false;

        //Comprobación de que el parámetro de ordenación es correcto. Si es correcto ordena según parámetro de ordenación
        if (ordenacion == 'A') {

            Collections.sort(cadena);
            paramOrdCorrecto = true;

        } else if (ordenacion == 'D') {

            Collections.sort(cadena, Collections.reverseOrder());
            paramOrdCorrecto = true;
            
            

        } else {

            System.out.println("Error: En el parámetro de ordenación sólo es posible escribir 'A' o 'D'.");

        }

        //Si el parámetro de ordenación es correcto, crea fichero si no existe y escribe las cadenas pasadas por parámetro
        if (paramOrdCorrecto) {

            File fichero = new File(ruta);

            if (!fichero.exists()) {

                fichero.createNewFile();

            }

            FileWriter fw = new FileWriter(fichero);

            for (String cad : cadena) {

                fw.write(cad);
                fw.write("\n");

            }

            fw.close();

        }

    }

}
