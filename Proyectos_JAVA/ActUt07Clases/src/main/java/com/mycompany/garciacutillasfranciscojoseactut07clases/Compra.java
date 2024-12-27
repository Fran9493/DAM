package com.mycompany.garciacutillasfranciscojoseactut07clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Fran
 */
public class Compra {

    private Persona persona;
    private Articulo articulo[];
    private int cantidad[];
    private LocalDate fecha;

    public Compra(Persona _persona, Articulo _articulo[], int _cantidad[], LocalDate _fecha) {

        this.persona = _persona;
        this.articulo = _articulo;
        this.cantidad = _cantidad;
        this.fecha = _fecha;

    }

    //Método para mostrar la información de la compra
    public void mostrarInfo() {

        System.out.println("*** INFORMACIÓN DE LA COMPRA ***");
        System.out.println("Artículo       Cantidad       PVP");
        System.out.println("---------------------------------");

        for (int i = 0; i < this.articulo.length; i++) {

            System.out.println(this.articulo[i].getNombre() + "                "
                    + this.cantidad[i] + "     " + this.articulo[i].getPVP());

        }

        System.out.println(" ");
        System.out.println("Total de la compra          " + precioTotal() + "€");

        System.out.println("---------------------------------");
        System.out.println("Fecha de compra: " + this.fecha);

    }

    //Método para calcular el precio total de los productos de la compra
    public double precioTotal() {

        double total = 0;

        for (int i = 0; i < this.articulo.length; i++) {

            total += this.cantidad[i] * this.articulo[i].getPVP();

        }

        return total;

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Articulo[] getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo[] articulo) {
        this.articulo = articulo;
    }

    public int[] getCantidad() {
        return cantidad;
    }

    public void setCantidad(int[] cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
