package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Ejercicio03 {

    public static void ejercicio03(String nombreFichero) throws IOException {

        String cadenaCorreo;

        File fichero = new File(nombreFichero);

        FileWriter fw = new FileWriter(fichero);

        if (!fichero.exists()) {

            fichero.createNewFile();

        } else {

            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce el destinatario del correo: ");
            cadenaCorreo = sc.nextLine() + "\t";

            System.out.println("Introduce el asunto del correo: ");
            cadenaCorreo += sc.nextLine() + "\t";

            System.out.println("Introduce el cuerpo del correo: ");
            cadenaCorreo += sc.nextLine();

            fw.write(cadenaCorreo);
            
        }

        fw.close();
        
        mostrarCorreo(fichero);

    }
    
    public static void mostrarCorreo(File fichero) throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader(fichero);
        
        BufferedReader br = new BufferedReader(fr);
        
        String[] datosCorreo = new String[3];
        
        String caracter = br.readLine();
        
        while (caracter != null) {
            
            datosCorreo = (caracter.split("\t"));
                                    
            caracter = br.readLine();
        }
        
        fr.close();
        br.close();
        
        System.out.println("****** Información del correo ******");
        System.out.println("Destinatario: " + datosCorreo[0]);
        System.out.println("Asunto: " + datosCorreo[1]);
        System.out.println("Cuerpo: " + datosCorreo[2]);
    }

}
