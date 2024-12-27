package com.franciscojosegarciacutillas.appinstituto.service;

import com.franciscojosegarciacutillas.appinstituto.model.Empresa;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public interface IEmpresaService {
    
    Empresa registrar(Empresa empresa);
    Empresa modificar(Empresa empresa);
    ArrayList<Empresa> listar();
    Empresa obtener(Integer id);
    void eliminar(Integer id);
    
}
