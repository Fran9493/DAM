package com.franciscojosegarciacutillas.appinstituto.service;

import com.franciscojosegarciacutillas.appinstituto.model.Practica;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public interface IPracticaService {
    
    Practica registrar(Practica practica);
    Practica modificar(Practica practica);
    ArrayList<Practica> listar();
    Practica obtener(Integer id);
    void eliminar(Integer id);
    
}
