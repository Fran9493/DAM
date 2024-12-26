package clases;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase Publicación. Superclase de Libro y Revista de tipo abstracta
 *
 * @author Fran
 */
public abstract class Publicacion {

    private int codigo;
    private String titulo;
    private int anoPublicacion;

    /**
     * Constructor de la clase
     *
     * @param _codigo Código del ejemplar
     * @param _titulo Título del ejemplar
     * @param _anoPublicacion Año de publicación del ejemplar
     */
    Publicacion(int _codigo, String _titulo, int _anoPublicacion) {

        this.codigo = _codigo;
        this.titulo = _titulo;

        if (_anoPublicacion > 0 && _anoPublicacion <= LocalDate.now().getYear()) {

            this.anoPublicacion = _anoPublicacion;

        } else {

            System.out.println("No has introducido un año correcto");

        }

    }

    /**
     * Método toString() de la clase
     *
     * @return Información del ejemplar en forma de cadena
     */
    @Override
    public String toString() {
        return "Código: " + this.codigo + ", Título: " + this.titulo + ", Año de publicación: " + this.anoPublicacion;
    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return True si el objeto coincide en código, título y año de publicación
     * False en caso contrario
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
        Publicacion other = (Publicacion) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.anoPublicacion != other.anoPublicacion) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }

    /**
     * Método para obtener el código de un ejemplar
     *
     * @return Código del ejemplar
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método para establecer un nuevo código al ejemplar
     *
     * @param codigo Nuevo código
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para obtener el título del ejemplar
     *
     * @return Título del ejemplar
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para establecer un nuevo título al ejemplar
     *
     * @param titulo Nuevo título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para obtener el año de publicación del ejemplar
     *
     * @return Año de publicación
     */
    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    /**
     * Método para establecer un nuevo año de publicación del ejemplar
     *
     * @param anoPublicacion Nuevo año de publicación
     */
    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

}
