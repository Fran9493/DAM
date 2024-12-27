package com.mycompany.psp_act4_4;

/**
 *
 * @author Fran
 */
public class PSP_Act4_4 {

    public static void main(String[] args) {
        
        try{
            
            new LectorEmail().leerCorreos();
            
        }catch(Exception e){
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
    }
}
