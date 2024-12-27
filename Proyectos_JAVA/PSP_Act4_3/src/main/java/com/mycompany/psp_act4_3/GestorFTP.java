package com.mycompany.psp_act4_3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Fran
 */
public class GestorFTP {

    private FTPClient clienteFTP;
    private String servidor = "localhost";
    private int puerto = 21;
    private String usuario = "fran";
    private String password = "passwd";

    public GestorFTP() {

        clienteFTP = new FTPClient();

    }

    public void conectar() throws SocketException, IOException {

        clienteFTP.connect(servidor, puerto);
        int respuesta = clienteFTP.getReplyCode();

        if (!FTPReply.isPositiveCompletion(respuesta)) {

            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");

        }

        boolean credencialesOk = clienteFTP.login(usuario, password);

        if (!credencialesOk) {

            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas");

        }

        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);

    }

    public void desconectar() throws IOException {

        clienteFTP.disconnect();

    }

    public void descargarFicherosRaiz(String pathLocal) throws IOException {

        //Antes de nada nos aseguramos de estar en el directorio raíz
        clienteFTP.changeWorkingDirectory("/");

        //Vamos a obtener los nombres de todos los ficheros contenidos en el directorio
        String[] ficheros = clienteFTP.listNames();

        //Descargamos los ficheros
        FileOutputStream fos = new FileOutputStream(pathLocal);
        OutputStream os = new BufferedOutputStream(fos);

        for (String fich : ficheros) {

            clienteFTP.retrieveFile("/" + fich, os);

        }

        os.close();

    }

}
