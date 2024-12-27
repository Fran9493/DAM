package com.mycompany.garciacutillasfranciscojoseactut07clases;

import java.time.LocalDate;
import java.util.Arrays;
import utilidades.Dni;

/**
 *
 * @author Fran
 */
public class GarciaCutillasFranciscoJoseActUt07Clases {

    public static void main(String[] args) {

        //Ejercicio 1
        Punto p1 = new Punto(2, 3);
        Punto p2 = new Punto(-7, 55);
        Punto p3 = new Punto(23, -9);
        Punto pAleatorio = Punto.nuevoPuntoAleatorio();

        System.out.println("Coordenadas de p1");
        p1.imprime();

        p2.setXY(10, -50);
        System.out.println("Coordenadas de p2");
        p2.imprime();

        p3.desplaza(2, 5);
        System.out.println("Coordenadas de p3");
        p3.imprime();

        System.out.println("Distancia: " + p2.distancia(p1));

        System.out.println("Coordenadas punto aleatorio");
        pAleatorio.imprime();

        //Ejercicio 2
        Persona per1 = new Persona("11111111A", "Juan", "Cano", "Fernández", 30);
        Persona per2 = new Persona("22222222B", "Alicia", "Pérez", 17);
        Persona per3 = new Persona("33333333C", "Pepe", "Cantero", "Palazón", 66);

        per1.imprime();
        per2.imprime();
        System.out.println(per2.getNombre() + " es mayor de edad: " + per2.esMayorEdad());
        System.out.println(per3.getNombre() + " es jubilado: " + per3.esJubilado());
        System.out.println("Diferencia de edad entre " + per1.getNombre() + " y " + per2.getNombre() + " es: " + per2.diferenciaEdad(per1));
        System.out.println("¿" + per2.getNombre() + " es mayor que " + per3.getNombre() + "? " + per2.esMayor(per3));
        per1.setNombre("Antonio");
        per1.setPrimerApellido("Martínez");
        per1.setSegundoApellido("Guirao");
        per1.setEdad(55);
        per1.imprime();

        //Ejercicio 3
        Articulo a1 = new Articulo("Colcha", 24.99, Articulo.TipoIva.GENERAL);
        Articulo a2 = new Articulo("Pan", 0.90, Articulo.TipoIva.SUPERREDUCIDO);
        Articulo a3 = new Articulo("Pepsi ", 0.50, Articulo.TipoIva.REDUCIDO);

        a1.muestraInformacion();
        System.out.println("Precio con iva de " + a1.getNombre() + " :" + a1.getPVP());
        System.out.println("Precio con descuento de " + a1.getNombre() + " :" + a1.getPVPDescuento(10));

        System.out.println("Cambio nombre y precio del " + a2.getNombre());
        a2.setNombre("Huevos");
        a2.setPrecioSinIva(2.15);
        a2.muestraInformacion();

        System.out.println("Precio sin iva de " + a3.getNombre() + ": " + a3.getPrecioSinIva());

        //Ejercicio 4
        Articulo arrayAr[] = {a1, a2, a3};
        int cantidades[] = {1, 2, 5};

        Compra c1 = new Compra(per1, arrayAr, cantidades, LocalDate.now());
        c1.mostrarInfo();

    }
}
