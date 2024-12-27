package com.mycompany.garcia_cutillas_francisco_jose_act08_herencia_ej03;

import java.time.LocalDate;
import java.util.Objects;
import utilidades.Dni;

/**
 * Clase Director que hereda de Persona
 * @author Fran
 */
public class Director extends Persona{
    
    private String dni;
    private String generoFavorito;
    
    /**
     * Constructor de la clase. Crea objetos de tipo Director
     * @param _nombre Nombre del director
     * @param _apellidos Apellidos del director
     * @param _fechaNacimiento Fecha de nacimiento del director de tipo LocalDate
     * @param _dni Dni del director
     * @param _generoFavorito Género favorito del director
     */
    public Director(String _nombre, String _apellidos, LocalDate _fechaNacimiento, String _dni, 
                        String _generoFavorito){
        
        super(_nombre, _apellidos, _fechaNacimiento);
        
        if (Dni.compruebaDni(_dni )) {
        
            this.dni = _dni;
            
        } else {
            
            this.dni = null;
            System.out.println("Dni incorrecto");
            
        }
        
        this.generoFavorito = _generoFavorito;
        
        
    }
    
    /**
     * Método toString() de la clase
     * @return Información del director en una cadena
     */
    @Override
    public String toString(){
        
        return super.toString() + ", Dni: " + this.getDni() + ", Género Favorito: " + this.getGeneroFavorito();
        
    }

    /**
     * Método equals de la clase. Dos directores son iguales si tienen el mismo dni
     * @param obj Objeto a comparar
     * @return True si coinciden los dos dni, false en el caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Director other = (Director) obj;
        return Objects.equals(this.dni, other.dni);
    }  
    
    /**
     * Método que devuelve el rol
     * @return Devuelve la cadena "Director" de tipo String
     */
    @Override
    public String getRol(){
        
        return "Director";
        
    }
    
    /**
     * Método que devuelve el dni del director
     * @return Dni del director de tipo String
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método que devuelve el género favorito del director
     * @return Género favorito del director de tipo String
     */
    public String getGeneroFavorito() {
        return generoFavorito;
    }

    /**
     * Método para establecer el género favorito del director
     * @param generoFavorito Género favorito del director en forma de String
     */
    public void setGeneroFavorito(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }
    
    
    
}
