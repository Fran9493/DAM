package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Fran
 */
public class Ejercicio07 {

    public static void ejercicio07() {

        String ficheroTexto = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio7.txt";
        String ficheroXML = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio7.xml";
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Document docVehiculos = null;

        try {

            docVehiculos = obtenerDOM(ficheroXML);

        } catch (ParserConfigurationException ex) {

            System.out.println("Error 1: " + ex.getMessage());

        } catch (SAXException ex) {

            System.out.println("Error 2: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("Error 3: " + ex.getMessage());

        }

        if (docVehiculos != null) {

            vehiculos = obtenerVehiculos(docVehiculos);

            try {

                escribeVehiculo(vehiculos, ficheroTexto);

            } catch (IOException ex) {

                System.out.println("Error 4: " + ex.getMessage());

            }

        }

    }

    //Método para obtener el DOM del fichero xml
    public static Document obtenerDOM(String nombreArchivo) throws ParserConfigurationException, SAXException, IOException {

        //Fichero de donde vamos a sacar los vehículos
        File f = new File(nombreArchivo);

        //Creamos instancia de DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //A partir de la instancia creamos un DocumentBuilder
        DocumentBuilder db = dbf.newDocumentBuilder();

        //Con el método parse obtenemos el documento
        Document doc = db.parse(f);

        //Normalizamos el documento
        doc.getDocumentElement().normalize();

        return doc;

    }

    //Método para obtener los nodos hijos y guardarlos en un fichero txt
    public static ArrayList<Vehiculo> obtenerVehiculos(Document docVehiculos) {

        //ArrayList donde vamos a ir guardando los vehículos extraídos
        ArrayList<Vehiculo> listVehiculos = new ArrayList<>();

        //Creamos una lista con los nodos vehiculo
        NodeList vehiculos = docVehiculos.getElementsByTagName("vehiculo");

        //Recorremos los vehículos
        for (int i = 0; i < vehiculos.getLength(); i++) {

            //Obtenemos un elemento
            Node vehiculo = vehiculos.item(i);

            //Nos aseguramos de que sea un elemento
            if (vehiculo.getNodeType() == Node.ELEMENT_NODE) {

                Element veh = (Element) vehiculo;

                //Crea un vehículo con los datos obtenidos
                Vehiculo v = new Vehiculo(veh.getElementsByTagName("marca").item(0).getTextContent(),
                        veh.getElementsByTagName("modelo").item(0).getTextContent(),
                        Integer.parseInt(veh.getElementsByTagName("anoMatriculacion").item(0).getTextContent()),
                        veh.getElementsByTagName("color").item(0).getTextContent(),
                        veh.getElementsByTagName("matricula").item(0).getTextContent());

                //Añádelo al ArrayList
                listVehiculos.add(v);

            }

        }

        return listVehiculos;

    }

    //Método para escribir los vehículos en el fichero de texto
    public static void escribeVehiculo(ArrayList<Vehiculo> vehiculos, String nombreFichero) throws IOException {

        //Fichero en el que se van a guardar los vehículos
        File fichero = new File(nombreFichero);

        //FileWriter para escribir
        FileWriter fw = new FileWriter(fichero);

        //Ordenamos los vehículos alfabéticamente
        Collections.sort(vehiculos);

        if (!fichero.exists()) {

            fichero.createNewFile();

        } else {

            //Recorremos todos los vehículos de ArrayList
            for (Vehiculo v : vehiculos) {

                //Sólo nos quedamos con los que han sido matriculados dentro de los últimos 10 años
                if (v.getAnoMatricula() >= LocalDate.now().getYear() - 10) {

                    fw.write(v.getMarca());
                    fw.write("*");
                    fw.write(v.getModelo());
                    fw.write("*");
                    fw.write(v.getMatricula());
                    fw.write("\n");

                }

            }

        }

        fw.close();

    }

}
