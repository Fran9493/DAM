package com.mycompany.psp_act4_4;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author Fran
 */
public class LectorEmail {
    
    private Session getSessionImap(){
        
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.store.protocol", "imaps");
        propiedades.setProperty("mail.imap.host", "imap.gmail.com");
        propiedades.setProperty("mail.imap.port", "993");
        propiedades.setProperty("mail.imap.ssl.enable", "true");
        propiedades.setProperty("mail.imap.ssl.trust", "imap.gmail.com");
        Session sesion = Session.getDefaultInstance(propiedades);
        
        return sesion;
        
    }
    
    public void leerCorreos() throws Exception{
        
        Session sesion = this.getSessionImap();
        Store almacen = sesion.getStore("imaps");
               
        almacen.connect("imap.gmail.com","3979199@alu.murciaeduca.es", "trws jaqu kzmx mrwd");
                
        Folder[] folders = almacen.getDefaultFolder().list();
        
        for (Folder fold : folders) {
            
            System.out.println(fold.getName());
            
        }
        
        almacen.close();
        
    }
    
}
