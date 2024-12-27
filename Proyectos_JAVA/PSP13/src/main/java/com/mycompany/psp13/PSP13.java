
package com.mycompany.psp13;

import java.io.IOException;

/**
 *
 * @author Fran
 */
public class PSP13 {

    public static void main(String[] args) {
        
//        try{
//        
//            abreFirefox();
//            
//        }catch(IOException ex) {
//            
//            System.out.println("No se encuentra la ubicación " + ex.getMessage());
//            
//        }
        
        try{   
            
            abreFirefox2();
            
        }catch (IOException ex1) {
            
            System.out.println("No se encuentra la ubicación: " + ex1.getMessage());
            
        } catch (InterruptedException ex2){
            
            System.out.println("Fallo en la espera: " + ex2.getMessage());
            
        }
        
    }
    
    public static void abreFirefox() throws IOException{
        
        String rutaFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
        Runtime.getRuntime().exec(rutaFirefox);
            
    }
    
    public static void abreFirefox2() throws IOException, InterruptedException{
        
        String[] infoProceso = {"C:\\Program Files\\Mozilla Firefox\\firefox.exe", "https://aulavirtual.murciaeduca.es/index.php"};
        Process proceso = Runtime.getRuntime().exec(infoProceso);
        int codigoRetorno = proceso.waitFor();
        System.out.println("Fin de la ejecución: " + codigoRetorno);
        
    }
    
}
