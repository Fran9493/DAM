/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.garcia_cutillas_franciscojose_act3_1cliente;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_Act3_1Cliente {

    public static void main(String[] args) {

        SocketTCPClient cliente = new SocketTCPClient("10.8.168.84", 49171);

        try {

            cliente.start();
            cliente.abrirComunicacion();
            String mensajeEnviar = "";
            Scanner sc = new Scanner(System.in);
            System.out.println("Mensaje:");
            mensajeEnviar = sc.nextLine();
            cliente.enviarMensaje(mensajeEnviar);
            String mesajeRecibido = cliente.leerMensaje();
            System.out.println("Mensaje del servidor: " + cliente.getIs().read()) ;
            cliente.cerrarComunicacion();
            cliente.stop();

            
        } catch (UnknownHostException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
