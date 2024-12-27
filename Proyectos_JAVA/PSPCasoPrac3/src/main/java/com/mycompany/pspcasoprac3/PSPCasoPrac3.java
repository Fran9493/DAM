package com.mycompany.pspcasoprac3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class PSPCasoPrac3 {

    public static void main(String[] args) {

        String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String rutaCalculadora = "calc.exe";
        String rutaNotepad = "notepad.exe";

        ArrayList<String> rutas = new ArrayList<>();
        rutas.add(rutaChrome);
        rutas.add(rutaCalculadora);
        rutas.add(rutaNotepad);

        for (String ruta : rutas) {

            ejecutarProceso(ruta);

        }

        System.out.println("Fin");

    }

    public static void ejecutarProceso(String ruta) {

        ProcessBuilder pb = new ProcessBuilder(ruta);

        try {

            Process p = pb.start();

            System.out.println("El PID del proceso es: " + p.pid());
            System.out.println("Momento de inicio: " + p.info().startInstant().toString());
            
            p.destroy();

        } catch (IOException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

    }

}
