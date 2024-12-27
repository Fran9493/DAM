package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Fran
 */
public class Ejercicio06 {

    public static void ejercicio06() {

        System.out.println("*** Aplicación para el manejo de alumnos ***");
        System.out.println("");

        boolean finAplicacion = false;
        Scanner sc = new Scanner(System.in, "ISO-8859-1");

        do {

            switch (consultaUsuario()) {
                case 0:

                    finAplicacion = true;

                    break;

                case 1:

                    System.out.println("*** Dar de alta un nuevo alumno ***");

                    String nre;
                    String nombre;
                    String apellidos;
                    String telefono;
                    String fechaNac;
                    String becario;

                    System.out.println("NRE del alumno: ");
                    nre = sc.nextLine();

                    System.out.println("Nombre del alumno: ");
                    nombre = sc.nextLine();

                    System.out.println("Apellidos del alumno: ");
                    apellidos = sc.nextLine();

                    System.out.println("Teléfono del alumno: ");
                    telefono = sc.nextLine();

                    System.out.println("Fecha de nacimiento (dd/MM/yyyy) del alumno: ");
                    fechaNac = sc.nextLine();

                    System.out.println("¿Es becario? (si/no): ");
                    becario = sc.nextLine();

                    Alumno alumno1 = new Alumno(nre, nombre, apellidos, telefono, fechaEs(fechaNac),
                            becarioStr(becario));

                     {
                        try {

                            if (altaAlumno(alumno1)) {

                                System.out.println("Alumno dado de alta correctamente");

                            } else {

                                System.out.println("No se ha podido dar el alumno de alta");

                            }

                        } catch (IOException ex) {

                            System.out.println("Error: " + ex.getMessage());

                        }
                    }

                    break;

                case 2:

                    System.out.println("*** Eliminar Alumno ***");
                    System.out.println("");
                    System.out.println("Introduce el NRE del alumno a eliminar");

                    nre = sc.nextLine();

                     {
                        try {

                            if (borraAlumno(nre)) {

                                System.out.println("Alumno eliminado");

                            } else {

                                System.out.println("No se ha podido eliminar al alumno");

                            }

                        } catch (IOException ex) {

                            System.out.println("Error: " + ex.getMessage());

                        }
                    }

                    break;

                case 3:

                    System.out.println("*** Modificar Alumno ***");
                    System.out.println("");
                    System.out.println("Introduce el NRE del alumno a modificar");

                    nre = sc.nextLine();

                     {
                        try {

                            if (modificarAlumno(nre)) {

                                System.out.println("Alumno modificado");

                            } else {

                                System.out.println("No se ha podido modificar el alumno");

                            }

                        } catch (IOException ex) {

                            System.out.println("Error: " + ex.getMessage());

                        }
                    }

                    break;

                case 4: {
                    try {

                        listaAlumnos();

                    } catch (IOException ex) {

                        System.out.println("Error: " + ex.getMessage());

                    }
                }

                break;

            }

            if (!finAplicacion) {

                System.out.println("¿Desea realizar alguna otra operación?");

            }

        } while (!finAplicacion);

    }

    //Método para dar de alta un alumno nuevo
    private static boolean altaAlumno(Alumno nuevoAlumno) throws IOException {

        boolean alumnoCreado = false;
        String ficheroAlumnos = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio6.txt";

        //Fichero en el que se encuentran los alumnos
        File fichero = new File(ficheroAlumnos);

        if (!fichero.exists()) {

            fichero.createNewFile();

        }

        //Comprobar que el alumno no está en el fichero
        if (!compruebaAlumno(nuevoAlumno.getNre())) {

            //FileWriter para escribir en el fichero de alumnos
            FileWriter fw = new FileWriter(fichero, true);

            fw.write(nuevoAlumno.getNre());
            fw.write("\t");
            fw.write(nuevoAlumno.getNombre());
            fw.write("\t");
            fw.write(nuevoAlumno.getApellidos());
            fw.write("\t");
            fw.write(nuevoAlumno.getTelefono());
            fw.write("\t");
            fw.write(nuevoAlumno.getFechaNac().toString());
            fw.write("\t");
            fw.write(nuevoAlumno.esBecario());
            fw.write("\n");

            fw.close();

            alumnoCreado = true;

        }

        return alumnoCreado;

    }

    //Método para comprobar si el alumno se encuentra en el fichero
    private static boolean compruebaAlumno(String nre) throws FileNotFoundException, IOException {

        boolean alumnoPresente = false;
        String ficheroAlumnos = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio6.txt";

        //Fichero en el que se encuentran los alumnos
        File fichero = new File(ficheroAlumnos);

        //Leo fichero
        FileReader fr = new FileReader(fichero);

        //Guardo en un buffer
        BufferedReader br = new BufferedReader(fr);

        String[] datosAlumno = new String[6];

        String caracter = br.readLine();

        while (caracter != null) {

            datosAlumno = caracter.split("\t");

            if (datosAlumno[0].equalsIgnoreCase(nre)) {

                alumnoPresente = true;
            }

            caracter = br.readLine();

        }

        fr.close();
        br.close();

        return alumnoPresente;

    }

    //Método para borrar alumnos si están en el fichero
    private static boolean borraAlumno(String nre) throws IOException {

        boolean alumnoBorrado = false;

        if (compruebaAlumno(nre)) {

            String ficheroAlumnos = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio6.txt";
            String ficheroTemp = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Temp.txt";

            //Fichero en el que se encuentran los alumnos
            File fichero = new File(ficheroAlumnos);

            //Fichero temporal para copiar
            File ficheroCopia = new File(ficheroTemp);
            ficheroCopia.createNewFile();

            //Leo fichero alumnos
            FileReader fr = new FileReader(fichero);

            //FileWriter para escribir en el fichero temporal
            FileWriter fw = new FileWriter(ficheroTemp);

            //Guardo en un buffer
            BufferedReader br = new BufferedReader(fr);

            String[] datosAlumno = new String[6];

            String caracter = br.readLine();

            while (caracter != null) {

                datosAlumno = caracter.split("\t");

                //Escribe en el fichero temporal todos los alumnos menos el que queremos borrar
                if (!datosAlumno[0].equalsIgnoreCase(nre)) {

                    fw.write(datosAlumno[0]);
                    fw.write("\t");
                    fw.write(datosAlumno[1]);
                    fw.write("\t");
                    fw.write(datosAlumno[2]);
                    fw.write("\t");
                    fw.write(datosAlumno[3]);
                    fw.write("\t");
                    fw.write(datosAlumno[4]);
                    fw.write("\t");
                    fw.write(datosAlumno[5]);
                    fw.write("\n");

                }

                caracter = br.readLine();

            }

            fr.close();
            br.close();
            fw.close();

            //Borramos el fichero original
            fichero.delete();

            //Renombramos el fichero temporal y le ponemos el nombre del original
            File ficheroRenombrar = new File(ficheroAlumnos);
            FileUtils.moveFile(ficheroCopia, ficheroRenombrar);

            alumnoBorrado = true;

        }

        return alumnoBorrado;

    }

    private static boolean modificarAlumno(String nre) throws IOException {

        boolean alumnoModificado = false;

        if (compruebaAlumno(nre)) {

            boolean preguntaCorrecta = false;
            Scanner sc = new Scanner(System.in);
            String eleccion;

            do {

                System.out.println("¿Quieres realmente modificar el alumno con NRE: " + nre + "? (s/n)");

                eleccion = sc.nextLine();

                if (eleccion.equalsIgnoreCase("s")) {

                    borraAlumno(nre);

                    formularioNuevoAlumno();

                    alumnoModificado = true;

                    preguntaCorrecta = true;

                } else if (eleccion.equalsIgnoreCase("n")) {

                    preguntaCorrecta = true;

                } else {

                    System.out.println("Debes elegir entre (s/n)");

                }

            } while (!preguntaCorrecta);

        }

        return alumnoModificado;

    }

    private static void formularioNuevoAlumno() throws IOException {

        String nreAlumno;
        String nombreAlumno;
        String apellidosAlumno;
        String telefonoAlumno;
        String fechaNac;
        boolean becario = false;
        String becarioStr;
        Scanner sc = new Scanner(System.in, "ISO-8859-1");

        System.out.println("Introduce el NRE del alumno: ");
        nreAlumno = sc.nextLine();

        System.out.println("Introduce el nombre del alumno: ");
        nombreAlumno = sc.nextLine();

        System.out.println("Introduce los apellidos del alumno: ");
        apellidosAlumno = sc.nextLine();

        System.out.println("Introduce el teléfono del alumno: ");
        telefonoAlumno = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento del alumno en formato dd/mm/aaaa: ");
        fechaNac = sc.nextLine();

        boolean respCorrecta = false;

        do {

            System.out.println("¿Es becario? (s/n): ");
            becarioStr = sc.nextLine();

            if (becarioStr.equalsIgnoreCase("s")) {

                becario = true;
                respCorrecta = true;

            } else if (becarioStr.equalsIgnoreCase("n")) {

                becario = false;
                respCorrecta = true;

            } else {

                System.out.println("Debes elegir únicamente entre s/n");

            }

        } while (!respCorrecta);

        Alumno nuevoAlumno = new Alumno(nreAlumno, nombreAlumno, apellidosAlumno, telefonoAlumno,
                fechaEs(fechaNac), becario);

        altaAlumno(nuevoAlumno);

    }

    private static void listaAlumnos() throws FileNotFoundException, IOException {

        String ficheroAlumnos = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio6.txt";

        //Fichero en el que se encuentran los alumnos
        File fichero = new File(ficheroAlumnos);

        //Leo fichero
        FileReader fr = new FileReader(fichero);

        //Guardo en un buffer
        BufferedReader br = new BufferedReader(fr);

        String[] datosAlumno = new String[6];

        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.println("**********Listado de Alumnos**********");

        String caracter = br.readLine();

        while (caracter != null) {

            datosAlumno = caracter.split("\t"); //Separa cada campo en un índice

            Alumno a = new Alumno(datosAlumno[0], datosAlumno[1], datosAlumno[2], datosAlumno[3], fechaStr(datosAlumno[4]),
                    becarioStr(datosAlumno[5]));

            alumnos.add(a);

            caracter = br.readLine();

        }

        Collections.sort(alumnos);

        //Mostrar alumnos ordenados por terminal
        for (Alumno a : alumnos) {

            //Muestra por terminal
            System.out.println(a);

        }

        fr.close();
        br.close();

    }

    private static int consultaUsuario() {

        System.out.println("    Pulsa 0 para finalizar");
        System.out.println("    Pulsa 1 para dar de alta un nuevo alumno");
        System.out.println("    Pulsa 2 para eliminar un alumno");
        System.out.println("    Pulsa 3 para modificar un alumno");
        System.out.println("    Pulsa 4 para mostrar un listado de todos los alumnos");

        int eleccion;
        boolean eleccionCorrecta = false;
        Scanner sc = new Scanner(System.in);

        do {

            eleccion = sc.nextInt();

            if (eleccion < 0 || eleccion > 4) {

                System.out.println("No has introducido un valor correcto");

            } else {

                eleccionCorrecta = true;

            }

        } while (!eleccionCorrecta);

        return eleccion;

    }

    private static LocalDate fechaEs(String fecha) {

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaLD = LocalDate.parse(fecha, formater);

        return fechaLD;

    }

    public static LocalDate fechaStr(String entrada) {

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate fechaLD = LocalDate.parse(entrada, formater);

        return fechaLD;

    }

    public static boolean becarioStr(String entrada) {

        return entrada.equalsIgnoreCase("si");

    }

}
