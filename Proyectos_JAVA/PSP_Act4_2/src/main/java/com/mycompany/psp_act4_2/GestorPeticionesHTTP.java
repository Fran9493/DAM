package com.mycompany.psp_act4_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Fran
 */
public class GestorPeticionesHTTP {
    
    public StringBuilder getContenidoMetodoGet(String direccion) throws Exception{
        
        StringBuilder respuesta = new StringBuilder();
        URL url = new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Content-Type", "text/plain");
        conexion.setRequestProperty("charset", "utf-8");
        conexion.setRequestProperty("User-Agent", "Chrome/120.0.6099.200");
        int estado = conexion.getResponseCode();
        
        InputStreamReader isr = new InputStreamReader(conexion.getInputStream());
        BufferedReader br = null;
        
        if (estado == HttpURLConnection.HTTP_OK) {
            
            br = new BufferedReader(isr);
            
            String linea = br.readLine();
            
            while(linea != null){
                
                respuesta.append(linea);
                
                linea = br.readLine();
                
            }
            
        } else {
            
            throw new Exception("Error HTTP " + estado);
            
        }
        
        br.close();
        isr.close();
        conexion.disconnect();
        
        return respuesta;
        
    }
    
}
