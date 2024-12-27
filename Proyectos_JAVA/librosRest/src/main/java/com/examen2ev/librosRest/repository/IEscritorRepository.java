/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen2ev.librosRest.repository;

import com.examen2ev.librosRest.model.Escritor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fran
 */
@Repository
public interface IEscritorRepository extends JpaRepository<Escritor, Integer>{
    
    @Query("FROM Escritor e WHERE(e.vivo) = :valor")
    List<Escritor> mostrarVivos(@Param("valor") boolean vivo);
    List<Escritor> findByNacionalidadOrderByFechaNacimientoDesc(String nacionalidad);
}
