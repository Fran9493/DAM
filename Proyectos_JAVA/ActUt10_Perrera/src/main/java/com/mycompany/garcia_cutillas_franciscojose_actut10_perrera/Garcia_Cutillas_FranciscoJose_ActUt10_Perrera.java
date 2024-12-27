package com.mycompany.garcia_cutillas_franciscojose_actut10_perrera;

import clases.Perrera;
import clases.Perro;
import excepciones.FechaException;
import excepciones.NombreException;
import excepciones.PerreraException;
import excepciones.RazaException;
import java.util.Collections;
import ordenacion.ComparaPerros;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_ActUt10_Perrera {

    public static void main(String[] args) {

        Perrera pe1 = new Perrera("El Olvido", "Calle Mayor, 3");

        try {

            Perro p1 = new Perro(1, "Firulais", "10/05/2023", "bóxer");

            Perro p2 = new Perro(2, "Boo", "21/05/2021", "Pítbull");

            Perro p3 = new Perro(3, "Tobi", "02/09/2019", "Labrador");

            Perro p4 = new Perro(4, "Beethoben", "30/07/2014", "Mastín");

            Perro p5 = new Perro(5, "Tobi", "16/02/2022", "Caniche");

            Perro p6 = new Perro(6, "Jackie", "20/09/2020", "Bodeguero");

            System.out.println("¿Es Perro p2 igual a p1?: " + p2.equals(p1));
            System.out.println("¿Es Perro p5 igual a p5?: " + p5.equals(p5));

            System.out.println("\nInformación del perro p2");
            p2.imprimir();

            System.out.println("\nEdad del perro p4: " + p4.devuelveEdad() + " Años");
            System.out.println("Edad del perro p6: " + p6.devuelveEdad() + " Años");

            pe1.intertaPerro(p3);
            pe1.intertaPerro(p2);
            pe1.intertaPerro(p1);
            pe1.intertaPerro(p5);
            pe1.intertaPerro(p4);

            System.out.println(pe1.intertaPerro(p6));
            System.out.println(pe1);

            System.out.println("\nBorra Perro p2, ¿Es posible?: " + pe1.delPerro(p2));

            System.out.println("Inserta perro p1, ¿Es posible?: " + pe1.intertaPerro(p1));

            ComparaPerros cp = new ComparaPerros();
            Collections.sort(pe1.getPerros(), cp);
            System.out.println("");
            pe1.mostrarInfo();

        } catch (RazaException rEx) {

            System.out.println(rEx.getMessage());

        } catch (FechaException fEx) {

            System.out.println(fEx.getMessage());

        } catch (NombreException nEx) {

            System.out.println(nEx.getMessage());

        } catch (PerreraException perEx) {

            System.out.println(perEx.getMessage());

        }

    }

}
