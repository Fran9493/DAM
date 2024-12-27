package com.mycompany.psp_act2_6;

/**
 *
 * @author Fran
 */
public class PSP_Act2_6 {

    public static void main(String[] args) {
        
        for (int i = 0; i < 5; i++) {
            
            new Thread(new CreaHilo(i)).start();
            
        }
        
    }
}
