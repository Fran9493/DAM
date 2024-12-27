/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.dto;

import com.examen2ev.librosRest.model.Escritor;
import com.examen2ev.librosRest.model.Libro;
import java.util.ArrayList;
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
public class EscritorPersonalizadoDTO {
    
    private Integer idEscritor;
    private String nombre;
    private String nacionalidad;
    private boolean vivo;
    private ArrayList<LibroPersonalizadoDTO> libros;

    public EscritorPersonalizadoDTO(Escritor escritor) {
        this.idEscritor = escritor.getIdEscritor();
        this.nombre = escritor.getNombre();
        this.nacionalidad = escritor.getNacionalidad();
        this.vivo = escritor.getVivo();
        
        ArrayList<Libro> librosEscritor = (ArrayList<Libro>) escritor.getLibroList();
        ArrayList<LibroPersonalizadoDTO> librosAux = new ArrayList<>();
        
        for(Libro libro : librosEscritor){
            
            String titulo = libro.getTitulo();            
            Date fecha = libro.getFechaPublicacion();
            String genero = libro.getGenero();
            
            LibroPersonalizadoDTO libroPers = new LibroPersonalizadoDTO(titulo, fecha, genero);
            librosAux.add(libroPers);
            
        }
        
        this.libros = librosAux;
    }
    
    
    
}
