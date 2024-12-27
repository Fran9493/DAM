package com.mycompany.garcia_cutillas_franciscojose_actut02;

import java.text.Collator;
import java.util.Objects;

/**
 *
 * @author Fran
 */
public class Vehiculo implements Comparable {
    
    private String marca;
    private String modelo;
    private int anoMatricula;
    private String color;
    private String matricula;
    
    public Vehiculo(String _marca, String _modelo, int _anoMatricula, String _color, String _matricula){
        
        this.marca = _marca;
        this.modelo = _modelo;
        this.anoMatricula = _anoMatricula;
        this.color = _color;
        this.matricula = _matricula;
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(int anoMatricula) {
        this.anoMatricula = anoMatricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public String toString() {
        return "Marca= " + marca + ", Modelo= " + modelo + ", Año de Matriculación= " + anoMatricula + ", Color= " + color + 
                ", Matrícula= " + matricula;
    }

    @Override
    public int compareTo(Object o) {
        
        if (this == o) {

            return 0;

        }

        if (o == null) {

            return -1;

        }

        Vehiculo v = (Vehiculo) o;

        Collator col = Collator.getInstance();

        return this.marca.compareTo(v.getMarca());
        
    }
    
    
    
}
