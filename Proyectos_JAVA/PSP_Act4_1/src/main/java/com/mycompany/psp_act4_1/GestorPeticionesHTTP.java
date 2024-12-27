/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.psp_act4_1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Fran
 */
public class GestorPeticionesHTTP {
    
    public StringBuilder getContenidoMetodoGet(String direccion) throws Exception{
        
        //Creación de la URL
        StringBuilder respuesta = new StringBuilder();
        URL url = new URL(direccion);
        
        //Apertura de la conexión
        HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
        
        //Configuración de la conexión        
        conexion.setRequestMethod("GET");//Método HTTP
        conexion.setRequestProperty("Content-Type", "text/plain");//Tipo de contenido
        conexion.setRequestProperty("charset", "utf-8");//Sistema de codificación
        conexion.setRequestProperty("User-Agent", "Chrome/120.0.6099.200");//Agente de usuario a utilizar
       
        //Obtención y evaluación del código de respuesta HTTP
        int estado = conexion.getResponseCode();
        
        Reader streamReader = null;
        if (estado == HttpURLConnection.HTTP_OK) { //Si el código es 200. 
            
            //Obtención del InputStream para la lectura
            streamReader = new InputStreamReader(conexion.getInputStream());
            
            int caracter;
            while((caracter = streamReader.read()) != -1){
                
                respuesta.append((char)caracter);
                
            }
            
            //Obtención del OutputStream para la escritura(si lo hubiera)
            
        }else{
            
            throw new Exception("Error HTTP " + estado);
            
        }
        
        //Desconexión
        conexion.disconnect();
        return respuesta;
        
    }
    
    public static void writeFile(String strPath, String contenido) throws IOException{
        
        Path path = Paths.get(strPath);
        byte[] strToBytes = contenido.getBytes();
        Files.write(path, strToBytes);
        
    }
    
}
