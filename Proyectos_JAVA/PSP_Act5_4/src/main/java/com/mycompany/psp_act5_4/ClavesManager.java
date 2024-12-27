package com.mycompany.psp_act5_4;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Fran
 */
public class ClavesManager {

    private static final String FICHERO_CLAVE_PUBLICA = "clavePublica.key";
    private static final String FICHERO_CLAVE_PRIVADA = "clavePrivada.key";

    //Método que genera el par de claves pública y privada. Dewvuelve un KeyPair
    public static KeyPair generarClaves() throws NoSuchAlgorithmException {

        KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
        generador.initialize(512);
        KeyPair claves = generador.generateKeyPair();

        return claves;

    }

    //Método para guardar las claves en un fichero
    public static void guardarClaves(KeyPair claves) throws Exception {

        FileOutputStream fos = new FileOutputStream(FICHERO_CLAVE_PUBLICA);
        fos.write(claves.getPublic().getEncoded());
        fos.close();

        fos = new FileOutputStream(FICHERO_CLAVE_PRIVADA);
        fos.write(claves.getPrivate().getEncoded());
        fos.close();

    }

    //Método para obtener la clave privada de un fichero de clave
    public static PrivateKey getClavePrivada() throws Exception {

        File ficheroClavePrivada = new File(FICHERO_CLAVE_PRIVADA);
        byte[] bytesClavePrivada = Files.readAllBytes(ficheroClavePrivada.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec publicKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        PrivateKey clavePrivada = keyFactory.generatePrivate(publicKeySpec);

        return clavePrivada;

    }

    //Método para obtener la clave pública de un fichero de clave
    public static PublicKey getClavePublica() throws Exception {

        File ficheroClavePublica = new File(FICHERO_CLAVE_PUBLICA);
        byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);
        PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);

        return clavePublica;

    }

    public static void main(String[] args) {

        try {

            KeyPair claves = generarClaves();
            guardarClaves(claves);

        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());

        }

    }

}
