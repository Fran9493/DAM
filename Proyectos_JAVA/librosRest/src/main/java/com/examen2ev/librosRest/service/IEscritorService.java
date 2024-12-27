/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen2ev.librosRest.service;

import com.examen2ev.librosRest.model.Escritor;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public interface IEscritorService {
    Escritor registrar(Escritor escritor);
    Escritor modificar(Escritor escritor);
    ArrayList<Escritor> listar();
    Escritor obtener(Integer id);
    void eliminar(Integer id);
    ArrayList<Escritor> mostrarVivos(boolean vivo);
    ArrayList<Escritor> mostrarNacionalidad(String nacionalidad);
}
