package com.mycompany.garcia_cutillas_franciscojose_actut02;


import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_ActUt02 {

    public static void main(String[] args) {

        //ejercicio01();
        //ejercicio02();
        //ejercicio03();
        //ejercicio04();
        //ejercicio05();
        //ejercicio06();
        //ejercicio07();
        //ejercicio08();
        //ejercicio09();
        //ejercicio10();
        ejercicio11();

    }

    public static void ejercicio01() {

        String ruta = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio1.txt";
        ArrayList<String> cadena = new ArrayList<>();
        cadena.add("Hola");
        cadena.add("Adiós");
        cadena.add("Fran");
        cadena.add("Acceso a datos");
        char ordenacion = 'D';

        try {
            Ejercicio01.metodoEj1(ruta, cadena, ordenacion);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public static void ejercicio02() {

        String rutaDirectorio = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02";

        String nombreFichero = "\\Ejercicio2.txt";

        try {

            Ejercicio02.ejercicio02(rutaDirectorio + nombreFichero);

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public static void ejercicio03() {

        String rutaDirectorio = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02";

        String nombreFichero = "\\Ejercicio3.txt";

        try {

            Ejercicio03.ejercicio03(rutaDirectorio + nombreFichero);

        } catch (IOException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

    }

    public static void ejercicio04() {

        String rutaDirectorio = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02";

        String nombreFichero = "\\Ejercicio4.txt";

        String cadenaBuscar = "hol";

        try {

            int posicion = Ejercicio04.ejercicio04(rutaDirectorio + nombreFichero, cadenaBuscar);

            if (posicion != -1) {

                System.out.println("La posición de " + cadenaBuscar + " es: " + posicion);

            } else {

                System.out.println("La cadena no se encuentra en el fichero");

            }

        } catch (IOException ex) {

            System.out.println("Error: " + ex.getMessage());
        }

    }
    
    public static void ejercicio05(){
        
        Ejercicio05.ejercicio05();
        
    }
    
    public static void ejercicio06(){
        
        Ejercicio06.ejercicio06();
        
    }
    
    public static void ejercicio07(){
        
        Ejercicio07.ejercicio07();
        
    }
    
    public static void ejercicio08(){
        
        Ejercicio08.ejercicio08();
        
    }
    
    public static void ejercicio09(){
        
        Ejercicio09.ejercicio09();
        
    }
    
    public static void ejercicio10(){
        
        Ejercicio10.ejercicio10();
        
    }
    
    public static void ejercicio11(){
        
        Ejercicio11.ejercicio11();
        
    }
    
}
