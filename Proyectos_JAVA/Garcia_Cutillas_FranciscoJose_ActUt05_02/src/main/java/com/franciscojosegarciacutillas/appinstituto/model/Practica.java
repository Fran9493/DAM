package com.franciscojosegarciacutillas.appinstituto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "practicas")
@NamedQueries({
    @NamedQuery(name = "Practica.findAll", query = "SELECT p FROM Practica p"),
    @NamedQuery(name = "Practica.findByPracticaId", query = "SELECT p FROM Practica p WHERE p.practicaId = :practicaId"),
    @NamedQuery(name = "Practica.findByFechaInicio", query = "SELECT p FROM Practica p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Practica.findByFechaFin", query = "SELECT p FROM Practica p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Practica.findByDescripcion", query = "SELECT p FROM Practica p WHERE p.descripcion = :descripcion")})
public class Practica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "practica_id")
    private Integer practicaId;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "practicaList")
    @JsonIgnore
    private List<Alumno> alumnoList;
    @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id")
    @ManyToOne
    @JsonIgnore
    private Alumno alumnoId;
    @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Practica() {
    }

    public Practica(Integer practicaId) {
        this.practicaId = practicaId;
    }

    public Practica(Integer practicaId, Date fechaInicio, Date fechaFin, String descripcion) {
        this.practicaId = practicaId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
    }

    public Integer getPracticaId() {
        return practicaId;
    }

    public void setPracticaId(Integer practicaId) {
        this.practicaId = practicaId;
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

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresaId) {
        this.empresa = empresaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (practicaId != null ? practicaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practica)) {
            return false;
        }
        Practica other = (Practica) object;
        if ((this.practicaId == null && other.practicaId != null) || (this.practicaId != null && !this.practicaId.equals(other.practicaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Practica con ID = " + practicaId + ", Fecha de inicio = " + fechaInicio + ", Fecha de fin = " + fechaFin +
                ", Descripción = " + descripcion;
    }

}
