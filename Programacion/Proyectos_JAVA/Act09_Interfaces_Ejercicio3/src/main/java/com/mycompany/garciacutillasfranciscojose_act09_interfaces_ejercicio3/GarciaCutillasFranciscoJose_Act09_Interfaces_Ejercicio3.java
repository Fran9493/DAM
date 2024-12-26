package com.mycompany.garciacutillasfranciscojose_act09_interfaces_ejercicio3;

import clases.Biblioteca;
import clases.Libro;
import clases.Publicacion;
import clases.Revista;

/**
 * Clase principal
 *
 * @author Fran
 */
public class GarciaCutillasFranciscoJose_Act09_Interfaces_Ejercicio3 {

    public static void main(String[] args) {

        Libro l1 = new Libro(1, "El Quijote. Nueva edición", 2016);
        Libro l2 = new Libro(2, "Los pilares de la tierra", 2018);

        Revista r1 = new Revista(3, "Super Pop", 2020, 22);
        Revista r2 = new Revista(4, "Caza y pesca", 2021, 247);

        Publicacion[] arrayPublicaciones = {l1};

        Biblioteca b1 = new Biblioteca(arrayPublicaciones);

        b1.addPublicacion(r1);
        b1.addPublicacion(r2);
        b1.addPublicacion(l2);
        b1.mostrarPublicaciones();

        System.out.println("");

        System.out.println("Publicaciones anteriores a 2016: " + b1.numPublicacionesAnterioresA(2016));
        System.out.println("Publicaciones anteriores a 2020: " + b1.numPublicacionesAnterioresA(2020));
        System.out.println("Publicaciones anteriores a 2022: " + b1.numPublicacionesAnterioresA(2022));

    }
}
