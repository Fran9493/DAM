package com.mycompany.garcia_cutillas_franciscojose_actut04.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "Empresas", catalog = "fct")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private int id;

    @Column(name = "nombre_empresa")
    private String nombre;

    @Column(name = "sector")
    private String sector;

    @OneToMany(mappedBy = "empresa")
    private List<Practica> listaPracticas;

    public Empresa() {
    }

    public Empresa(String nombre, String sector) {
        this.nombre = nombre;
        this.sector = sector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Practica> getListaPracticas() {
        return listaPracticas;
    }

    public void setListaPracticas(List<Practica> listaPracticas) {
        this.listaPracticas = listaPracticas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
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
        final Empresa other = (Empresa) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        if (listaPracticas.size() != 0) {
            return "Empresa con id= " + id + ", Nombre= " + nombre + ", Sector= "
                    + sector + ", Prácticas asignadas= " + listaPracticas.size();
        } else {
            return "Empresa con id= " + id + ", Nombre= " + nombre + ", Sector= "
                    + sector + ", sin prácticas asignadas";

        }
    }
}
