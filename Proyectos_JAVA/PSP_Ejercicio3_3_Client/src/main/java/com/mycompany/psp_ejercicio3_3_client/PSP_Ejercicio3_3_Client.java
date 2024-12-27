package com.mycompany.psp_ejercicio3_3_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Fran
 */
public class PSP_Ejercicio3_3_Client {

    public static void main(String[] args) {
                        
        
        
        DatagramSocket socketUDP;
        
        System.out.println("(Cliente): Estableciendo parámetros de conexión...");
        
        try {
                    
            System.out.println("(Cliente): Estableciendo parámetros de conexión...");
            
            InetAddress hostServidor = InetAddress.getByName("localhost");
            int puertoServidor = 49171;
            
            System.out.println("(Cliente): Creando socket...");
            socketUDP = new DatagramSocket();
            
            System.out.println("(Cliente): Enviando datagrama...");      
            
            for (int i = 0; i < 10000; i++) {
            
                String mensaje = "Mensaje: " + i;
                byte[] buffer = mensaje.getBytes();
                
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length, hostServidor, puertoServidor);
                socketUDP.send(peticion);
            
            }
            
            String mensajeFin = "FIN";
            byte[] bufferFin = mensajeFin.getBytes();
            
            DatagramPacket fin = new DatagramPacket(bufferFin, bufferFin.length, hostServidor, puertoServidor);
            socketUDP.send(fin);
            
            System.out.println("(Cliente): Cerrando socket...");
            socketUDP.close();
            
            System.out.println("(Cliente): Socket cerrado.");
            
        } catch (UnknownHostException ex) {
            
            System.out.println("Error al conectar con el servidor: " + ex.getMessage());
            
        } catch (SocketException ex) {
            
            System.out.println("Error al crear el socket: " + ex.getMessage());
            
        } catch (IOException ex) {
            
            System.out.println("Error al enviar la petición: " + ex.getMessage());
            
        }
        
    }
}
