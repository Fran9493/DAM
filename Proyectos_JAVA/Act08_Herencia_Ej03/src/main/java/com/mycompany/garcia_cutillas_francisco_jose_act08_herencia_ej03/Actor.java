package com.mycompany.garcia_cutillas_francisco_jose_act08_herencia_ej03;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase Actor que hereda de Persona
 * @author Fran
 */
public class Actor extends Persona {
    
    private int altura;
    private String idiomaPrincipal;
    private String telefonoRepresentante;
    private String codigoActor;
    
    /**
     * Constructor para crear objetos de tipo Actor
     * @param _nombre Nombre del actor
     * @param _apellidos Apellidos del actor
     * @param _fechaNacimiento Fecha de nacimiento del actor de tipo LocalDate
     * @param _altura Altura del actor en centímetros
     * @param _idiomaPrincipal Idioma principal del actor
     * @param _telefonoRepresentante Teléfono del representante del actor
     * @param _codigoActor Código del actor
     */    
    public Actor(String _nombre, String _apellidos, LocalDate _fechaNacimiento, int _altura,
                    String _idiomaPrincipal, String _telefonoRepresentante, String _codigoActor){
        
        super(_nombre, _apellidos, _fechaNacimiento);
        this.altura = _altura;
        this.idiomaPrincipal = _idiomaPrincipal;
        this.telefonoRepresentante = _telefonoRepresentante;
        this.codigoActor = _codigoActor;
        
    }
    
    /**
     * Constructor para crear objetos de tipo Actor. No recibe el idioma principal, por lo que por defecto
     * asigna castellano como idioma principal del actor
     * @param _nombre Nombre del actor
     * @param _apellidos Apellidos del actor
     * @param _fechaNacimiento Fecha de nacimiento del actor de tipo LocalDate
     * @param _altura Altura del actor en centímetros
     * @param _telefonoRepresentante Teléfono del representante del actor
     * @param _codigoActor Código del actor
     */
    public Actor(String _nombre, String _apellidos, LocalDate _fechaNacimiento, int _altura,
                    String _telefonoRepresentante, String _codigoActor){
        
        this(_nombre, _apellidos, _fechaNacimiento, _altura, "Castellano", _telefonoRepresentante, _codigoActor);
        
    }
    
    /**
     * Método toString() de la clase
     * @return Devuelve la información del Actor en forma de cadena
     */
    @Override
    public String toString(){
        
        return super.toString() + ", Altura: " + this.getAltura() + ", Idioma principal: " + this.getIdiomaPrincipal() +
                ", Teléfono representante: " + this.getTelefonoRepresentante() + ", Código actor: " + this.getCodigoActor();
        
    }

    /**
     * Método equals de la clase. Dos actores son iguales si tienen el mismo código de actor
     * @param obj Objeto a comparar
     * @return True si son el mismo actor, false en el caso contrario
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
        Actor other = (Actor) obj;
        return Objects.equals(this.codigoActor, other.codigoActor);
    }
    
    /**
     * Método que devuelve el rol
     * @return Devuelve la cadena "Actor"
     */
    @Override
    public String getRol(){
        
        return "Actor";
        
    }

    /**
     * Método que devuelve la altura del actor
     * @return Devuelve la altura del actor en centímetros
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Método que establece la altura del actor
     * @param altura Altura del actor en centímetros
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Método que devuelve el idioma principal del actor
     * @return Idioma principal del actor en tipo String
     */
    public String getIdiomaPrincipal() {
        return idiomaPrincipal;
    }

    /**
     * Método que establece el idioma principal del actor
     * @param idiomaPrincipal Idioma principal
     */
    public void setIdiomaPrincipal(String idiomaPrincipal) {
        this.idiomaPrincipal = idiomaPrincipal;
    }

    /**
     * Método que devuelve el teléfono del representante del actor
     * @return Teléfono del representante del actor en tipo String
     */
    public String getTelefonoRepresentante() {
        return telefonoRepresentante;
    }

    /**
     * Método para establecer el teléfono del representante del actor
     * @param telefonoRepresentante Teléfono del representante de tipo String
     */
    public void setTelefonoRepresentante(String telefonoRepresentante) {
        this.telefonoRepresentante = telefonoRepresentante;
    }

    /**
     * Método que devuelve el código del actor
     * @return Devuelve el código del actor en forma de String
     */
    public String getCodigoActor() {
        return codigoActor;
    }

    /**
     * Método que establece el código de actor
     * @param codigoActor Código de actor en forma de String
     */
    public void setCodigoActor(String codigoActor) {
        this.codigoActor = codigoActor;
    }
    
    
    
}
