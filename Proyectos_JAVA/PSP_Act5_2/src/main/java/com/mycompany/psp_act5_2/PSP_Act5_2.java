package com.mycompany.psp_act5_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Fran
 */
public class PSP_Act5_2 {

    public static void main(String[] args) {
        
        try {
            
            Key claveCifrado = obtenerClave("estoesunacontraseña", 16);
            //cifrar("ficheroDescifrado.txt","ficheroCifrado.txt", claveCifrado);
            
            descifrar("ficheroCifrado.txt", "ficheroDescifrado.txt", claveCifrado);
            
        } catch (Exception ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        }
        
    }
    
    //Método para obtener la clave de tipo Key a partir de una contraseña de tipo String
    private static Key obtenerClave(String password, int longitud){
        
        Key clave = new SecretKeySpec(password.getBytes(), 0, longitud, "AES");
        
        return clave;
        
    } 
    
    //Método para cifrar un fichero. Recibe la ruta del fichero a cifrar, la del nuevo fichero cifrado y una key
    private static void cifrar(String ficheroSinCifrar, String nombreFicheroCifrar, Key key) throws Exception{
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        FileInputStream fis = new FileInputStream(ficheroSinCifrar);
        FileOutputStream fos = new FileOutputStream(nombreFicheroCifrar);
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);
        
        //Leemos el fichero y lo ciframos
        byte[] buffer = new byte[1024];
        
        int bytesLeidos = fis.read(buffer);
        
        while(bytesLeidos != -1){
            
            cos.write(buffer, 0, bytesLeidos);
            bytesLeidos = fis.read(buffer);
            
        }
        
        cos.close();
        fos.close();
        fis.close();
        
        //Borramos el fichero original
        File fichero = new File(ficheroSinCifrar);
        fichero.delete();
        
        System.out.println("Fichero cifrado.");
                
    }
    
    //Método para descifrar un fichero. Recibe la ruta del fichero cifrado, la del nuevo sin cifrar y una key
    private static void descifrar(String ficheroCifrado, String nombreFicheroSinCifrar, Key key) throws Exception{
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        
        FileInputStream fis = new FileInputStream(ficheroCifrado);
        FileOutputStream fos = new FileOutputStream(nombreFicheroSinCifrar);
        CipherInputStream cis = new CipherInputStream(fis, cipher);
        
        //Leemos el fichero y lo desciframos
        byte[] buffer = new byte[1024];
        
        int bytesLeidos = cis.read(buffer);
        
        while(bytesLeidos != -1){
            
            fos.write(buffer, 0, bytesLeidos);
            bytesLeidos = cis.read(buffer);
            
        }
        
        cis.close();
        fos.close();
        fis.close();
        
        //Borramos el fichero original
        File fichero = new File(ficheroCifrado);
        fichero.delete();
        
        System.out.println("Fichero descifrado.");
        
    }
    
}
