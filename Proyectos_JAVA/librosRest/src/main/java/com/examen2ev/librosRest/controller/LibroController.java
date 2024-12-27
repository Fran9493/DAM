/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.controller;

import com.examen2ev.librosRest.dto.LibroConEscritorDTO;
import com.examen2ev.librosRest.model.Escritor;
import com.examen2ev.librosRest.model.Libro;
import com.examen2ev.librosRest.service.EscritorServiceImpl;
import com.examen2ev.librosRest.service.LibroServiceImpl;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fran
 */
@RestController
@RequestMapping("/FranGarcia/examenLibros")
public class LibroController {
    @Autowired
    LibroServiceImpl libServ;
    EscritorServiceImpl escServ;

    //Obtener todos los libros con su escritor
    @GetMapping("/libros")
    public ResponseEntity<ArrayList<LibroConEscritorDTO>> getLibros() {

        ArrayList<Libro> libros = libServ.listar();
        ArrayList<LibroConEscritorDTO> librosDevolver = new ArrayList<>();
        
        for(Libro libro : libros){
            
            LibroConEscritorDTO libroEscritor = new LibroConEscritorDTO(libro);
            librosDevolver.add(libroEscritor);
            
        }
        return new ResponseEntity<>(librosDevolver, HttpStatus.OK);

    }
    
    //Cambiar el escritor de un libro
    @PutMapping("/libros/cambiarEscritor/{idLibro}/{idEscritor}")
    public ResponseEntity<Libro> putLibroEscritor(@PathVariable Integer idLibro , @PathVariable Integer idEscritor){
        
        Libro libroModificar = libServ.obtener(idLibro);
        Escritor escritorIntroducir = escServ.obtener(idEscritor);
        
        if (libroModificar.getIdLibro()== null || escritorIntroducir.getIdEscritor()== null) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        } else {
            
            libroModificar.setIdEscritor(escritorIntroducir);
            
            libroModificar = libServ.modificar(libroModificar);
            
        }
        
        return new ResponseEntity<>(libroModificar, HttpStatus.OK);
        
    }
//    public ResponseEntity<Libro> putLibroEscritor(@RequestBody Escritor escritor, @PathVariable Integer id) {
//
//        Libro libroModificar = libServ.obtener(id);
//
//        if (libroModificar.getIdLibro()== null) {
//
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        } else {
//            if (!Objects.equals(escritor.getIdEscritor(), id) && escritor.getIdEscritor() != null) {
//
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//            } else {
//
//                libroModificar.setIdEscritor(escritor);
//
//                libroModificar = libServ.modificar(libroModificar);
//
//            }
//        }
//
//        return new ResponseEntity<>(libroModificar, HttpStatus.OK);
//
//    }
}
