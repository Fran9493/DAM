package com.mycompany.psp14;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class PSP14 {

    public static void main(String[] args) {

        //Variable en la que se va a iniciar el proceso. En este caso va a abrir el cmd y hacer un dir de la carpeta
        //c:\\
        ProcessBuilder pBuilder = new ProcessBuilder("cmd", "/c", "dir", "c:\\");

        try {

            Process p = pBuilder.start(); //Inicia el proceso
            p.waitFor(); //Espera a que termine el proceso
            mostrarResultadoDir(p); //Nos va a mostrar por terminal el resultado del dir

        } catch (IOException | InterruptedException ex) {

            System.out.println("Error: " + ex.getMessage()); //Mensaje de error si falla el comando o el inicio del proceso

        }

    }

    public static void mostrarResultadoDir(Process p) {

        InputStream inS = p.getInputStream();
        int letra;
        try {

            while ((letra = inS.read()) != -1) { //Mientras queden letras por leer sigue imprimiendo por pantalla
                                                //cuando llega a la última devuelve un -1                
                System.out.print((char) letra);

            }

        } catch (IOException ex) {

            System.out.println("Error en la lectura de la letra");

        }

    }

//        ProcessBuilder processBuilder = new ProcessBuilder();
//        processBuilder.command("cmd.exe", "/c", "dir");
//        processBuilder.directory(new File ("c:/prueba/"));
}
