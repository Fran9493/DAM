/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2ev.librosRest.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "libro")
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByFechaPublicacion", query = "SELECT l FROM Libro l WHERE l.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Libro.findByGenero", query = "SELECT l FROM Libro l WHERE l.genero = :genero"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "id_escritor", referencedColumnName = "id_escritor")
    @ManyToOne(optional = false)
    private Escritor idEscritor;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(Integer idLibro, String titulo, String genero, double precio) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Escritor getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Escritor idEscritor) {
        this.idEscritor = idEscritor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.examen2ev.librosRest.model.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
