package com.franciscojosegarciacutillas.appinstituto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "alumnos")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByAlumnoId", query = "SELECT a FROM Alumno a WHERE a.alumnoId = :alumnoId"),
    @NamedQuery(name = "Alumno.findByNombreAlumno", query = "SELECT a FROM Alumno a WHERE a.nombreAlumno = :nombreAlumno"),
    @NamedQuery(name = "Alumno.findByEdad", query = "SELECT a FROM Alumno a WHERE a.edad = :edad"),
    @NamedQuery(name = "Alumno.findByTitulo", query = "SELECT a FROM Alumno a WHERE a.titulo = :titulo")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alumno_id")
    private Integer alumnoId;
    @Basic(optional = false)
    @Column(name = "nombre_alumno")
    private String nombreAlumno;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @JoinTable(name = "alumnoscandpracticas", joinColumns = {
        @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id")}, inverseJoinColumns = {
        @JoinColumn(name = "practica_id", referencedColumnName = "practica_id")})
    @ManyToMany
    @JsonIgnore
    private List<Practica> practicaList;
    @OneToOne(mappedBy = "alumnoId")
    @JsonIgnore
    private Practica practica;

    public Alumno() {
    }

    public Alumno(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Alumno(Integer alumnoId, String nombreAlumno, int edad, String titulo) {
        this.alumnoId = alumnoId;
        this.nombreAlumno = nombreAlumno;
        this.edad = edad;
        this.titulo = titulo;
    }

    public Alumno(String nombreAlumno, int edad, String titulo) {
        this.nombreAlumno = nombreAlumno;
        this.edad = edad;
        this.titulo = titulo;
    }
    
    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Practica> getPracticaList() {
        return practicaList;
    }

    public void setPracticaList(List<Practica> practicaList) {
        this.practicaList = practicaList;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoId != null ? alumnoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.alumnoId == null && other.alumnoId != null) || (this.alumnoId != null && !this.alumnoId.equals(other.alumnoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumno con ID = " + alumnoId + ", Nombre = " + nombreAlumno + ", Edad = " + edad + ", Título = " + titulo;
    }

}
