package clases_aux;

import clases.BarajaEs;
import java.text.Collator;
import java.util.Comparator;

/**
 * Clase para comparar cartas por palo y número
 *
 * @author Fran
 */
public class ComparaCartaPaloNum implements Comparator {

    /**
     * Método compare de la Interfaz Comparator
     *
     * @param o1 Objeto 1 a comparar
     * @param o2 Objeto 2 a comparar
     * @return 0 si las dos cartas son del mismo número o palo, 1 si o1 es mayor
     * que o2 ó -1 si o1 es menor que o2
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

        if (b1.getPalo() == b2.getPalo()) {

            ComparaCartaNum c1 = new ComparaCartaNum();

            return c1.compare(o1, o2);

        }

        Collator col = Collator.getInstance();

        return col.compare(b1.getPalo().toString(), b2.getPalo().toString());

    }

}
