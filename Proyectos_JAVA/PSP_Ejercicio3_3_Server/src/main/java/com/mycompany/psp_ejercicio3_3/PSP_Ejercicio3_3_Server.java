package com.mycompany.psp_ejercicio3_3;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Fran
 */
public class PSP_Ejercicio3_3_Server {

    public static void main(String[] args) {
        
        DatagramSocket socket;
        
        try {
            
            System.out.println("(Servidor): Creando socket...");
            
            socket = new DatagramSocket(49171);
            
            System.out.println("(Servidor): Recibiendo datagrama...");            
            byte[] bufferLectura = new byte[1024];
            
            FileWriter fw = new FileWriter("C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Programacion_Servicios\\Tareas\\Tema3\\fichero3_3.txt", true);
            
                       
            while(true){
                
                DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            
                socket.receive(datagramaEntrada);
                
                String mensajeRecibido = new String(datagramaEntrada.getData(), 0, datagramaEntrada.getLength());
                
                System.out.println("(Servidor): Mensaje recibido:" + mensajeRecibido); 
                fw.write(mensajeRecibido + "\n");
                
                if (mensajeRecibido.equalsIgnoreCase("FIN")) {
                    fw.close();
                    socket.close();
                    break;
                }
                                
            }
            
            System.out.println("(Servidor): Cerrando socket...");
            //socket.close();
            
            System.out.println("(Servidor): Socket cerrado.");
            
        } catch (SocketException ex) {
            
            System.out.println("Error al crear el socket: " + ex.getMessage());
            
        } catch (IOException ex) {
            
            System.out.println("Error al recibir el datagrama: " + ex.getMessage());
        
        }
        
    }
}
