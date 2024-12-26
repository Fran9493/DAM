package paquete1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import utilidades.Dni;

/**
 * Clase Persona
 *
 * @author Fran
 */
public class Persona {

    private static final String CODIGO_CENTRO = "44443333";
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    /**
     * Constructor de la clase. Crea objetos de tipo Persona
     *
     * @param _dni Dni de la persona
     * @param _nombre Nombre de la persona
     * @param _apellidos Apellidos de la persona
     * @param _fechaNacimiento Fecha de nacimiento de la persona
     */
    public Persona(String _dni, String _nombre, String _apellidos, LocalDate _fechaNacimiento) {

        //Comprueba que el dni sea correcto
        if (Dni.compruebaDni(_dni)) {

            this.dni = _dni;

        } else {

            this.dni = null;
            System.out.println("Dni incorrecto");

        }

        this.nombre = _nombre;
        this.apellidos = _apellidos;
        this.fechaNacimiento = _fechaNacimiento;

    }

    /**
     * Método para obtener el nombre y apellidos de la persona
     *
     * @return Devuelve el nombre y apellidos de la persona en una cadena
     */
    public String getNombreCompleto() {

        return getNombre() + " " + getApellidos();

    }

    /**
     * Método para obtener el código del centro
     *
     * @return Código del centro
     */
    public String getCodigoCentro() {

        return CODIGO_CENTRO;

    }

    /**
     * Método para obtener la edad de la persona
     *
     * @return Edad de la persona de tipo int
     */
    public int getEdad() {

        LocalDate actual = LocalDate.now();
        Period diferencia = Period.between(this.fechaNacimiento, actual);

        return diferencia.getYears();

    }

    /**
     * Método toString() de la clase
     *
     * @return Devuelve la información de la persona en una cadena
     */
    @Override
    public String toString() {
        return "dni: " + dni + ", nombre: " + nombre + ", apellidos: "
                + apellidos + ", fecha de nacimiento: " + fechaNacimiento;
    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return Devuelve true si dos personas tienen el mismo dni, false en caso
     * contrario
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
        Persona other = (Persona) obj;
        return Objects.equals(this.dni, other.dni);
    }

    /**
     * Método para obtener el dni de la persona
     *
     * @return Dni de la persona de tipo String
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método para establecer el dni de la persona
     *
     * @param dni Nuevo dni a establecer
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Método para obtener el nombre de la persona
     *
     * @return Devuelve el nombre de la persona de tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de la persona
     *
     * @param nombre Nombre a establecer a la persona de tipo String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener los apellidos de la persona
     *
     * @return Apellidos de la persona de tipo String
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método para establecer apellidos a la persona
     *
     * @param apellidos Apellidos a establecer a la persona de tipo String
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método para obtener la fecha de nacimiento de la persona
     *
     * @return Fecha de nacimiento de la persona de tipo LocalDate (aaaa-mm-dd)
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento de la persona
     *
     * @param fechaNacimiento Fecha de nacimiento de la persona de tipo
     * LocalDate y formato (aaaa-mm-dd)
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
