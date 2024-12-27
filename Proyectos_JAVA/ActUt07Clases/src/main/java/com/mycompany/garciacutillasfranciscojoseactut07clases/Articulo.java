package com.mycompany.garciacutillasfranciscojoseactut07clases;

/**
 *
 * @author Fran
 */
public class Articulo {

    enum TipoIva {

        GENERAL, REDUCIDO, SUPERREDUCIDO;

    }

    private static final int IVAGENERAL = 21;
    private static final int IVAREDUCIDO = 10;
    private static final int IVASUPERREDUCIDO = 4;

    private String nombre;
    private double precioSinIva;
    private int iva;

    public Articulo(String _nombre, double _precioSinIva, TipoIva _iva) {

        this.nombre = _nombre;

        //Comprobación de que no introduzcan precio en negativo
        if (_precioSinIva < 0) {

            System.out.println("Error. No se puede introducir un precio negativo a un artículo");
            this.precioSinIva = 0;

        } else {

            this.precioSinIva = _precioSinIva;

        }

        if (_iva.equals(TipoIva.GENERAL)) {

            this.iva = IVAGENERAL;

        } else if (_iva.equals(TipoIva.REDUCIDO)) {

            this.iva = IVAREDUCIDO;

        } else {

            this.iva = IVASUPERREDUCIDO;

        }

    }

    //Método para mostrar la información de la compra
    public void muestraInformacion() {

        System.out.println("*** INFORMACIÓN DEL ARTÍCULO ***");
        System.out.println("Nombre artículo: " + this.nombre);
        System.out.println("Precio sin iva: " + this.precioSinIva + "€");
        System.out.println("Iva aplicado al producto: " + this.iva + "%");

    }

    //Método que devuelve el precio con iva del producto
    public double getPVP() {

        return this.precioSinIva * (((double) this.iva / 100) + 1);

    }

    //Método que devuelve el precio con iva del producto aplicándole un descuento pasado por parámetro
    public double getPVPDescuento(int descuento) {

        return getPVP() - (getPVP() * ((double) descuento / 100));

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(double precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public double getIva() {
        return iva;
    }

}
