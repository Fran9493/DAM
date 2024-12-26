package clases;

import interfaces.Prestable;

/**
 * Clase Libro que hereda de Publicación
 *
 * @author Fran
 */
public class Libro extends Publicacion implements Prestable {

    private boolean prestado;

    /**
     * Constructor de la clase
     *
     * @param _codigo Codigo del libro
     * @param _titulo Título del libro
     * @param _anoPublicacion Año de publicación del libro
     */
    public Libro(int _codigo, String _titulo, int _anoPublicacion) {

        super(_codigo, _titulo, _anoPublicacion);
        this.prestado = false;

    }

    /**
     * Método toString() de la clase
     *
     * @return Información del libro en una cadena
     */
    @Override
    public String toString() {
        return super.toString() + ", Prestado: " + prestadoCadena(this.prestado);
    }

    /**
     * Método para convertir el boolean del estado del libro en cadena
     *
     * @param libro Estado del libro
     * @return Si el estado es true, devuelve "Sí", en caso contrario devuelve
     * "No"
     */
    private String prestadoCadena(boolean estadoLibro) {

        if (estadoLibro) {

            return "Sí";

        }

        return "No";

    }

    /**
     * Método que devuelve si el libro está prestado o no
     *
     * @return True si está prestado, False en caso contrario
     */
    public boolean GetPrestado() {
        return prestado;
    }

    /**
     * Método para establecer si un libro está prestado o no
     *
     * @param prestado Estado del libro (Prestado: True, no prestado: False)
     */
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    /**
     * Método de la interfaz Prestable que nos permite poner un libro como
     * prestado
     */
    @Override
    public void prestar() {

        this.prestado = true;

    }

    /**
     * Método de la interfaz Prestable que nos permite poner un libro como
     * disponible
     */
    @Override
    public void devolver() {

        this.prestado = false;

    }

    /**
     * Método de la interfaz Prestable que nos permite consultar el estado de un
     * libro
     *
     * @return Prestado si el libro no está disponible, o disponible en caso
     * contrario
     */
    @Override
    public String prestado() {

        if (this.prestado) {

            return "Prestado";

        }

        return "Disponible";

    }

}
