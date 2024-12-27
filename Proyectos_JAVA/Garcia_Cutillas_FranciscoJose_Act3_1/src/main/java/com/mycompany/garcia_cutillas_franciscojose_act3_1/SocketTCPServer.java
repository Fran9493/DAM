/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.garcia_cutillas_franciscojose_act3_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class SocketTCPServer {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    
    public SocketTCPServer (int puerto) throws IOException{
        
        this.serverSocket = new ServerSocket(puerto);
        
    }
    
    public void start() throws IOException{
        
        System.out.println("(Servidor) Esperando conexiones...");
        this.socket = this.serverSocket.accept();
        this.is = this.socket.getInputStream();
        this.os = this.socket.getOutputStream();
        System.out.println("(Servidor) Conexión establecida.");
        
    }
    
    public void stop() throws IOException{
        
        System.out.println("(Servidor) Cerrando conexiones...");
        this.is.close();
        this.os.close();
        this.socket.close();
        this.serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
        
    }
    
    public static void main(String[] args) {
        
        try {
            SocketTCPServer servidor = new SocketTCPServer(49171);
            servidor.start();
            System.out.println("Mensaje del cliente: " + servidor.is.read());
            servidor.os.write(200);
            servidor.stop();
        } catch (IOException ex) {
            System.out.println("Error en la comunicación del servidor: " + ex.getMessage());
        }
        
    }

       
    
    
}
