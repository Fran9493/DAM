package com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.dao;

import com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.modelo.Modulo;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public interface ModuloDAO {
    
    int altaModulo(Modulo modulo);
    Modulo consultaModulo(int codigo);
    ArrayList<Modulo> consultaTodos();
    int eliminaModulo(int codigo);
    
}
