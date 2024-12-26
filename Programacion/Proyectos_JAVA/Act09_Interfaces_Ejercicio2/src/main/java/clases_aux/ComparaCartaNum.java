package clases_aux;

import clases.BarajaEs;
import java.util.Comparator;

/**
 * Clase para comparar cartas por número
 *
 * @author Fran
 */
public class ComparaCartaNum implements Comparator {

    /**
     * Método compare de la Interfaz Comparator
     *
     * @param o1 Objeto 1 a comparar
     * @param o2 Objeto 2 a comparar
     * @return 0 si las dos cartas son del mismo número, 1 si o1 es mayor que o2
     * ó -1 si o1 es menor que o2
     */
    @Override
    public int compare(Object o1, Object o2) {

        if (o1 == o2) {

            return 0;

        }

        if (o2 == null) {

            return -1;

        }

        if (o1 == null) {

            return 1;

        }

        BarajaEs b1 = (BarajaEs) o1;
        BarajaEs b2 = (BarajaEs) o2;

        if (b1.getNumero() == b2.getNumero()) {

            return 0;

        } else if (b1.getNumero() > b2.getNumero()) {

            return 1;

        } else {

            return -1;

        }

    }

}
