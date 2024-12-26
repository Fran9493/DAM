package com.mycompany.garcia_cutillas_francisco_jose_act08_herencia_ej03;

import java.util.Arrays;
import java.util.Objects;

/**
 * Clase Película
 *
 * @author Fran
 */
public class Pelicula {

    private String nombre;
    private int año;
    private int duracion;
    private Actor[] actores;
    private Director director;

    /**
     * Constructor para construir objetos de tipo Película
     *
     * @param _nombre Nombre de la película
     * @param _año Año de la película
     * @param _duracion Duración de la película en minutos
     * @param _actores Array de actores partícipes en la película de tipo Actor
     * y máximo índice 3
     * @param _director Director de la película de tipo Director
     */
    public Pelicula(String _nombre, int _año, int _duracion, Actor[] _actores, Director _director) {

        this.nombre = _nombre;
        this.año = _año;
        this.duracion = _duracion;

        if (_actores.length <= 3) {

            this.actores = Arrays.copyOf(_actores, 3);

        } else {

            this.actores = Arrays.copyOf(_actores, 3);

        }

        this.director = _director;

    }

    /**
     * Método toString() de la clase
     *
     * @return Devuelve los datos de la película en un String
     */
    @Override
    public String toString() {

        return "Nombre película: " + this.getNombre() + ", año: " + this.getAño() + ", duración: " + this.getDuracion()
                + ", actores " + Arrays.toString(this.getActores()) + ", director: " + this.getDirector();

    }

    /**
     * Método equals de la clase. Dos películas son iguales si coinciden en año
     * y nombre
     *
     * @param obj Recibe un objeto con el que queremos comparar
     * @return True si son iguales o false en el caso contrario
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
        Pelicula other = (Pelicula) obj;
        if (this.año != other.año) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    /**
     * Método mostrarInfo() de la clase. Muestra por pantalla la información de
     * la película, así como los datos de su director y actores que participan
     * en la misma
     */
    public void mostrarInfo() {

        System.out.println("*** Información de la película ***");
        System.out.println("Director:");

        System.out.println(director.toString());

        System.out.println("Actores:");
        for (int i = 0; i < this.actores.length; i++) {

            if (actores[i] != null) {

                System.out.println(actores[i].toString());

            }

        }

    }

    /**
     * Método que devuelve si una persona participa en una película o no. En el
     * caso de participar, nos muestra cuál es su rol dentro de la película
     *
     * @param p Objeto de tipo persona que queremos comprobar si es partícipe de
     * la película
     * @return Devuelve 'D' si la persona introducida es el director de la
     * película, 'A' si es actor ó 'N' si no participa en la misma
     */
    public char participa(Persona p) {

        if (p.getClass().getSimpleName().equals("Director")) {

            if (this.director.equals(p)) {

                return 'D';

            }

        } else {

            for (int i = 0; i < this.actores.length; i++) {

                if (actores[i] != null) {

                    if (actores[i].equals(p)) {

                        return 'A';

                    }

                }

            }

        }

        return 'N';

    }

    /**
     * Método que añade una persona de forma aleatoria a la película, contenida
     * en un array que se le pasa como parámetro. Si esta persona es director,
     * se asigna directamente. Si es actor, se añade al array de actores en el
     * primer hueco libre del mismo. Si el array está completo, lo añade en la
     * primera posición, sobreescribiendo el que ya hay.
     *
     * @param p Array de personas
     */
    public void addPersona(Persona[] p) {

        int numAleatorio = (int) (Math.random() * (((p.length - 1) - 0) + 1)) + 0;
        Persona personaSeleccionada = p[numAleatorio];

        if (personaSeleccionada.getRol().equals("Director")) {

            this.director = (Director) personaSeleccionada;

        } else if (personaSeleccionada.getRol().equals("Actor")) {

            if (estadoActores() == 0) {

                this.actores[0] = (Actor) personaSeleccionada;

            } else {

                for (int i = 0; i < this.actores.length; i++) {

                    if (this.actores[i] == null) {

                        this.actores[i] = (Actor) personaSeleccionada;
                        break;

                    }

                }

            }

        }

    }

    /**
     * Método que devuelve el número de huecos que hay en el array de actores de
     * la película
     *
     * @return número de huecos libres en el array de actores de la película
     */
    public int estadoActores() {

        int huecosArray = 0;

        for (int i = 0; i < this.actores.length; i++) {

            if (this.actores[i] == null) {

                huecosArray++;

            }

        }

        return huecosArray;

    }

    /**
     * Método que devuelve el nombre de la película
     *
     * @return nombre de la película
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer un nombre a la película
     *
     * @param nombre Nombre para la película
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el año de la película
     *
     * @return año de la película
     */
    public int getAño() {
        return año;
    }

    /**
     * Método para establecer el año de la película
     *
     * @param año Año de la película
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Método para obtener la duración de la película
     *
     * @return Duración de la película
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Método para establecer la duración de la película
     *
     * @param duracion Duración de la película en minutos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Método que devuelve los actores de la película
     *
     * @return Devuelve un array de los actores de la película
     */
    public Persona[] getActores() {
        return actores;
    }

    /**
     * Método que establece los actores de la película
     *
     * @param actores Array de actores de tipo Actor
     */
    public void setActores(Actor[] actores) {
        this.actores = actores;
    }

    /**
     * Método que devuelve el director de la película
     *
     * @return Devuelve el director de la película de tipo Director
     */
    public Persona getDirector() {
        return director;
    }

    /**
     * Método que establece el director de la película
     *
     * @param director Director de tipo Director
     */
    public void setDirector(Director director) {
        this.director = director;
    }

}
