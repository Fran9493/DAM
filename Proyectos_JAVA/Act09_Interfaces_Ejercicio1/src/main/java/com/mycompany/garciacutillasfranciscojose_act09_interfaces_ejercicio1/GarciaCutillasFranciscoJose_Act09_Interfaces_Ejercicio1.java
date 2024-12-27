package com.mycompany.garciacutillasfranciscojose_act09_interfaces_ejercicio1;

import clases.Futbolista;
import clases_aux.ComparaFutbolistaEdad;
import clases_aux.ComparaFutbolistaNombre;
import java.util.Arrays;

/**
 *
 * @author Fran
 */
public class GarciaCutillasFranciscoJose_Act09_Interfaces_Ejercicio1 {

    public static void main(String[] args) {

        Futbolista f1 = new Futbolista("11111111A", "Pepe", 22, 3);
        Futbolista f2 = new Futbolista("22222222B", "Antonio", 19);
        Futbolista f3 = new Futbolista("63333333C", "Paula", 22);
        Futbolista f4 = new Futbolista("44444444D", "Ana", 17, 11);
        Futbolista f5 = new Futbolista("55111111E", "Zinedine", 19, 6);
        Futbolista f6 = new Futbolista("11111221F", "Xavi", 29);

        Futbolista[] arrayFutbolistas = {f6, f3, f2, f5, f1, f4};
        Arrays.sort(arrayFutbolistas);

        System.out.println("\nFutbolistas ordenados por DNI");

        for (int i = 0; i < arrayFutbolistas.length; i++) {

            System.out.println(arrayFutbolistas[i]);

        }

        ComparaFutbolistaNombre cfn = new ComparaFutbolistaNombre();
        Arrays.sort(arrayFutbolistas, cfn);

        System.out.println("\nFutbolistas ordenados por nombre");

        for (int i = 0; i < arrayFutbolistas.length; i++) {

            System.out.println(arrayFutbolistas[i]);

        }

        ComparaFutbolistaEdad cfe = new ComparaFutbolistaEdad();
        Arrays.sort(arrayFutbolistas, cfe);

        System.out.println("\nFutbolistas ordenados por edad");

        for (int i = 0; i < arrayFutbolistas.length; i++) {

            System.out.println(arrayFutbolistas[i]);

        }

    }
}
