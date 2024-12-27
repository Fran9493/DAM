/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.garcia_cutillas_franciscojose_act3_1cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Fran
 */
public class SocketTCPClient {
    
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;
    
    public SocketTCPClient (String serverIP, int serverPort){
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    
    public void start() throws UnknownHostException, IOException{
        
        System.out.println("(Cliente) Estableciendo conexion...");
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();
        
        System.out.println("(Cliente) Conexión establecida.");
        
    }
    
    public void stop() throws IOException{
        
        System.out.println("(Cliente) Cerrando conexión...");
        is.close();
        os.close();
        socket.close();
        System.out.println("(Cliente) Conexiones cerradas.");
        
    }
    
    public void abrirComunicacion(){
        
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        pw = new PrintWriter(os, true);
        
    }
    
    public void cerrarComunicacion() throws IOException{
        
        br.close();
        isr.close();
        pw.close();
        
    }
    
    public String leerMensaje() throws IOException{
        
        String mensaje = br.readLine();
        return mensaje;
        
    }
    
    public void enviarMensaje(String mensaje){
        
        pw.println(mensaje);
        
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }
    
}
