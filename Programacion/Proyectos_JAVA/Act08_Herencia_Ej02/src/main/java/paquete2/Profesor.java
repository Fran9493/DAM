package paquete2;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import paquete1.Persona;

/**
 * Clase Profesor que hereda de Persona
 *
 * @author Fran
 */
public class Profesor extends Persona {

    private String especialidad;

    /**
     * Constructor para crear objetos de tipo Profesor
     *
     * @param _dni Dni del profesor
     * @param _nombre Nombre del profesor
     * @param _apellidos Apellidos del profesor
     * @param _fechaNacimiento Fecha de nacimiento del Profesor de tipo
     * LocalDate
     * @param _especialidad Especialidad del profesor
     */
    public Profesor(String _dni, String _nombre, String _apellidos, LocalDate _fechaNacimiento, String _especialidad) {

        super(_dni, _nombre, _apellidos, _fechaNacimiento);
        this.especialidad = _especialidad;

    }

    /**
     * Método para cambiar la especialidad del profesor. Ésta se introduce a
     * través de la consola
     */
    public void cambiarEspecialidad() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nueva especialidad:");
        this.especialidad = sc.nextLine();

    }

    /**
     * Método toString() de la clase
     *
     * @return Devuelve en una cadena los datos del profesor
     */
    @Override
    public String toString() {

        return super.toString() + ", especialidad: " + this.especialidad;

    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return True si el Dni de los dos objetos coincide, false en caso
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
        Profesor other = (Profesor) obj;
        return Objects.equals(this.getDni(), other.getDni());
    }

    //Para que no dé error y no tener que hacer la clase Profesor abstracta, debemos desarrollar el método
    //mostrar info de su clase Padre
    /**
     * Método mostrarInfo de profesor. Muestra en forma de lista todos los
     * atributos del objeto
     */
    @Override
    public void mostrarInfo() {

        System.out.println("*** Información del Profesor ***");
        System.out.println("Dni: " + this.getDni());
        System.out.println("Nombre y apellidos: " + this.getNombreCompleto());
        System.out.println("Fecha nacimiento: " + this.getFechaNacimiento());
        System.out.println("Especialidad: " + this.getEspecialidad());

    }

    /**
     * Método que devuelve la especialidad del profesor
     *
     * @return Devuelve la especialidad del profesor de tipo String
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Método para establecer una nueva especialidad al profesor
     *
     * @param especialidad Especialidad que se desee establecer al objeto
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
