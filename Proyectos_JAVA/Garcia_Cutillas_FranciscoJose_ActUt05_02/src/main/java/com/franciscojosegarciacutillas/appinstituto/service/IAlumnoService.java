package com.franciscojosegarciacutillas.appinstituto.service;

import com.franciscojosegarciacutillas.appinstituto.model.Alumno;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public interface IAlumnoService {

    Alumno registrar(Alumno alumno);
    Alumno modificar(Alumno alumno);
    ArrayList<Alumno> listar();
    Alumno obtener(Integer id);
    void eliminar(Integer id);    
    ArrayList<Alumno> mostrarAlumnosTitulo(String titulo);    
    ArrayList<Alumno> mostrarAlumnosEdadMenorQue(Integer edad);    
    ArrayList<Alumno> mostrarAlumnosSinPractica();
    ArrayList<Alumno> mostrarAlumnosConPractica();
    
}
