package com.mycompany.garcia_cutillas_francisco_jose_act08_herencia;

import java.time.LocalDate;
import paquete1.Alumno;
import paquete1.Persona;
import paquete2.Profesor;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_Francisco_Jose_Act08_Herencia {

    public static void main(String[] args) {

        creaAlumnoProfesor();

    }

    /**
     * Método utilizado para crear objetos de tipo Alumno y Profesor
     */
    public static void creaAlumnoProfesor() {

        Alumno a1 = new Alumno("11111111A", "Juan", "Rodríguez Carretero",
                LocalDate.of(2000, 10, 9), "1111111", "juan.r@gmail.com");
        Alumno a2 = new Alumno("22222222B", "Antonio", "Ruiz Martínez",
                LocalDate.of(1998, 1, 25), "2222222", "antonio.r@gmail.com");
        Alumno a3 = new Alumno("33333333C", "Pepi", "García Domínguez",
                LocalDate.of(2001, 5, 28), "3333333", "pepi.g@gmail.com");

        Profesor p1 = new Profesor("44444444D", "Cecilia", "Palazón Giménez",
                LocalDate.of(1988, 6, 12), "Inglés");
        Profesor p2 = new Profesor("55555555E", "Evaristo", "Buendía Gil",
                LocalDate.of(1979, 8, 21), "Sistemas");
        Profesor p3 = new Profesor("66666666F", "María", "García Pérez",
                LocalDate.of(1988, 6, 12), "Programación");

        System.out.println("nre A1: " + a1.getNre());
        System.out.println("dni A1: " + a1.getDni());
        System.out.println("Datos A1: " + a1.toString());
        System.out.println("Edad A2: " + a2.getEdad());
        System.out.println("Código centro A1: " + a1.getCodigoCentro());
        System.out.println("Código centro A2: " + a2.getCodigoCentro());
        System.out.println("Nombre completo A2: " + a2.getNombreCompleto());
        System.out.println("¿Es alumno A1 igual que alumno A2?: " + a1.equals(a2));
        System.out.println("¿Es alumno A1 igual que alumno A1?: " + a1.equals(a1));

        System.out.println("¿Es profesor P1 igual que profesor P2?: " + p1.equals(p2));
        System.out.println("¿Es profesor P1 igual que profesor P1?: " + p1.equals(p1));
        System.out.println("Datos profesor P1: " + p1.toString());
        p1.cambiarEspecialidad();
        System.out.println("Especialidad P1: " + p1.getEspecialidad());

        System.out.println("");

        Persona arrayPersonas[] = {a1, p2, a2, a3, p3};
        tipoObjeto(arrayPersonas);
        p1.mostrarInfo();

    }

    /**
     * Método para determinar de qué clase son los objetos de un array que
     * recibe por parámetro
     *
     * @param entrada Array de tipo Persona
     */
    public static void tipoObjeto(Persona[] entrada) {

        int tipoPersona = 0;
        int tipoAlumno = 0;
        int tipoProfesor = 0;

        for (int i = 0; i < entrada.length; i++) {

            if (entrada[i].getClass().getSimpleName().equals("Persona")) {

                tipoPersona++;

            } else if (entrada[i].getClass().getSimpleName().equals("Alumno")) {

                tipoAlumno++;

            } else {

                tipoProfesor++;

            }

        }

        System.out.println("*** Tipos de objetos en el array ***");
        System.out.println("Persona: " + tipoPersona);
        System.out.println("Alumno: " + tipoAlumno);
        System.out.println("Profesor: " + tipoProfesor);

    }
}
