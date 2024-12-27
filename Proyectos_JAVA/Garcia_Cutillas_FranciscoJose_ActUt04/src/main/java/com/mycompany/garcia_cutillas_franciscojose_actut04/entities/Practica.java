package com.mycompany.garcia_cutillas_franciscojose_actut04.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "Practicas", catalog = "fct")
public class Practica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practica_id")
    private int id;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToMany(mappedBy = "listaPracticas")
    private List<Alumno> listaAlumnos;

    public Practica() {
    }

    public Practica(Date fechaInicio, Date fechaFin, String descripcion, Empresa empresa, Alumno alumno) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.alumno = alumno;
    }

    public Practica(Date fechaInicio, Date fechaFin, String descripcion, Empresa empresa) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Practica other = (Practica) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        if (alumno != null) {

            return "Practica con id= " + id + ", Fecha de inicio= " + fechaInicio
                    + ", Fecha de fin= " + fechaFin + ", Descripción= " + descripcion
                    + ", ID de la empresa= " + empresa.getId() + ", ID del alumno= " + alumno.getId();

        } else {

            return "Practica con id= " + id + ", Fecha de inicio= " + fechaInicio
                    + ", Fecha de fin= " + fechaFin + ", Descripción= " + descripcion
                    + ", ID de la empresa= " + empresa.getId() + ", Alumno sin asignar ";

        }

    }

}
