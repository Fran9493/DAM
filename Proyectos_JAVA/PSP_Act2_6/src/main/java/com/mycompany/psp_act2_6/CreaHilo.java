package com.mycompany.psp_act2_6;

/**
 *
 * @author Fran
 */
public class CreaHilo extends Thread{
    
    private int id;
    
    public CreaHilo(int _id){
        
        this.id = _id;
        
    }
    
    @Override
    public void run(){
        
        while(true){
            
            System.out.println("Soy el bucle con identificador " + this.id + " y estoy trabajando.");
            
            try {
                
                Thread.sleep(tiempoAleatorio(1, 10));
            
            } catch (InterruptedException ex) {

                System.out.println("Error: " +ex.getMessage());
            
            }
            
        }
        
    }
    
    public int tiempoAleatorio(int min, int max){
        
        return ((int)(Math.floor(Math.random()*(max-min+1)+min))) * 1000;
        
    }
    
}
