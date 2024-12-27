/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen2ev.librosRest.service;

import com.examen2ev.librosRest.model.Libro;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public interface ILibroService {
    Libro registrar(Libro libro);
    Libro modificar(Libro libro);
    ArrayList<Libro> listar();
    Libro obtener(Integer id);
    void eliminar(Integer id);
}
