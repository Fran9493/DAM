package com.franciscojosegarciacutillas.appinstituto.repository;

import com.franciscojosegarciacutillas.appinstituto.model.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Fran
 */
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
        
    List<Alumno> findByTitulo(String titulo);
    List<Alumno> findByEdadLessThan(Integer edad);
    @Query("FROM Alumno a WHERE a.practica is null")
    List<Alumno> findByPracticaNull();
    @Query("FROM Alumno a WHERE a.practica is not null")
    List<Alumno> findByPracticaNotNull();
    
}
