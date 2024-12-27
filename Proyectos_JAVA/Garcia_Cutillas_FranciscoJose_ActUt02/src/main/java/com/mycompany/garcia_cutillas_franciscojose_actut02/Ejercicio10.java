package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Fran
 */
public class Ejercicio10 {

    public static void ejercicio10() {
        
        String ficheroTXT = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio6.txt";
        
        try {         
            
            guardaJSON(listaAlumnos(ficheroTXT));
            
        } catch (IOException ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        }

    }

    private static void guardaJSON(ArrayList<Alumno> alumnos) throws IOException {

        String ficheroJSON = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio10.json";
        JSONArray arrayAlumnos = new JSONArray();
        
        File f = new File(ficheroJSON);
        
        FileWriter fw = new FileWriter(f);
        
        for(Alumno a: alumnos){
            
            JSONObject alumnoJSON = generaAlumno(a);
            arrayAlumnos.put(alumnoJSON);
            
        }
        
        fw.write(arrayAlumnos.toString());
        fw.close();

    }

    //Método para generar JSONObject a partir de un alumno
    private static JSONObject generaAlumno(Alumno a) {

        JSONObject alumnoJSON = new JSONObject();

        alumnoJSON.put("nre", a.getNre());
        alumnoJSON.put("nombre", a.getNombre());
        alumnoJSON.put("apellidos", a.getApellidos());
        alumnoJSON.put("telefono", a.getTelefono());
        alumnoJSON.put("fechaNac", a.getFechaNac());
        alumnoJSON.put("becario", a.esBecario());
        
        return alumnoJSON;

    }

    //Método que devuelve un ArrayList de los alumnos contenidos en un fichero txt
    private static ArrayList<Alumno> listaAlumnos(String nombreFichero) throws FileNotFoundException, IOException {

        //Fichero en el que se encuentran los alumnos
        File fichero = new File(nombreFichero);

        //Leo fichero
        FileReader fr = new FileReader(fichero);

        //Guardo en un buffer
        BufferedReader br = new BufferedReader(fr);

        String[] datosAlumno = new String[6];

        ArrayList<Alumno> alumnos = new ArrayList<>();

        String caracter = br.readLine();

        while (caracter != null) {

            datosAlumno = caracter.split("\t"); //Separa cada campo en un índice

            Alumno a = new Alumno(datosAlumno[0], datosAlumno[1], datosAlumno[2], datosAlumno[3], Ejercicio06.fechaStr(datosAlumno[4]),
                    Ejercicio06.becarioStr(datosAlumno[5]));

            alumnos.add(a);

            caracter = br.readLine();

        }

        Collections.sort(alumnos);

        fr.close();
        br.close();

        return alumnos;

    }

}
