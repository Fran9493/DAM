/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.psp_casopractico5_1;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;

/**
 *
 * @author Fran
 */
public class PSP_CasoPractico5_1 {

    public static void main(String[] args) {
        
        //Se define el tipo de algoritmo como MessageDigest
        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();
        
        //Se obtiene la lista de los proveedores de seguridad instalados
        Provider[] proveedores = Security.getProviders();
        for(Provider proveedor : proveedores){
            
            //Por cada proveedor se obtiene el conjunto de servicios
            Set<Service> servicios = proveedor.getServices();
            
            for(Service servicio : servicios){
                
                if(servicio.getType().equals(TIPO_MESSAGE_DIGEST)){
                    
                    System.out.println(servicio.getAlgorithm());
                    
                }
                
            }
        }
        
    }
}
