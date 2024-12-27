package com.mycompany.garcia_cutillas_franciscojose_act3_2cliente;

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
    
    //Constructor que recibe la ip del servidor y el puerto de comunicación
    public SocketTCPClient (String serverIP, int serverPort){
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    
    //Método para iniciar la conexión con el servidor
    public void start() throws UnknownHostException, IOException{
        
        System.out.println("(Cliente) Estableciendo conexion...");
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();        
        System.out.println("(Cliente) Conexión establecida.");
        
    }
    
    //Método para terminar la conexión con el servidor
    public void stop() throws IOException{
        
        System.out.println("(Cliente) Cerrando conexión...");
        is.close();
        os.close();
        socket.close();
        System.out.println("(Cliente) Conexiones cerradas.");
        
    }
    
    //Método para iniciar una comunicación con el servidor
    public void abrirComunicacion(){
        
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);        
        pw = new PrintWriter(os, true);
        
    }
    
    //Método para terminar la comunicación con el servidor
    public void cerrarComunicacion() throws IOException{
        
        br.close();
        isr.close();
        pw.close();
        
    }
    
    //Método para leer una cadena de texto enviada desde el servidor
    public String leerMensaje() throws IOException{
        
        String mensaje = br.readLine();
        return mensaje;
        
    }
    
    //Método para enviar una cadena de texto al servidor
    public void enviarMensaje(String mensaje){
        
        pw.println(mensaje);
        
    }

    //Métodos getter y settet para obtener los valores del socket desde fuera
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
