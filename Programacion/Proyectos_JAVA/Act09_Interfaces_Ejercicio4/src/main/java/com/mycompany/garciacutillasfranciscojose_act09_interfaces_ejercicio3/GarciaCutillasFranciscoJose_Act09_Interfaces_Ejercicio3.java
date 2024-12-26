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
        Libro l3 = new Libro(5, "Cómo aprender a programar y no morir en el intento", 2015);
        Libro l4 = new Libro(6, "100 años de soledad", 2010);

        Revista r1 = new Revista(3, "Super Pop", 2020, 22);
        Revista r2 = new Revista(4, "Caza y pesca", 2021, 247);

        Publicacion[] arrayPublicaciones = {l1, l4};

        Biblioteca b1 = new Biblioteca(arrayPublicaciones);

        b1.addPublicacion(r1);
        b1.addPublicacion(r2);
        b1.addPublicacion(l2);
        b1.addPublicacion(l3);
                
        
        System.out.println("Prestados: " + b1.cuentaPrestados());
        
        System.out.println("\nPresto los libros con código 2 y 1");
        b1.prestarElemento(2);
        b1.prestarElemento(1);
        System.out.println("Prestados: " + b1.cuentaPrestados());
        
        System.out.println("\nIntento volver a prestar el libro con código 2");
        b1.prestarElemento(2);
        System.out.println("Prestados: " + b1.cuentaPrestados());
        
        System.out.println("\nDevuelvo los libros 2 y 1");
        b1.devolverElemento(2);
        b1.devolverElemento(1);
        System.out.println("Prestados: " + b1.cuentaPrestados());
        
        System.out.println("\nVuelvo a prestar 1, 5 y 6");
        b1.prestarElemento(1);
        b1.prestarElemento(5);
        b1.prestarElemento(6);
        System.out.println("Prestados: " + b1.cuentaPrestados());
        
        System.out.println("\nIntento prestar una revista con código 4");
        b1.prestarElemento(4);
        System.out.println("Prestados: " + b1.cuentaPrestados());
        
    }
}
