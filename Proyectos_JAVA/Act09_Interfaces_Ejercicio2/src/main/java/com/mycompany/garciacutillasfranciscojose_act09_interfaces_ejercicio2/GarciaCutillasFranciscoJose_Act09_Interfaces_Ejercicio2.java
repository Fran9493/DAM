package com.mycompany.garciacutillasfranciscojose_act09_interfaces_ejercicio2;

import clases.BarajaEs;
import clases_aux.ComparaCartaNum;
import clases_aux.ComparaCartaPaloNum;
import java.util.Arrays;

/**
 * Clase principal
 *
 * @author Fran
 */
public class GarciaCutillasFranciscoJose_Act09_Interfaces_Ejercicio2 {

    public static void main(String[] args) {

        //Genera un array de 10 elementos y rellena con cartas aleatorias
        BarajaEs[] arrayCartas = new BarajaEs[10];

        for (int i = 0; i < arrayCartas.length; i++) {

            arrayCartas[i] = BarajaEs.generaCarta();

        }

        //Ordena el array aleatorio por palo y número
        ComparaCartaPaloNum ccpn = new ComparaCartaPaloNum();
        Arrays.sort(arrayCartas, ccpn);

        System.out.println("\n**Cartas ordenadas por palo y número**");
        for (int i = 0; i < arrayCartas.length; i++) {

            System.out.println(arrayCartas[i]);

        }

        //Ordena el array aleatorio por número
        ComparaCartaNum ccn = new ComparaCartaNum();
        Arrays.sort(arrayCartas, ccn);

        System.out.println("\n**Cartas ordenadas por número**");
        for (int i = 0; i < arrayCartas.length; i++) {

            System.out.println(arrayCartas[i]);

        }

    }
}
