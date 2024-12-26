package com.mycompany.garcia_cutillas_franciscojose_actut10_perrera;

import clases.Articulo;
import clases.Bolso;
import clases.Tienda;
import clases.Zapato;
import excepciones.ArticuloException;
import excepciones.FechaException;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_ActUt10_Tienda {

    public static void main(String[] args) {

        try {
            
            Zapato z1 = new Zapato("1", "Zapato boda", "Piel", "Negro", 84.99, 5, 43, "Formal");
            Zapato z2 = new Zapato("2", "Zapato estándar", "Polipiel", "Marrón", 39.99, 50, 41, "Casual");

            z2.mostrarInfo();

            Bolso b1 = new Bolso("23", "Bolso beige", "Esparto", "Marrón", 19.99, 10, "Bomba y Loli", "Fiesta");
            Bolso b2 = new Bolso("24", "Bolso piel", "Polipiel", "Rojo", 59.99, 3, "Adidas", "Mochila");

            System.out.println("");
            b1.mostrarInfo();
            System.out.println("");
            System.out.println("Total stock bolso con código " + b1.getCodigo()+ ": " + b1.totalValor() + " Euros");
            
            ArrayList <Articulo> articulos = new ArrayList <> ();
            
            articulos.add(z1);
            articulos.add(z2);
            articulos.add(b1);
            articulos.add(b2);
            
            
            Tienda t1 = new Tienda ("Boutique Archena", "23/05/2023", articulos);
            System.out.println("");
            t1.muestraInfo();
            System.out.println("");
            System.out.println("Valor del género de la tienda: " + t1.valorTienda() + " Euros");
          
             
        } catch (ArticuloException aEx) {

            System.out.println(aEx.getMessage());

        } catch (FechaException fEx) {
            
            System.out.println(fEx.getMessage());
            
        }
                  
    }
    
}
