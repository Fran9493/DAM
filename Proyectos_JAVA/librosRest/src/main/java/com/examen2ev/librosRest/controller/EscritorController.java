/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.controller;

import com.examen2ev.librosRest.dto.EscritorPersonalizadoDTO;
import com.examen2ev.librosRest.model.Escritor;
import com.examen2ev.librosRest.service.EscritorServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class EscritorController {
    
    @Autowired
    EscritorServiceImpl escServ;

    //Mostrar todos los escritores sin sus libros
    @GetMapping("/escritores")
    public ResponseEntity<ArrayList<Escritor>> getEscritores() {

        ArrayList<Escritor> escritores = escServ.listar();
        
        return new ResponseEntity<>(escritores, HttpStatus.OK);

    }
    
    //Mostrar los datos de un escritor dado sin sus libros
    @GetMapping("/escritores/{id}")
    public ResponseEntity<Escritor> getEscritor(@PathVariable Integer id) {

        Escritor escritor = escServ.obtener(id);

        if (escritor.getIdEscritor() == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            return new ResponseEntity<>(escritor, HttpStatus.OK);

        }

    }
    
    //Mostrar los datos de escritores vivos o no
    @GetMapping("/escritores/vivos/{vivo}")
    public ResponseEntity<ArrayList<Escritor>> getEscritoresVivos(@PathVariable boolean vivo){
        
        ArrayList<Escritor> escritores = escServ.mostrarVivos(vivo);
        
        return new ResponseEntity<>(escritores, HttpStatus.OK);
        
    }
    
    //Insertar un escritor
    @PostMapping("/escritores")
    public ResponseEntity<Escritor> postEscritor(@RequestBody Escritor escritor) {

        Escritor escritorRegistrar = escServ.registrar(escritor);

        return new ResponseEntity<>(escritorRegistrar, HttpStatus.CREATED);

    }
    
    //Actualizar datos de un escritor
    @PutMapping("/escritores/{id}")
    public ResponseEntity<Escritor> putEscritor(@RequestBody Escritor escritor, @PathVariable Integer id) {

        Escritor escritorModificar = escServ.obtener(id);

        if (escritorModificar.getIdEscritor()== null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            if (!Objects.equals(escritor.getIdEscritor(), id) && escritor.getIdEscritor() != null) {

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            } else {

                escritorModificar.setNombre(escritor.getNombre());
                escritorModificar.setFechaNacimiento(escritor.getFechaNacimiento());
                escritorModificar.setNacionalidad(escritor.getNacionalidad());
                escritorModificar.setVivo(escritor.getVivo());

                escritorModificar = escServ.modificar(escritorModificar);

            }
        }

        return new ResponseEntity<>(escritorModificar, HttpStatus.OK);

    }
    
    //Mostrar los datos de un escritor junto con sus libros
    @GetMapping("/escritores/libros")
    public ResponseEntity<ArrayList<EscritorPersonalizadoDTO>> getEscritoresConLibros(){
        
        ArrayList<Escritor> escritores = escServ.listar();
        ArrayList<EscritorPersonalizadoDTO> escritoresDevolver = new ArrayList<>();
        
        for(Escritor escritor : escritores){
            
            EscritorPersonalizadoDTO escritorLibro = new EscritorPersonalizadoDTO(escritor);
            escritoresDevolver.add(escritorLibro);
            
        }
        return new ResponseEntity<>(escritoresDevolver, HttpStatus.OK);
        
    }
    
    //Mostrar todos los escritores ordenados por su fecha de nacimiento
    @GetMapping("/escritores/nacionalidad/{nacionalidad}")
    public ResponseEntity<ArrayList<Escritor>> getEscritorNacionalidad(@PathVariable String nacionalidad) {

        ArrayList<Escritor> escritores = escServ.mostrarNacionalidad(nacionalidad);

        return new ResponseEntity<>(escritores, HttpStatus.OK);

    }
    
    
    
    
    
}
