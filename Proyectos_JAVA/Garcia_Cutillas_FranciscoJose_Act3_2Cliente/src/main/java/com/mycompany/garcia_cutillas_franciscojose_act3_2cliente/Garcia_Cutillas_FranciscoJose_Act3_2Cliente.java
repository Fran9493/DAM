package com.mycompany.garcia_cutillas_franciscojose_act3_2cliente;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_Act3_2Cliente {

    public static void main(String[] args) {

        SocketTCPClient cliente = new SocketTCPClient("localhost", 49171);

        try {
            
            //Inicio la comunicación
            cliente.start();
            cliente.abrirComunicacion();
            
            //Preparo y envío el mensaje al servidor con la ruta del fichero
            String mensajeEnviar = "";
            Scanner sc = new Scanner(System.in);
            System.out.print("Escribe la ruta del fichero:");
            mensajeEnviar = sc.nextLine();
            cliente.enviarMensaje(mensajeEnviar);
            
            //Muestro el mensaje recibido del servidor
            System.out.println("Mensaje recibido del servidor:");
            String mensaje = cliente.leerMensaje();
            System.out.println(mensaje);
            
            //Cierro la conexión
            cliente.cerrarComunicacion();
            cliente.stop();
            
        } catch (UnknownHostException ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        } catch (IOException ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        }

    }
}
