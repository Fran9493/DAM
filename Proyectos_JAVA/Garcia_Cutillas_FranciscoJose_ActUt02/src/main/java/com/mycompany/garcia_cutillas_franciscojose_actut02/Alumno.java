package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Fran
 */
public class Alumno implements Comparable {

    private String nre;
    private String nombre;
    private String apellidos;
    private String telefono;
    private LocalDate fechaNac;
    private boolean beca;

    public Alumno(String _nre, String _nombre, String _apellidos, String _telefono, LocalDate _fechaNac, boolean _beca) {

        this.nre = _nre;
        this.nombre = _nombre;
        this.apellidos = _apellidos;
        this.telefono = _telefono;
        this.fechaNac = _fechaNac;
        this.beca = _beca;

    }

    @Override
    public String toString() {

        String becario;

        if (beca) {

            becario = "Sí";

        } else {

            becario = "No";

        }

        return "NRE= " + nre + ", Nombre= " + nombre + ", Apellidos= " + apellidos + ", Teléfono= " + telefono + ", Fecha de nacimiento= " + fechaNac
                + ", Becario= " + becario;
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
        return Objects.equals(this.nre, other.nre);
    }

    public String getNre() {
        return nre;
    }

    public void setNre(String nre) {
        this.nre = nre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String esBecario() {

        if (beca) {
            return "Si";
        } else {
            return "No";
        }

    }

    public void setBeca(boolean beca) {
        this.beca = beca;
    }

    //Método para comparar dos alumnos por apellidos y nombre
    @Override
    public int compareTo(Object o) {

        if (this == o) {

            return 0;

        }

        if (o == null) {

            return -1;

        }

        Alumno a = (Alumno) o;

        Collator col = Collator.getInstance();

        int comparaApellidos = this.apellidos.compareTo(a.getApellidos());

        if (comparaApellidos == 0) {

            return this.nombre.compareTo(a.nombre);

        }

        return comparaApellidos;

    }

}
