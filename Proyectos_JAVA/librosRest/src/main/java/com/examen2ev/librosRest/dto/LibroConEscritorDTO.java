/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.dto;

import com.examen2ev.librosRest.model.Libro;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Fran
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LibroConEscritorDTO {
    
    private String titulo;
    private Date fechaPublicacion;
    private String genero;
    private double precio;
    private String nombreEscritor;

    public LibroConEscritorDTO(Libro libro) {
        this.titulo = libro.getTitulo();
        this.fechaPublicacion = libro.getFechaPublicacion();
        this.genero = libro.getGenero();
        this.precio = libro.getPrecio();
        this.nombreEscritor = libro.getIdEscritor().getNombre();
    }
    
    
    
}
