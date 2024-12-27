package com.franciscojosegarciacutillas.appinstituto.service;

import com.franciscojosegarciacutillas.appinstituto.model.Practica;
import com.franciscojosegarciacutillas.appinstituto.repository.IPracticaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public class PracticaServiceImpl implements IPracticaService{

    @Autowired
    private IPracticaRepository iRepository;
    
    @Override
    public Practica registrar(Practica practica) {
        return iRepository.save(practica);
    }

    @Override
    public Practica modificar(Practica practica) {
        return iRepository.save(practica);
    }

    @Override
    public ArrayList<Practica> listar() {
        return (ArrayList<Practica>)iRepository.findAll();
    }

    @Override
    public Practica obtener(Integer id) {
        Optional<Practica> op = iRepository.findById(id);
        return op.isPresent() ? op.get() : new Practica();
    }

    @Override
    public void eliminar(Integer id) {
        iRepository.deleteById(id);
    }
    
}
