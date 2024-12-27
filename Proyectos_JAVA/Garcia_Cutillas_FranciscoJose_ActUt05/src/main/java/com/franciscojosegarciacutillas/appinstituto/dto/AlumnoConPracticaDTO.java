package com.franciscojosegarciacutillas.appinstituto.dto;

import com.franciscojosegarciacutillas.appinstituto.model.Alumno;
import com.franciscojosegarciacutillas.appinstituto.model.Practica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Fran
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AlumnoConPracticaDTO {
    
    private String nombre;
    private int edad;
    private String titulo;
    private Practica practica;
    
    public AlumnoConPracticaDTO(Alumno alumno){
        
        this.nombre = alumno.getNombreAlumno();
        this.edad = alumno.getEdad();
        this.titulo = alumno.getTitulo();
        this.practica = alumno.getPractica(); 
        
    }
    
}
