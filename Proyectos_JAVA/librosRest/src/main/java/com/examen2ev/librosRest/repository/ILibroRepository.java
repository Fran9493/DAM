/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen2ev.librosRest.repository;

import com.examen2ev.librosRest.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fran
 */
@RestController
public interface ILibroRepository extends JpaRepository<Libro, Integer>{
    
}
