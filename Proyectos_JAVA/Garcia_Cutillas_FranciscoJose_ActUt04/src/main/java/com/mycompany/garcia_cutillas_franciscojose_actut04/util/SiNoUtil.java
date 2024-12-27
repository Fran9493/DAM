package com.mycompany.garcia_cutillas_franciscojose_actut04.util;

/**
 *
 * @author Fran
 */
public class SiNoUtil {

    public static boolean comprobarSiNo(String entrada) {

        boolean correcto = false;

        if (entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")) {

            correcto = true;
            return correcto;

        }

        return correcto;

    }

}
