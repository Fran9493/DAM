package com.mycompany.garcia_cutillas_franciscojose_actut04.entities;

import com.mycompany.garcia_cutillas_franciscojose_actut04.excepciones.EdadException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "Alumnos", catalog = "fct")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private int id;

    @Column(name = "nombre_alumno")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "titulo")
    private String titulo;

    @OneToOne(mappedBy = "alumno")
    private Practica practica;

    @ManyToMany
    @JoinTable(name = "AlumnosCandPracticas",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "practica_id"))
    private List<Practica> listaPracticas;

    public Alumno() {
    }

    public Alumno(String nombre, int edad, String titulo) throws EdadException {
        this.nombre = nombre;
        setEdad(edad);
        this.titulo = titulo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadException {
        if (edad < 16) {
            throw new EdadException();
        } else {
            this.edad = edad;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
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
        hash = 37 * hash + this.id;
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
        final Alumno other = (Alumno) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        if (practica != null) {

            return "Alumno con id " + id + ", Nombre= " + nombre + ", Edad= " + edad
                    + ", Título= " + titulo + ", Empresa de prácticas= " + practica.getEmpresa().getNombre();

        } else {

            return "Alumno con id " + id + ", Nombre= " + nombre + ", Edad= " + edad
                    + ", Título= " + titulo + ", Prácticas sin asignar";

        }

    }

}
