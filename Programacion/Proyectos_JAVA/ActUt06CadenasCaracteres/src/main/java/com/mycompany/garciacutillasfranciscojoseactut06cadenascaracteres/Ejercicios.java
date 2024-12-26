package com.mycompany.garciacutillasfranciscojoseactut06cadenascaracteres;

import java.util.Arrays;

/**
 *
 * @author Fran
 */
public class Ejercicios {

    Metodos fun = new Metodos();

    public void ejercicio1() {

        String entrada = "AÁ12aá  eÉé-+*E oOOóÓdsuuÚú iíÍI";

        System.out.println(Arrays.toString(fun.cuentaLetras(entrada)));

    }

    public void ejercicio2() {

        String cadena1 = "Pe";
        String cadena2 = "An";
        String cadena3 = "Iso";

        System.out.println(fun.concatena(cadena1, cadena2, cadena3));

    }

    public void ejercicio3() {

        String cadena1 = "";
        String cadena2 = "MARÍA";
        String cadena3 = "LUCAS";

        System.out.println(Arrays.toString(fun.arrayCharAleatorio(cadena1, cadena2, cadena3)));

    }

    public void ejercicio4() {

        String arrayEntrada[] = {""};

        System.out.println(Arrays.toString(fun.longitudCadena(arrayEntrada)));

    }

    public void ejercicio5() {

        String entrada = "La chica de nieve";

        System.out.println(Arrays.toString(fun.mitadCadena(entrada)));

    }

    public void ejercicio6() {

        String entrada = "Hola me llamo Juan";

        System.out.println(Arrays.toString(fun.cuentaCaracteres(entrada, true)));

    }

}
