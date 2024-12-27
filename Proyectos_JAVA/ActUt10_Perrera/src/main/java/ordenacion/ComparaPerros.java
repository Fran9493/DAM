package ordenacion;

import clases.Perro;
import java.text.Collator;
import java.util.Comparator;

/**
 * Clase para comparar dos perros. Implementa la interfaz Comparator
 * @author Fran
 */
public class ComparaPerros implements Comparator {

    /**
     * Método compare utilizado para comparar dos perros
     * @param o1 Primer perro a comparar de tipo Perro
     * @param o2 Segundo perro a comparar de tipo Perro
     * @return Perros ordenados por nombre. A igual nombre desempata el código de cada uno
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

        Perro p1 = (Perro) o1;
        Perro p2 = (Perro) o2;

        Collator col = Collator.getInstance();

        if (col.compare(p1.getNombre(), p2.getNombre()) == 0) {

            return p1.getCodigo() - p2.getCodigo();

        } else {

            return col.compare(p1.getNombre(), p2.getNombre());

        }

    }

}
