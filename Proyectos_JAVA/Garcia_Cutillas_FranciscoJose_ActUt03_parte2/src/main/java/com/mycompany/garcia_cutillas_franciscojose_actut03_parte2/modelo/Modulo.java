package com.mycompany.garcia_cutillas_franciscojose_actut03_parte2.modelo;

/**
 *
 * @author Fran
 */
public class Modulo {

    private int codigo;
    private String nombre;
    private int horasSemanales;
    private int cursoImparte;

    public Modulo(int codigo, String nombre, int horasSemanales, int cursoImparte) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.cursoImparte = cursoImparte;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getCursoImparte() {
        return cursoImparte;
    }

    public void setCursoImparte(int cursoImparte) {
        this.cursoImparte = cursoImparte;
    }

    @Override
    public String toString() {
        return "        Código = " + codigo + ", Nombre = " + nombre + ", Horas semanales = " + horasSemanales
                + ", Curso que imparte = " + cursoImparte;
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
        final Modulo other = (Modulo) obj;
        return this.codigo == other.codigo;
    }

}
