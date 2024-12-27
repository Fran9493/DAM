package com.mycompany.garcia_cutillas_franciscojose_act3_2servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Fran
 */
public class SocketTCPServer {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;
    
    //Constructor para crear un socket de tipo ServerSocket
    public SocketTCPServer(int puerto) throws IOException{
        
        serverSocket = new ServerSocket(puerto);
        
    }
    
    //Método para iniciar la comunicación
    public void start() throws IOException{
        
        System.out.println("(Servidor) Esperando conexiones...");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Servidor) Conexión establecida.");
        
    }
    
    //Método para parar la comunicación
    public void stop() throws IOException{
        
        System.out.println("(Servidor) Cerrando conexiones...");
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
        System.out.println("(Servidor) Conexiones cerradas.");
        
    }
    
    //Método para iniciar una comunicación con el cliente
    public void abrirComunicacion(){
        
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);        
        pw = new PrintWriter(os, true);
        
    }
    
    //Método para terminar la comunicación con el cliente
    public void cerrarComunicacion() throws IOException{
        
        br.close();
        isr.close();
        pw.close();
        
    }
    
    //Método para leer una cadena de texto enviada desde el cliente
    public String leerMensaje() throws IOException{
        
        String mensaje = br.readLine();
        return mensaje;
        
    }
    
    //Método para enviar una cadena de texto al cliente
    public void enviarMensaje(String mensaje){
        
        pw.println(mensaje);
        
    }

    //Métodos getter y setter para obtener información de la clase desde fuera
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
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
