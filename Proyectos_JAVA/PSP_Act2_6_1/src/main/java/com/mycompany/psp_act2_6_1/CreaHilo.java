package com.mycompany.psp_act2_6_1;

/**
 *
 * @author Fran
 */
public class CreaHilo extends Thread {
    
    private int id;
    
    public CreaHilo(int _id){
        
        this.id = _id;
        
    }
    
    @Override
    public void run(){
        
        while(true){
            
            System.out.println("Soy el bucle " + this.id + " y estoy trabajando.");
            
            try{
                
                Thread.sleep(1000);
                
            } catch (InterruptedException ex){
                
                System.out.println("Error: " +ex.getMessage());
                
            }
            
        }
        
    }
    
}
