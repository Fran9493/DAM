package clases;

import java.text.Collator;
import java.util.Objects;

/**
 * Clase Futbolista
 *
 * @author Fran
 */
public class Futbolista implements Comparable {

    private String dni;
    private String nombre;
    private int edad;
    private int num_goles;

    /**
     * Constructor de la clase que recibe todos los parámetros
     *
     * @param _dni
     * @param _nombre
     * @param _edad
     * @param _num_goles
     */
    public Futbolista(String _dni, String _nombre, int _edad, int _num_goles) {

        this.dni = _dni;
        this.nombre = _nombre;
        this.edad = _edad;
        this.num_goles = _num_goles;

    }

    /**
     * Constructor de la clase que recibe todos los parámetros menos el número
     * de goles que será por defecto 0
     *
     * @param _dni
     * @param _nombre
     * @param _edad
     */
    public Futbolista(String _dni, String _nombre, int _edad) {

        this(_dni, _nombre, _edad, 0);

    }

    /**
     * Método toString de la clase
     *
     * @return Devuelve los datos del futbolista
     */
    @Override
    public String toString() {

        return "DNI: " + this.dni + ", Nombre: " + this.nombre
                + ", Edad: " + this.edad + ", Número de goles: " + this.num_goles;

    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return Devuelve true si el objeto es igual que el introducido por
     * parámetro. Dos futbolistas son iguales si tienen el mismo DNI
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
        Futbolista other = (Futbolista) obj;
        return Objects.equals(this.dni, other.dni);
    }

    /**
     * Método compareTo para comparar dos DNIs
     *
     * @param o Objeto con el que queremos comparar
     * @return Número negativo si el objeto es nulo o si el DNI es menor que el
     * introducido, 0 si los DNis son iguales o son el mismo objeto o un número
     * positivo si el DNI es mayor que el introducido
     */
    @Override
    public int compareTo(Object o) {

        if (this == o) {

            return 0;

        }

        if (o == null) {

            return -1;

        }

        Futbolista f = (Futbolista) o;

        Collator col = Collator.getInstance();

        return col.compare(this.getDni(), f.getDni());

    }

    /**
     * Método para obtener el DNI del Futbolista
     *
     * @return DNI del Futbolista
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método para establecer un nuevo DNI al Futbolista
     *
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Método para obtener el nombre del Futbolista
     *
     * @return Nombre del Futbolista
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer un nuevo nombre al Futbolista
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la edad del Futbolista
     *
     * @return Edad del Futbolista
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método para establecer una nueva edad al Futbolista
     *
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método para obtener el número de goles del Futbolista
     *
     * @return Número de goles del Futbolista
     */
    public int getNum_goles() {
        return num_goles;
    }

    /**
     * Método para establecer un nuevo número de goles al Futbolista
     *
     */
    public void setNum_goles(int num_goles) {
        this.num_goles = num_goles;
    }

}
