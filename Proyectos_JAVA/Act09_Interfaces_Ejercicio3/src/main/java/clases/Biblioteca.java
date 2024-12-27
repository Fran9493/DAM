package clases;

import java.util.Arrays;

/**
 * Clase Biblioteca
 *
 * @author Fran
 */
public class Biblioteca {

    private Publicacion[] publicaciones;

    /**
     * Constructor de la clase
     *
     * @param _publicaciones Array de publicaciones. Pueden ser tanto libros
     * como revistas
     */
    public Biblioteca(Publicacion[] _publicaciones) {

        this.publicaciones = _publicaciones;

    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return True si dos bibliotecas tienen las mismas publicaciones, False en
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
        Biblioteca other = (Biblioteca) obj;
        return Arrays.deepEquals(this.publicaciones, other.publicaciones);
    }

    /**
     * Método toString() de la clase
     *
     * @return Información sobre las publicaciones de la biblioteca en forma de
     * cadena
     */
    @Override
    public String toString() {

        String cadena = "";

        for (int i = 0; i < this.publicaciones.length; i++) {

            if (this.publicaciones[i] != null && i == 0) {

                cadena += this.publicaciones[i].toString();

            } else {

                cadena += "\n" + this.publicaciones[i].toString();

            }

        }

        return cadena;
    }

    /**
     * Método para añadir nuevas publicaciones a la biblioteca
     *
     * @param nuevaPublicacion Publicacion a añadir
     */
    public void addPublicacion(Publicacion nuevaPublicacion) {

        this.publicaciones = Arrays.copyOf(publicaciones, this.publicaciones.length + 1);
        this.publicaciones[this.publicaciones.length - 1] = nuevaPublicacion;

    }

    /**
     * Método que cuenta el número de publicaciones anteriores a un año pasado
     * por parámetro
     *
     * @param ano Año hasta el que se desea contar
     * @return Número de publicaciones anteriores al año pasado por parámetro
     */
    public int numPublicacionesAnterioresA(int ano) {

        int numPublicaciones = 0;

        for (int i = 0; i < this.publicaciones.length; i++) {

            if (this.publicaciones != null && this.publicaciones[i].getAnoPublicacion() < ano) {

                numPublicaciones++;

            }

        }

        return numPublicaciones;

    }

    /**
     * Método que muestra por terminal las publicaciones de la biblioteca
     */
    public void mostrarPublicaciones() {

        System.out.println(toString());

    }

    /**
     * Método que devuelve las publicaciones de la biblioteca
     *
     * @return Publicaciones de la biblioteca
     */
    public Publicacion[] getPublicaciones() {
        return publicaciones;
    }

    /**
     * Método para establecer nuevas publicaciones a la biblioteca
     *
     * @param publicaciones Nueva publicación
     */
    public void setPublicaciones(Publicacion[] publicaciones) {
        this.publicaciones = publicaciones;
    }

}
