/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.model;

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
@Table(name = "escritor")
@NamedQueries({
    @NamedQuery(name = "Escritor.findAll", query = "SELECT e FROM Escritor e"),
    @NamedQuery(name = "Escritor.findByIdEscritor", query = "SELECT e FROM Escritor e WHERE e.idEscritor = :idEscritor"),
    @NamedQuery(name = "Escritor.findByNombre", query = "SELECT e FROM Escritor e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Escritor.findByFechaNacimiento", query = "SELECT e FROM Escritor e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Escritor.findByNacionalidad", query = "SELECT e FROM Escritor e WHERE e.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Escritor.findByVivo", query = "SELECT e FROM Escritor e WHERE e.vivo = :vivo")})
public class Escritor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_escritor")
    private Integer idEscritor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @Column(name = "vivo")
    private boolean vivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEscritor")
    @JsonIgnore
    private List<Libro> libroList;

    public Escritor() {
    }

    public Escritor(Integer idEscritor) {
        this.idEscritor = idEscritor;
    }

    public Escritor(Integer idEscritor, String nombre, String nacionalidad, boolean vivo) {
        this.idEscritor = idEscritor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.vivo = vivo;
    }

    public Integer getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Integer idEscritor) {
        this.idEscritor = idEscritor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscritor != null ? idEscritor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escritor)) {
            return false;
        }
        Escritor other = (Escritor) object;
        if ((this.idEscritor == null && other.idEscritor != null) || (this.idEscritor != null && !this.idEscritor.equals(other.idEscritor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.examen2ev.librosRest.model.Escritor[ idEscritor=" + idEscritor + " ]";
    }
    
}
