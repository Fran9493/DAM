package com.mycompany.garcia_cutillas_franciscojose_act3_2servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_Act3_2Servidor {

    public static void main(String[] args) {        
        
        try {
            
            //Creamos un objeto de tipo SocketTCPServer con un puerto por el que nos vamos a conectar
            SocketTCPServer servidor = new SocketTCPServer(49171);
            
            //Iniciamos la comunicación
            servidor.start();
            
            //Leemos la información pedida por el cliente
            InputStreamReader peticionCliente = new InputStreamReader(servidor.getIs());
            BufferedReader br = new BufferedReader(peticionCliente);
            String ruta = br.readLine();
            
            //Leemos la cadena del fichero
            String cadena = leeFichero(ruta);
            
            //Preparamos el mensaje para enviarlo al cliente            
            OutputStream mensajeSalida = servidor.getSocket().getOutputStream();
            
            //Enviamos el mensaje
            mensajeSalida.write(cadena.getBytes());
            
            //Cerramos la comunicación
            mensajeSalida.close();
            br.close();
            peticionCliente.close();
            servidor.stop();
            
        } catch (IOException ex) {
            
            System.out.println("Error de conexión con el servidor: " + ex.getMessage());
            
        }
        
    }
    
    //Método que lee una cadena de un fichero
    public static String leeFichero(String ruta){
        
        String salida = "";
        
        File fichero = new File(ruta);
        
        try{
        
            FileReader fr = new FileReader(fichero);
            int caracter = fr.read();
            while(caracter != -1){
                
                salida += (char)caracter;
                caracter = fr.read();
                
            }
            
            fr.close();                  
        
        } catch(IOException ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        }
        
        return salida;
        
    }
    
}
