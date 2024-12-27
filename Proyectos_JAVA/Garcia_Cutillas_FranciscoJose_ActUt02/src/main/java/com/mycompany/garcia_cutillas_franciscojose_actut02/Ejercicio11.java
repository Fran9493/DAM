package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Fran
 */
public class Ejercicio11 {

    public static void ejercicio11() {

        //Ruta fichero
        String ficheroJSON = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\grupos.json";
        String ficheroXML = "C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Acceso_Datos\\UT02\\DirectorioAct02\\Ejercicio11.xml";

        File f = new File(ficheroXML);
        File fJSON = new File(ficheroJSON);

        if (!f.exists()) {

            try {

                f.createNewFile();

            } catch (IOException ex) {

                System.out.println("Error: " + ex.getMessage());

            }

        }

        try {

            leeJSON(fJSON, ficheroXML);

        } catch (IOException ex) {

            System.out.println("Error 1: " + ex.getMessage());

        } catch (ParserConfigurationException ex) {

            System.out.println("Error 1: " + ex.getMessage());

        } catch (TransformerException ex) {

            System.out.println("Error 1: " + ex.getMessage());

        }

    }

    private static void leeJSON(File JSON, String XML) throws FileNotFoundException, IOException, ParserConfigurationException, TransformerException {

        //Leemos el fichero JSON
        FileReader fr = new FileReader(JSON);
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

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        db = dbf.newDocumentBuilder();

        DOMImplementation di = db.getDOMImplementation();

        //Creación del documento con el nodo principal grupos
        Document doc = di.createDocument(null, "grupos", null);
        doc.setXmlVersion("1.0");

        //Recorremos cada objeto grupo y escribimos su información en el xml
        for (int j = 0; j < grupos.length(); j++) {

            //Obtenemos los objetos de tipo grupo
            JSONObject grupo = grupos.getJSONObject(j);

            //Creamos el elemento grupo
            Element grupoXML = doc.createElement("grupo");

            //Añadimos el atributo página web a grupo
            grupoXML.setAttribute("pagina_web", grupo.getString("pagina_web"));
            doc.getDocumentElement().appendChild(grupoXML);

            //Creamos el elemento nombre
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(grupo.getString("nombre")));
            grupoXML.appendChild(nombre);

            //Creamos el elemento número de discos
            Element numDiscos = doc.createElement("numero_de_discos");
            numDiscos.appendChild(doc.createTextNode(String.valueOf(grupo.getInt("numero_de_discos"))));
            grupoXML.appendChild(numDiscos);

            //Creamos un JSONArray para los discos
            JSONArray discos = grupo.getJSONArray("discos");

            //Leemos discos
            for (int k = 0; k < discos.length(); k++) {

                //Obtenemos los discos
                JSONObject disco = discos.getJSONObject(k);

                //Creamos el elemento disco
                Element discoXML = doc.createElement("disco");
                doc.getDocumentElement().appendChild(discoXML);
                grupoXML.appendChild(discoXML);

                //Creamos el elemento título
                Element titulo = doc.createElement("titulo");
                titulo.appendChild(doc.createTextNode(disco.getString("titulo")));
                discoXML.appendChild(titulo);

                //Creamos el elemento año
                Element ano = doc.createElement("año");
                ano.appendChild(doc.createTextNode(String.valueOf(disco.getInt("año"))));
                discoXML.appendChild(ano);

            }

        }

        copiarDomFichero(XML, doc);

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

}
