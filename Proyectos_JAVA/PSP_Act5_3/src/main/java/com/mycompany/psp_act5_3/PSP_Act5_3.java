/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.psp_act5_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

/**
 *
 * @author Fran
 */
public class PSP_Act5_3 {

    public static void main(String[] args) {

        try {

            //Generamos las claves privadas y públicas del emisor y el receptor
            KeyPair clavesEmisor = generarClaves();
            KeyPair clavesReceptor = generarClaves();

            //Ciframos el fichero con la clave privada del emisor
            cifrarPrivadaEmisor("ficheroCifrar.txt", clavesEmisor.getPrivate());
            
            //Ciframos el fichero con la clave pública del receptor
            cifrarPublicaReceptor("ficheroCifrar.txt", clavesReceptor.getPublic());
            
            //Desencriptamos el fichero con la clave privada del receptor
            descifrar("ficheroCifradoPublicaReceptor.rsa", "ficheroReceptorDescifrado.txt", 
                    clavesReceptor.getPrivate());

        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());

        }

    }

    //Método para generar el par de claves pública y privada
    public static KeyPair generarClaves() throws NoSuchAlgorithmException {

        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(2048);
        KeyPair claves = generador.generateKeyPair();

        return claves;

    }

    //Método para cifrar un fichero con la clave privada del emisor. Recibe la ruta del fichero y la clave privada del emisor
    public static void cifrarPrivadaEmisor(String rutaFichero, PrivateKey clavePrivadaEmisor) throws Exception {

        //Cifrado con clave privada del emisor.
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, clavePrivadaEmisor);

        FileInputStream fis = new FileInputStream(rutaFichero);
        FileOutputStream fos = new FileOutputStream("ficheroCifradoPrivadaEmisor.rsa");
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);

        //Leemos el fichero y lo ciframos
        byte[] buffer = new byte[1024];

        int bytesLeidos = fis.read(buffer);

        while (bytesLeidos != -1) {

            cos.write(buffer, 0, bytesLeidos);
            bytesLeidos = fis.read(buffer);

        }

        cos.close();
        fos.close();
        fis.close();

        System.out.println("Fichero cifrado con clave privada del emisor.");

    }

    //Método para cifrar un fichero con la clave pública del receptor. Recibe la ruta del fichero y la clave pública del receptor
    public static void cifrarPublicaReceptor(String rutaFichero, PublicKey clavePublicaReceptor) throws Exception {

        //Cifrado con clave pública del receptor.
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, clavePublicaReceptor);

        FileInputStream fis = new FileInputStream(rutaFichero);
        FileOutputStream fos = new FileOutputStream("ficheroCifradoPublicaReceptor.rsa");
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);

        //Leemos el fichero y lo ciframos
        byte[] buffer = new byte[1024];

        int bytesLeidos = fis.read(buffer);

        while (bytesLeidos != -1) {

            cos.write(buffer, 0, bytesLeidos);
            bytesLeidos = fis.read(buffer);

        }

        cos.close();
        fos.close();
        fis.close();

        System.out.println("Fichero cifrado con clave pública del receptor.");

    }

    //Método para descifrar un fichero. Recibe la ruta del fichero cifrado, la del nuevo sin cifrar y la clave privada del receptor
    private static void descifrar(String ficheroCifrado, String nombreFicheroSinCifrar, PrivateKey key) throws Exception {

        //Descifrado con clave privada del receptor
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);

        FileInputStream fis = new FileInputStream(ficheroCifrado);
        FileOutputStream fos = new FileOutputStream(nombreFicheroSinCifrar);
        CipherInputStream cis = new CipherInputStream(fis, cipher);

        //Leemos el fichero y lo desciframos
        byte[] buffer = new byte[1024];

        int bytesLeidos = cis.read(buffer);

        while (bytesLeidos != -1) {

            fos.write(buffer, 0, bytesLeidos);
            bytesLeidos = cis.read(buffer);

        }

        cis.close();
        fos.close();
        fis.close();

        System.out.println("Fichero descifrado.");

    }

}
