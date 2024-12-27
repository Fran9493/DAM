/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.psp_casopractico5_2;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class RegistradorCredenciales {
    
    private static final String ENCODING_TYPE = "UTF-8";
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce identificador (email):");
        String identificador = sc.nextLine();
        System.out.println("Introduce la contraseña:");
        String password = sc.nextLine();
        
        try{
            
            byte[] resumen = HASHManager.getDigest(password.getBytes(ENCODING_TYPE));
            Files.write(new File(identificador + ".credencial").toPath(), resumen);
            mostrarResumenHexadecimal(resumen);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
        sc.close();
        
    }
    
    private static void mostrarResumenHexadecimal(byte[] resumen){
        
        String resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));
        System.out.println(resumenHexadecimal);
        
    }
    
}
