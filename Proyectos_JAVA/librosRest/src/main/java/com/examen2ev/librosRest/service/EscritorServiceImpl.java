/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.service;

import com.examen2ev.librosRest.model.Escritor;
import com.examen2ev.librosRest.repository.IEscritorRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public class EscritorServiceImpl implements IEscritorService{

    @Autowired
    private IEscritorRepository eRepository;
    
    @Override
    public Escritor registrar(Escritor escritor) {
        return eRepository.save(escritor);
    }

    @Override
    public Escritor modificar(Escritor escritor) {
        return eRepository.save(escritor);
    }

    @Override
    public ArrayList<Escritor> listar() {
        return (ArrayList<Escritor>) eRepository.findAll();
    }

    @Override
    public Escritor obtener(Integer id) {
        Optional<Escritor> op = eRepository.findById(id);
        return op.isPresent() ? op.get() : new Escritor();
    }

    @Override
    public void eliminar(Integer id) {
        eRepository.deleteById(id);
    }

    @Override
    public ArrayList<Escritor> mostrarVivos(boolean vivo) {
        return (ArrayList<Escritor>) eRepository.mostrarVivos(vivo);
    }

    @Override
    public ArrayList<Escritor> mostrarNacionalidad(String nacionalidad) {
        return (ArrayList<Escritor>) eRepository.findByNacionalidadOrderByFechaNacimientoDesc(nacionalidad);
    }
    
}
