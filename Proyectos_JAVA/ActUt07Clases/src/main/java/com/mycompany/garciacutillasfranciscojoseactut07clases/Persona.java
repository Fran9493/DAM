package com.mycompany.garciacutillasfranciscojoseactut07clases;

import utilidades.Dni;

/**
 *
 * @author Fran
 */
public class Persona {

    private final String dni;
    private final static int mayoriaEdad = 18;

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int edad;

    public Persona(String _dni, String _nombre, String _primerApellido, String _segundoApellido, int _edad) {

        //Con el método compruebaDni de la clase Dni en el paquete utilidades, comprobamos que el dni
        //introducido sea correcto
        if (Dni.compruebaDni(_dni)) {

            this.dni = _dni;

        } else {

            System.out.println("El DNI introducido no es correcto");
            this.dni = null;

        }

        this.nombre = _nombre;
        this.primerApellido = _primerApellido;
        this.segundoApellido = _segundoApellido;

        //Si la edad introducida es negativa, se asigna 0 a edad
        if (_edad < 0) {

            this.edad = 0;

        } else {

            this.edad = _edad;

        }

    }

    public Persona(String _dni, String _nombre, String _primerApellido, int _edad) {

        this(_dni, _nombre, _primerApellido, null, _edad);

    }

    //Método que muestra por pantalla la información de la persona
    public void imprime() {

        System.out.println("*** INFORMACIÓN DE LA PERSONA ***");
        System.out.println("DNI: " + this.dni);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellidos: " + getApellidos());
        System.out.println("Edad: " + this.edad);

    }

    //Método que devuelve true si es mayor de edad y false si no lo es
    public boolean esMayorEdad() {

        if (this.edad >= mayoriaEdad) {

            return true;

        } else {

            return false;

        }

    }

    //Método que devuelve true si tiene más de 65 años y false si no
    public boolean esJubilado() {

        if (this.edad >= 65) {

            return true;

        } else {

            return false;

        }

    }

    //Método que devuelve la diferencia de edad de dos personas
    public int diferenciaEdad(Persona p) {

        return Math.abs(this.edad - p.getEdad()); //No le gusta a Guillermo el absoluto

    }

    //Método que devuelve true si la persona tiene la misma edad que otra persona pasada por parámetro
    public boolean esMayor(Persona p) {

        if (this.edad >= p.getEdad()) {

            return true;

        } else {

            return false;

        }

    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {

        return this.primerApellido + " " + this.segundoApellido;

    }

}
