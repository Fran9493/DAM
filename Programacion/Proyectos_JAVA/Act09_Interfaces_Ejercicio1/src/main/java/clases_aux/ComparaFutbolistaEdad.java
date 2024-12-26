package clases_aux;

import clases.Futbolista;
import java.util.Comparator;

/**
 * Clase útil para comparar futbolistas por su edad. En caso de que la edad sea
 * igual, compara por nombre
 *
 * @author Fran
 */
public class ComparaFutbolistaEdad implements Comparator {

    /**
     * Método compare de la clase
     *
     * @param o1 Objeto 1 a comparar
     * @param o2 Objeto 2 a comparar
     * @return 0 si ambos objetos son iguales, -1 si o2 es nulo o el objeto 1 es
     * menor que el objeto 2, o 1 si el o1 es nulo o el objeto 1 es mayor que el
     * objeto 2.
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

        Futbolista f1 = (Futbolista) o1;
        Futbolista f2 = (Futbolista) o2;

        if (f1.getEdad() == f2.getEdad()) {

            ComparaFutbolistaNombre c1 = new ComparaFutbolistaNombre();

            return c1.compare(o1, o2);

        } else if (f1.getEdad() > f2.getEdad()) {

            return 1;

        } else {

            return -1;

        }

    }

}
