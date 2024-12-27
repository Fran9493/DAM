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

        Persona arrayPersonas[] = {a1, p2, a3, p3};
        tipoObjeto(arrayPersonas);

    }

    /**
     * Método que muestra por pantalla la cantidad de objetos creados de cada
     * clase (Persona, Alumno o Profesor)
     *
     * @param entrada Recibe un array de Persona, Alumno o Profesor
     */
    public static void tipoObjeto(Persona[] entrada) {

        Persona p = new Persona("11111111A", "aaaa", "aaaa aaaa",
                LocalDate.of(2000, 1, 1));
        Alumno a = new Alumno("11111111A", "aaaa", "aaaa aaaa",
                LocalDate.of(2000, 1, 1), "1111111", "aaaa");
        Profesor pro = new Profesor("11111111A", "aaaa", "aaaa aaaa",
                LocalDate.of(2000, 1, 1), "Especialidad");

        int persona = 0;
        int alumno = 0;
        int profesor = 0;

        for (int i = 0; i < entrada.length; i++) {

            if (entrada[i].getClass().getName().equals(p.getClass().getName())) {

                persona++;

            } else if (entrada[i].getClass().getName().equals(a.getClass().getName())) {

                alumno++;

            } else if (entrada[i].getClass().getName().equals(pro.getClass().getName())) {

                profesor++;

            }

        }

        System.out.println("*** Tipos de objetos en el array ***");
        System.out.println("Objetos de tipo Persona: " + persona);
        System.out.println("Objetos de tipo Alumno: " + alumno);
        System.out.println("Objetos de tipo Profesor: " + profesor);

    }
}
