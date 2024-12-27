package com.mycompany.psp_act5_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fran
 */
public class PSP_Act5_1 {

    private static final String ALGORITMO = "SHA-512";
    
    public static void main(String[] args) {
        
        String hash = "e62b9b432c38710a16326edd4712c4f15185fbf2cd86d3a47afb453c6d8f72e43ce385e7692e2ab4fa0e8211ac8e28de32ad31997c2130036756cd5bd8be8796";
        File fichero = new File("prueba.txt");
        
        System.out.println("*** Comprobación de la integridad de un fichero ***");
        
        try {
            
            //Comprobación de la integridad
            if (certificaIntegridad(fichero, hash)) {
                
                System.out.println("\tIntegridad correcta");
                                
            } else {
                
                System.out.println("\tIntegridad incorrecta");
                
            }
            
            System.out.println("\tHash actual del fichero: " + calcularHash(fichero));
            System.out.println("\tHash que nos pasan: " + hash);
            
        } catch (IOException ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        } catch (NoSuchAlgorithmException ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        }
        
        
        
    }
    
    //Método para comprobar la integridad del fichero
    private static boolean certificaIntegridad (File fichero, String hash) throws IOException, NoSuchAlgorithmException{
                
        String hashCalculado = calcularHash(fichero);
        
        if (hash.equals(hashCalculado)) {
            
            return true;
            
        } else{
            
            return false;
            
        }
                
    }
    
    //Método que calcula el Hash de un fichero que se le pasa por parámetro
    private static String calcularHash(File fichero) throws IOException, NoSuchAlgorithmException{
        
        MessageDigest algoritmo = MessageDigest.getInstance(ALGORITMO);
        byte[] lecturaFichero = Files.readAllBytes(fichero.toPath());
        byte[] hashByte = algoritmo.digest(lecturaFichero);
        
        //Convertimos el hash de tipo array de byte a un string
        StringBuilder sb = new StringBuilder();
        for(byte hash : hashByte){
            sb.append(String.format("%02x", hash));
        }
        
        return sb.toString();
        
    }
           
}
