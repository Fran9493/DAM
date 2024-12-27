package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Fran
 */
public class Ejercicio09 {

    public static void ejercicio09() {

        //Ruta fichero
        String ficheroJSON = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\grupos.json";

        //Leemos el fichero
        File f = new File(ficheroJSON);

        try {

            FileReader fr = new FileReader(f);
            String cadenaJSON = "";
            int i = fr.read();

            while (i != -1) {

                cadenaJSON += (char) i;
                i = fr.read();

            }

            //Creamos un JSONObject con la cadena extraída del fichero
            JSONObject o = new JSONObject(cadenaJSON);

            //Generamos un JSONArray a partir del objeto 
            JSONArray grupos = o.getJSONArray("grupos");

            System.out.println("*********************************");

            //Recorremos cada objeto grupo y mostramos su información
            for (int j = 0; j < grupos.length(); j++) {

                //Obtenemos los objetos de tipo grupo
                JSONObject grupo = grupos.getJSONObject(j);

                //Mostramos información del grupo
                System.out.println("Nombre: " + grupo.getString("nombre"));
                System.out.println("Número de discos: " + grupo.getInt("numero_de_discos"));
                System.out.println("Página web: " + grupo.getString("pagina_web"));

                //Mostramos los distintos discos del grupo
                JSONArray discos = grupo.getJSONArray("discos");

                System.out.println("Discos:");

                for (int k = 0; k < discos.length(); k++) {

                    //Obtenemos los discos
                    JSONObject disco = discos.getJSONObject(k);

                    System.out.println("    Nombre del disco: " + disco.getString("titulo"));
                    System.out.println("    Año de lanzamiento: " + disco.getInt("año"));

                }

                System.out.println("*********************************");

            }

        } catch (FileNotFoundException ex) {

            System.out.println("Error 1: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("Error 2: " + ex.getMessage());

        }

    }

}
