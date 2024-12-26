package com.mycompany.garcia_cutillas_francisco_jose_act08_herencia_ej03;

import java.time.LocalDate;
import java.time.Period;


/**
 * Clase Persona
 * @author Fran
 */

//Se ha tenido que hacer la clase abstracta, debido a que contiene un método abstracto
public abstract class Persona {
        
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    
    /**
     * Constructor para crear objetos de tipo Persona
     * @param _nombre Nombre de la persona
     * @param _apellidos Apellidos de la persona
     * @param _fechaNacimiento Fecha de nacimiento de la persola de tipo LocalDate
     */
    public Persona (String _nombre, String _apellidos, LocalDate _fechaNacimiento){
      
        this.nombre = _nombre;
        this.apellidos = _apellidos;
        this.fechaNacimiento = _fechaNacimiento;
        
    }
    
    /**
     * Método que devuelve el nombre y apellidos de una persona en forma de String
     * @return Nombre y apellidos de la persona
     */
    public String getNombreCompleto(){
        
        return getNombre() + " " + getApellidos();
        
    }
   
    /**
     * Método que devuelve la edad de la persona
     * @return Edad de la persona 
     */
    public int getEdad(){
        
        LocalDate actual = LocalDate.now();
        Period diferencia = Period.between(this.fechaNacimiento, actual);
        
        return diferencia.getYears();
        
    }

    /**
     * Método toString() de la clase
     * @return Información de la persona en un String
     */
    @Override
    public String toString() {
        return "nombre: " + nombre + ", apellidos: " +
                apellidos + ", fecha de nacimiento: " + fechaNacimiento;
    }
    
    /**
     * Método que devuelve el rol de una persona
     * @return rol de una persona
     */    
    public abstract String getRol();

    /**
     * Método que devuelve el nombre de la persona
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre a una persona
     * @param nombre Nombre de tipo String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve los apellidos de la persona
     * @return Apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que establece los apellidos a la persona
     * @param apellidos Apellidos de la persona de tipo String
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método que devuelve la fecha de nacimiento de la persona
     * @return Fecha de naciemiento de la persona
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que establece la fecha de nacimiento de la persona
     * @param fechaNacimiento Fecha de nacimiento de tipo LocalDate
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
