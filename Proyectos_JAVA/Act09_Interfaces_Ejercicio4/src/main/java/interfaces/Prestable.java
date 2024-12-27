package interfaces;

/**
 * Interfaz Prestable
 *
 * @author Fran
 */
public interface Prestable {

    /**
     * Método para prestar libros
     */
    public void prestar();

    /**
     * Método para devolver libros
     */
    public void devolver();

    /**
     * Método para consultar estado de los libros
     *
     * @return Si el libro está disponible o no
     */
    public String prestado();

}
