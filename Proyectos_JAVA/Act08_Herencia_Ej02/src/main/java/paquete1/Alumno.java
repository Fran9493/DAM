package paquete1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase Alumno que hereda de Persona
 *
 * @author Fran
 */
public class Alumno extends Persona {

    private String nre;
    private final String MAIL;

    /**
     * Constructor para crear objetos de tipo Alumno
     *
     * @param _dni Dni del alumno
     * @param _nombre Nombre del alumno
     * @param _apellidos Apellidos del alumno
     * @param _fechaNacimiento Fecha de nacimiento del alumno de tipo LocalDate
     * @param _nre Nre del alumno
     * @param _mail Mail del alumno
     */
    public Alumno(String _dni, String _nombre, String _apellidos, LocalDate _fechaNacimiento, String _nre, String _mail) {

        super(_dni, _nombre, _apellidos, _fechaNacimiento);
        this.nre = _nre;
        this.MAIL = _mail;

    }

    /**
     * Método toString() de la clase
     *
     * @return Información del alumno en forma de cadena
     */
    @Override
    public String toString() {

        return super.toString() + ", nre: " + this.nre + ", mail: " + this.MAIL;

    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return True si dos objetos tienen el mismo Nre, false en caso contrario
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
        Alumno other = (Alumno) obj;
        return Objects.equals(this.nre, other.nre);
    }

    //Para que no dé error y no tener que hacer la clase Alumno abstracta, debemos desarrollar el método
    //mostrar info de su clase Padre
    /**
     * Método mostrarInfo(). Muestra en forma de lista la información del alumno
     */
    @Override
    public void mostrarInfo() {

        System.out.println("*** Información del Alumno ***");
        System.out.println("Dni: " + this.getDni());
        System.out.println("Nombre y apellidos: " + this.getNombreCompleto());
        System.out.println("Fecha nacimiento: " + this.getFechaNacimiento());
        System.out.println("Nre: " + this.getNre());
        System.out.println("Mail: " + MAIL);
    }

    /**
     * Método para obtener el nre del alumno
     *
     * @return Devuelve el nre del alumno de tipo String
     */
    public String getNre() {
        return nre;
    }

    /**
     * Método para establecer un nuevo nre al alumno
     *
     * @param nre Nre que se vaya a establecer de tipo String
     */
    public void setNre(String nre) {
        this.nre = nre;
    }

}
