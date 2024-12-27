/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.dto;

import com.examen2ev.librosRest.model.Escritor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Fran
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EscritorSinLibrosDTO {
    
    private String nombre;

    public EscritorSinLibrosDTO(Escritor escritor) {
        this.nombre = escritor.getNombre();;
    }
    
}
