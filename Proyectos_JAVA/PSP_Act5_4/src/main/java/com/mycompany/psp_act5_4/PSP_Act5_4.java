package com.mycompany.psp_act5_4;

import java.security.Signature;

/**
 *
 * @author Fran
 */
public class PSP_Act5_4 {
    
    private static String FICHERO_ORIGINAL = "ficheroOriginal.txt";
    private static String FICHERO_MODIFICADO = "ficheroModificado.txt";

    public static void main(String[] args) {
        
        try{
            
            Signature signature = Signature.getInstance("DSA");
            signature.initSign(ClavesManager.getClavePrivada());
            signature.update(FICHERO_ORIGINAL.getBytes());
            byte[] firma = signature.sign();
            
            signature.initVerify(ClavesManager.getClavePublica());
            signature.update(FICHERO_MODIFICADO.getBytes());
            
            if (signature.verify(firma)) {
                
                System.out.println("Fichero verificado correctamente");
                
            } else {
                
                System.out.println("¡Atención! El fichero no es fiable");
                
            }
            
        } catch (Exception ex){
            
            System.out.println("Error: " + ex.getMessage());
            
        }
    }
}
