/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_act4_1;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Fran
 */
public class Principal {
    
    public static void main(String[] args) {
        
        try{
            
            String esquema = "https://";
            String servidor = "dle.rae.es/";
            String recurso = URLEncoder.encode("Tiburón", StandardCharsets.UTF_8.name());
            GestorPeticionesHTTP gp = new GestorPeticionesHTTP();
            
            String direccion = esquema + servidor + recurso;
            StringBuilder resultado = gp.getContenidoMetodoGet(direccion);
            GestorPeticionesHTTP.writeFile("C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Programacion_Servicios\\Tareas\\Tema4\\tiburon.html", resultado.toString());
            System.out.println("Descarga finalizada");
            
        }catch(Exception ex){
            
            System.out.println("Error: " + ex.getMessage());
            
        }
        
    }
            
}
