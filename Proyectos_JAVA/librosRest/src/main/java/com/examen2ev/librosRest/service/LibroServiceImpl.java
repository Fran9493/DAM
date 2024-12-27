/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.service;

import com.examen2ev.librosRest.model.Libro;
import com.examen2ev.librosRest.repository.ILibroRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public class LibroServiceImpl implements ILibroService{

    @Autowired
    private ILibroRepository lRepository;
    
    @Override
    public Libro registrar(Libro libro) {
        return lRepository.save(libro);
    }

    @Override
    public Libro modificar(Libro libro) {
        return lRepository.save(libro);
    }

    @Override
    public ArrayList<Libro> listar() {
        return (ArrayList<Libro>) lRepository.findAll();
    }

    @Override
    public Libro obtener(Integer id) {
        Optional<Libro> op = lRepository.findById(id);
        return op.isPresent() ? op.get() : new Libro();
    }

    @Override
    public void eliminar(Integer id) {
        lRepository.deleteById(id);
    }
    
}
