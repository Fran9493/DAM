package clases;

import excepciones.PerreraException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Perrera. Con ella podemos crear objetos de tipo Perrera
 *
 * @author Fran
 */
public class Perrera {

    private String nombre;
    private String direccion;
    private ArrayList<Perro> perros;
    private final int maxPerrera = 5;

    /**
     * Constructor de la clase
     *
     * @param _nombre Nombre de la perrera de tipo String
     * @param _direccion Dirección de la perrera de tipo String
     */
    public Perrera(String _nombre, String _direccion) {

        this.nombre = _nombre;
        this.direccion = _direccion;
        this.perros = new ArrayList<>();

    }

    /**
     * Método equals de la clase. Compara dos perreras
     *
     * @param obj Perrera a comparar
     * @return True si dos perreras tienen el mismo nombre y dirección. False en
     * caso contrario
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
        final Perrera other = (Perrera) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.direccion, other.direccion);
    }

    /**
     * Método toString de la clase
     *
     * @return Información de la perrera en una cadena String
     */
    @Override
    public String toString() {
        return "Nombre de la perrera: " + this.nombre + ", Dirección: " + this.direccion + ", Perros en la perrera: " + this.perros.toString();
    }

    /**
     * Método que muestra la información por pantalla de la perrera
     */
    public void mostrarInfo() {

        System.out.println("*** Información de la perrera ***");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("");
        System.out.println("-Perros de la perrera-");
        for (Perro p : this.perros) {

            System.out.println(p);

        }

    }

    /**
     * Método para obtener el nombre de la perrera
     *
     * @return Nombre de la perrera de tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer un nuevo nombre a la perrera
     *
     * @param nombre Nuevo nombre de la perrera de tipo String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la dirección de la perrera
     *
     * @return Dirección de la perrera de tipo String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer una nueva dirección a la perrera
     *
     * @param direccion Nueva dirección de la perrera de tipo String
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener los perros que hay en la perrera
     *
     * @return Perros de la perrera de tipo ArrayList
     */
    public ArrayList getPerros() {
        return perros;
    }

    /**
     * Método para insertar nuevos perros a la perrera
     *
     * @param p Nuevo perro de tipo Perro
     * @return True si lo ha insertado con éxito, False en caso contrario
     * @throws PerreraException Si la perrera está llena
     */
    public boolean intertaPerro(Perro p) throws PerreraException {

        if (this.perros.size() < maxPerrera) {

            if (!this.perros.contains(p)) {
                
                return this.perros.add(p);

            }

        } else {

            throw new PerreraException("La perrera está llena");

        }

        return false;

    }

    /**
     * Método para borrar perros de la perrera
     *
     * @param p Perro a eliminar
     * @return True si ha sido posible eliminarlo, False en caso contrario
     */
    public boolean delPerro(Perro p) {

        return this.perros.remove(p);

    }

}
