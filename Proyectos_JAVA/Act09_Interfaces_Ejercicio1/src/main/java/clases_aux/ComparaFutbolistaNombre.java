package clases_aux;

import clases.Futbolista;
import java.text.Collator;
import java.util.Comparator;

/**
 * Clase útil para comparar Futbolistas por su nombre
 * 
 * @author Fran
 */
public class ComparaFutbolistaNombre implements Comparator {

    /**
     * Método compare de la clase
     * @param o1 Objeto 1 a comparar
     * @param o2 Objeto 2 a comparar
     * @return 0 si ambos objetos son iguales, -1 si o2 es nulo o el objeto 1 es menor que el objeto 2,
     *         o 1 si el o1 es nulo o el objeto 1 es mayor que el objeto 2.
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
        
        Collator col = Collator.getInstance();
        
        return col.compare(f1.getNombre(), f2.getNombre());
        
    }
    
}
