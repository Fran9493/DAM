package com.franciscojosegarciacutillas.appinstituto.controller;

import com.franciscojosegarciacutillas.appinstituto.dto.AlumnoConPracticaDTO;
import com.franciscojosegarciacutillas.appinstituto.model.Alumno;
import com.franciscojosegarciacutillas.appinstituto.model.Practica;
import com.franciscojosegarciacutillas.appinstituto.service.AlumnoServiceImpl;
import com.franciscojosegarciacutillas.appinstituto.service.PracticaServiceImpl;
import com.franciscojosegarciacutillas.appinstituto.utilidades.AlumnoPracticaUtil;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/v1")
public class AlumnoController {

    @Autowired
    AlumnoServiceImpl aluServ;
    
    @Autowired
    PracticaServiceImpl pracServ;

    //1.Recuperar todos los alumnos
    @GetMapping("/alumnos")
    public ResponseEntity<ArrayList<AlumnoConPracticaDTO>> getAlumnosConPractica() {

        ArrayList<Alumno> alumnos = aluServ.listar();
        ArrayList<AlumnoConPracticaDTO> alumnosDevolver = new ArrayList<>();

        for (Alumno alumno : alumnos) {

            AlumnoConPracticaDTO nuevoAlumno = new AlumnoConPracticaDTO(alumno);
            alumnosDevolver.add(nuevoAlumno);

        }

        return new ResponseEntity<>(alumnosDevolver, HttpStatus.OK);

    }

    //2.Recuperar los datos de un alumno en concreto
    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumnoId(@PathVariable Integer id) {

        Alumno alumno = aluServ.obtener(id);

        if (alumno.getAlumnoId() == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            return new ResponseEntity<>(alumno, HttpStatus.OK);

        }

    }

    //3.Insertar un alumno sin práctica
    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> postAlumnoSinPractica(@RequestBody Alumno alumno) {

        if (alumno.getAlumnoId()!=null){
            Alumno alumnoExiste = aluServ.obtener(alumno.getAlumnoId());
            if (alumnoExiste.getAlumnoId()!=null){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        
        Alumno alumnoInsertar = aluServ.registrar(alumno);

        return new ResponseEntity<>(alumnoInsertar, HttpStatus.CREATED);

    }

    //4.Actualizar datos de un alumno
    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> putAlumno(@RequestBody Alumno alumno, @PathVariable Integer id) {

        Alumno alumnoModificar = aluServ.obtener(id);

        if (alumnoModificar.getAlumnoId() == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            if (!Objects.equals(alumno.getAlumnoId(), id) && alumno.getAlumnoId() != null) {

                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            } else {

                alumnoModificar.setNombreAlumno(alumno.getNombreAlumno());
                alumnoModificar.setEdad(alumno.getEdad());
                alumnoModificar.setTitulo(alumno.getTitulo());

                alumnoModificar = aluServ.modificar(alumnoModificar);

            }
        }

        return new ResponseEntity<>(alumnoModificar, HttpStatus.OK);

    }

    //5.Insertar una práctica para un alumno
    @PutMapping("/alumnos/practica")
    public ResponseEntity<Practica> putPracticaAlumno(@RequestBody AlumnoPracticaUtil alumnoPracticaUtil){
        
        Practica practicaInsertar = pracServ.obtener(alumnoPracticaUtil.getPracticaId());
        Alumno alumnoPractica = aluServ.obtener(alumnoPracticaUtil.getAlumnoId());
        
        if (practicaInsertar.getPracticaId() == null || alumnoPractica.getAlumnoId() == null) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        } 
        
        practicaInsertar.setAlumnoId(alumnoPractica);
        practicaInsertar = pracServ.modificar(practicaInsertar);
        
        return new ResponseEntity<>(practicaInsertar, HttpStatus.OK);
        
    }
    
    //6.Eliminar un alumno
    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> deleteAlumno(@PathVariable Integer id) {

        Alumno alumno = aluServ.obtener(id);
        if (alumno.getAlumnoId()== null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        aluServ.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
    //7.Devolver todos los alumnos con su práctica de un determinado título
    @GetMapping("/alumnos/titulo/{titulo}")
    public ResponseEntity<ArrayList<AlumnoConPracticaDTO>> getAlumnoTitulo(@PathVariable String titulo){
        
        ArrayList<Alumno> alumnos = aluServ.mostrarAlumnosTitulo(titulo);
        ArrayList<AlumnoConPracticaDTO> alumnosDevolver = new ArrayList<>();

        if (alumnos.isEmpty()) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
        
        for (Alumno alumno : alumnos) {

            AlumnoConPracticaDTO nuevoAlumno = new AlumnoConPracticaDTO(alumno);
            alumnosDevolver.add(nuevoAlumno);

        }

        return new ResponseEntity<>(alumnosDevolver, HttpStatus.OK);
    }
    
    //8.Devolver todos los alumnos que tienen menos de cierta edad
    @GetMapping("/alumnos/edad/{edad}")
    public ResponseEntity<ArrayList<Alumno>> getAlumnoEdadMenorQue(@PathVariable Integer edad){
        
        ArrayList<Alumno> alumnos = aluServ.mostrarAlumnosEdadMenorQue(edad);
        
        if (alumnos.isEmpty()) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
        
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
        
    }
    
    //9.Obtener todos los alumnos que no tienen práctica
    @GetMapping("/alumnos/sinpractica")
    public ResponseEntity<ArrayList<Alumno>> getAlumnosSinPractica(){
        
        ArrayList<Alumno> alumnos = aluServ.mostrarAlumnosSinPractica();
        
        if (alumnos.isEmpty()) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
        
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
        
    }
    
    //10.Obtener todos los alumnos que tienen práctica asignada
    @GetMapping("/alumnos/conpractica")
    public ResponseEntity<ArrayList<Alumno>> getAlumnosConPracticaAsignada(){
        
        ArrayList<Alumno> alumnos = aluServ.mostrarAlumnosConPractica();
        
        if (alumnos.isEmpty()) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
        
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
        
    }
    
}
