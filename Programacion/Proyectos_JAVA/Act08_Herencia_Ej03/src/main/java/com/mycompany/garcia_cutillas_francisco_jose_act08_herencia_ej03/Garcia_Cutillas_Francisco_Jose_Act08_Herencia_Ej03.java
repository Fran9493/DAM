package com.mycompany.garcia_cutillas_francisco_jose_act08_herencia_ej03;

import java.time.LocalDate;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_Francisco_Jose_Act08_Herencia_Ej03 {

    public static void main(String[] args) {
        
        Actor a1 = new Actor("Antonio", "Banderas", LocalDate.of(1965, 1, 1),
                            175, "666666666", "1");
        Actor a2 = new Actor("Jason", "Statan", LocalDate.of(1969, 5, 7),
                            181,"Inglés", "666666888", "2");
        Actor a3 = new Actor("Vin", "Diesel", LocalDate.of(1970, 6, 10),
                            179, "666669999", "3");
        Actor a4 = new Actor("Juan", "Córcoles", LocalDate.of(1975, 8, 10),
                            177, "666669979", "4");
        
        Director d1 = new Director("Álex", "De la iglesia", LocalDate.of(1956, 6, 10),
                             "11111111A", "Terror");
        Director d2 = new Director("Pepe", "De los muebles", LocalDate.of(1963, 9, 20),
                             "22222222B", "Comedia");
        Director d3 = new Director("Juanico", "Colorao", LocalDate.of(1959, 12, 30),
                             "33333333C", "Acción");
        
        Actor arrayActor[] = {a1,a3};
        Actor arrayActor1[] = {a1, a3, a2};
        Pelicula p = new Pelicula("Muerte", 2023, 80, arrayActor, d1);
        Pelicula p1 = new Pelicula("Muerte2", 2023, 120, arrayActor1, d2);
        
        System.out.println(p.participa(a1));
        System.out.println(p.participa(a2));
        System.out.println(p.participa(d1));
        System.out.println("-------------------------------------");
        p.mostrarInfo();
        p1.mostrarInfo();
        System.out.println("-------------------------------------");
        System.out.println(p.equals(p1));        
        
        Persona arrayPersonas[] = {a1, a2, a3, a4, d1, d2, d3};
        System.out.println("-------------------------------------");
        p.addPersona(arrayPersonas);
        p.mostrarInfo();
        System.out.println("-------------------------------------");
        p1.addPersona(arrayPersonas);
        p1.mostrarInfo();
        
       
    }
}
