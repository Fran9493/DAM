package com.franciscojosegarciacutillas.appinstituto.service;

import com.franciscojosegarciacutillas.appinstituto.model.Empresa;
import com.franciscojosegarciacutillas.appinstituto.repository.IEmpresaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public class EmpresaServiceImpl implements IEmpresaService{

    @Autowired
    private IEmpresaRepository iRepository;
    
    @Override
    public Empresa registrar(Empresa empresa) {
        return iRepository.save(empresa);
    }

    @Override
    public Empresa modificar(Empresa empresa) {
        return iRepository.save(empresa);
    }

    @Override
    public ArrayList<Empresa> listar() {
        return (ArrayList<Empresa>)iRepository.findAll();
    }

    @Override
    public Empresa obtener(Integer id) {
        Optional<Empresa> op = iRepository.findById(id);
        return op.isPresent() ? op.get() : new Empresa();
    }

    @Override
    public void eliminar(Integer id) {
        iRepository.deleteById(id);
    }
    
}
