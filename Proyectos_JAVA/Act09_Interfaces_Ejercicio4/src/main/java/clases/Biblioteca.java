package clases;

import interfaces.Prestable;
import java.util.Arrays;

/**
 * Clase Biblioteca
 *
 * @author Fran
 */
public class Biblioteca {

    private Publicacion[] publicaciones;
    private Prestable[] prestados;

    /**
     * Constructor de la clase
     *
     * @param _publicaciones Array de publicaciones. Pueden ser tanto libros
     * como revistas
     */
    public Biblioteca(Publicacion[] _publicaciones) {

        this.publicaciones = _publicaciones;
        this.prestados = new Prestable[0];

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
     * Método para prestar un libro
     *
     * @param codigo Código del libro a prestar
     */
    public void prestarElemento(int codigo) {

        //Comprueba que el libro está en la biblioteca
        for (int i = 0; i < this.publicaciones.length; i++) {

            //Comprueba que la publicación coincide con el código pasado por parámetro
            if (this.publicaciones[i].getCodigo() == codigo) {

                //Comprueba que la publicación es un libro
                if (this.publicaciones[i].getClass().getSimpleName().equals("Libro")) {

                    Libro libro = (Libro) this.publicaciones[i];//Cast a tipo Libro para poder usar sus métodos

                    //Comprueba que el libro no está prestado
                    if (!libro.GetPrestado()) {

                        libro.prestar(); //Presta el libro

                        //Añádelo al array de libros prestados, redimensionando el mismo
                        this.prestados = Arrays.copyOf(this.prestados, this.prestados.length + 1);

                        /*Con el uso del método que cuenta los elementos prestados podemos situarnos en
                          la posición idónea para insertar el siguiente libro prestado*/
                        this.prestados[cuentaPrestados()] = libro;

                        //Si el libro ya está prestado, lo muestra por pantalla
                    } else {

                        System.out.println("El libro con código " + codigo + ", ya está prestado");

                    }

                }

            }

        }

    }

    /**
     * Método que cuenta los libros que hay prestados en la biblioteca
     *
     * @return Número de libros prestados
     */
    public int cuentaPrestados() {

        int totalPrestados = 0;

        for (int i = 0; i < this.prestados.length; i++) {

            if (this.prestados[i] != null) {

                totalPrestados++;

            }

        }

        return totalPrestados;

    }

    /**
     * Método para devolver un libro
     *
     * @param codigo Código del libro
     */
    public void devolverElemento(int codigo) {

        for (int i = 0; i < this.prestados.length; i++) {

            Libro libro = (Libro) this.prestados[i];

            if (libro != null && libro.getCodigo() == codigo && libro.GetPrestado()) {

                libro.devolver();
                this.prestados[i] = null;

            }

        }

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
