package com.franciscojosegarciacutillas.appinstituto.service;

import com.franciscojosegarciacutillas.appinstituto.model.Alumno;
import com.franciscojosegarciacutillas.appinstituto.repository.IAlumnoRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public class AlumnoServiceImpl implements IAlumnoService {
    
    @Autowired
    private IAlumnoRepository iRepository;
    
    @Override
    public Alumno registrar(Alumno alumno) {
        return iRepository.save(alumno);
    }
    
    @Override
    public Alumno modificar(Alumno alumno) {
        return iRepository.save(alumno);
    }
    
    @Override
    public ArrayList<Alumno> listar() {
        return (ArrayList<Alumno>) iRepository.findAll();
    }
    
    @Override
    public Alumno obtener(Integer id) {
        Optional<Alumno> op = iRepository.findById(id);
        return op.isPresent() ? op.get() : new Alumno();
    }
    
    @Override
    public void eliminar(Integer id) {
        iRepository.deleteById(id);
    }

    @Override
    public ArrayList<Alumno> mostrarAlumnosTitulo(String titulo) {
        return (ArrayList<Alumno>) iRepository.findByTitulo(titulo);
    }

    @Override
    public ArrayList<Alumno> mostrarAlumnosEdadMenorQue(Integer edad) {
        return (ArrayList<Alumno>) iRepository.findByEdadLessThan(edad);
    }

    @Override
    public ArrayList<Alumno> mostrarAlumnosSinPractica() {
        return (ArrayList<Alumno>) iRepository.findByPracticaNull();
    }

    @Override
    public ArrayList<Alumno> mostrarAlumnosConPractica() {
        return (ArrayList<Alumno>) iRepository.findByPracticaNotNull();
    }
    
}
