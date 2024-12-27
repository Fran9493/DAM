package com.mycompany.psp_act2_6_1;

/**
 *
 * @author Fran
 */
public class PSP_Act2_6_1 {

    public static void main(String[] args) {
        
        for (int i = 0; i < 5; i++) {
            
            new Thread(new CreaHilo(i)).start();
            
        }
        
    }
    
    
}
