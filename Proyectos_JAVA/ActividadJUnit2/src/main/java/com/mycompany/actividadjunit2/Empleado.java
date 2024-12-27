/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadjunit2;

/**
 *
 * @author guillermopalazoncano
 */
public class Empleado {
    
    public int registraEntradaEmpleado(Integer empleado, Integer departamento, String oficio){
        int resultado = 0;
        
        // Control de errores.
        if (empleado < 100 || empleado > 999){
            resultado = -1;
        } else if ((departamento != null) && (departamento.toString().length() != 2)) {
            resultado = -2;
        } else if (!oficio.equals("Analista") && !oficio.equals("Diseñador") && !oficio.equals("Programador")){
            resultado = -3;
        } else {
            // Asignamos sueldo
            if (oficio.equals("Analista")){
                resultado = 2500;
            } else if (oficio.equals("Diseñador")){
                resultado = 1500;
            } else if (oficio.equals("Programador")){
                resultado = 2000;
            }
        }
        return resultado;
    }

    
}
