package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Fran
 */
public class Ejercicio08 {

    public static void ejercicio08() {

        String nombreFicheroTXT = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio6.txt";
        String nombreFicheroXML = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio8.xml";

        try {

            alumnosXML(listaAlumnos(nombreFicheroTXT), nombreFicheroXML);

        } catch (IOException ex) {

            System.out.println("Error 1: " + ex.getMessage());

        } catch (ParserConfigurationException ex) {

            System.out.println("Error 2: " + ex.getMessage());

        } catch (TransformerException ex) {
            System.out.println("Error 3: " + ex.getMessage());

        }

    }

    //Método para crear el fichero xml
    private static void alumnosXML(ArrayList<Alumno> alumnos, String nombreFicheroXML) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        db = dbf.newDocumentBuilder();

        DOMImplementation di = db.getDOMImplementation();

        //Creación del documento con el nodo principal alumnos
        Document doc = di.createDocument(null, "alumnos", null);
        doc.setXmlVersion("1.0");

        //Vamos recorriendo cada objeto alumno del arraylist y creando nodos para cada alumno a insertar
        for (Alumno a : alumnos) {

            //Creamos el elemento alumno
            Element alumno = doc.createElement("alumno");

            //Lo añadimos como hijo de alumnos
            doc.getDocumentElement().appendChild(alumno);

            //Creamos cada uno de los elementos que contiene la información de un alumno
            //NRE
            Element nre = doc.createElement("nre");
            nre.appendChild(doc.createTextNode(a.getNre()));
            alumno.appendChild(nre);

            //Nombre
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(a.getNombre()));
            alumno.appendChild(nombre);
            
            //Apellidos
            Element apellidos = doc.createElement("apellidos");
            apellidos.appendChild(doc.createTextNode(a.getApellidos()));
            alumno.appendChild(apellidos);
                       
            //Teléfono
            Element telefono = doc.createElement("telefono");
            telefono.appendChild(doc.createTextNode(a.getTelefono()));
            alumno.appendChild(telefono);

            //Fecha de nacimiento
            Element fechaNac = doc.createElement("fechaNac");
            fechaNac.appendChild(doc.createTextNode(a.getFechaNac().toString()));
            alumno.appendChild(fechaNac);

            //Si es becario 
            Element becario = doc.createElement("becario");
            becario.appendChild(doc.createTextNode(a.esBecario()));
            alumno.appendChild(becario);

            //Copiamos el DOM en el fichero que hemos creado
            copiarDomFichero(nombreFicheroXML, doc);

        }

    }

    //Método para copiar el DOM a un fichero
    private static void copiarDomFichero(String nombreFichero, Document doc) throws TransformerException {

        //Fichero en el que se va a copiar el DOM
        File f = new File(nombreFichero);

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        StreamResult rs = new StreamResult(f);
        DOMSource ds = new DOMSource(doc);
        tr.transform(ds, rs);

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
