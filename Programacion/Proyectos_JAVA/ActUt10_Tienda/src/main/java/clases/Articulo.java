package clases;

import excepciones.ArticuloException;
import java.util.Objects;

/**
 * Clase Artículo
 *
 * @author Fran
 */
public abstract class Articulo {

    private String codigo;
    private String nombre;
    private String material;
    private String color;
    private double precio;
    private int stock;

    /**
     * Constructor de la Clase
     *
     * @param _codigo Código del artículo de tipo int
     * @param _nombre Nombre del artículo de tipo String
     * @param _material Material del artículo de tipo String
     * @param _color Color del artículo de tipo String
     * @param _precio Precio del artículo de tipo double
     * @param _stock Stock en almacén del artículo de tipo int
     * @throws ArticuloException
     */
    public Articulo(String _codigo, String _nombre, String _material, String _color, double _precio, int _stock) throws ArticuloException {

        this.codigo = _codigo;
        this.nombre = _nombre;
        this.material = _material;
        this.color = _color;
        setPrecio(_precio);
        setStock(_stock);

    }

    /**
     * Método equals de la clase
     *
     * @param obj Artículo a comparar
     * @return True si dos artículos tienen el mismo código. False en caso
     * contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        final Articulo other = (Articulo) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    /**
     * Método toString de la clase
     *
     * @return Información del artículo en forma de cadena
     */
    @Override
    public String toString() {
        return "Código de artículo: " + this.codigo + ", Nombre del artículo: " + this.nombre + ", Material: " + this.material
                + ", Color: " + this.color + ", Precio del artículo: " + this.precio + "€" + ", Stock: " + stock;
    }

    /**
     * Método que devuelve el precio total del stock de un artículo
     *
     * @return Valor total en formato double del stock de un artículo
     */
    public double totalValor() {

        return (this.stock * this.precio);

    }

    /**
     * Método mostrarInfo que se debe desarrollar en las Clases que hereden de
     * Artículo
     */
    public abstract void mostrarInfo();

    /**
     * Método para obtener el código de un Artículo
     *
     * @return Código de un artículo de tipo String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método para establecer un nuevo código a un Artículo
     *
     * @param codigo Nuevo código del Artículo de tipo String
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para obtener el nombre de un Artículo
     *
     * @return Nombre del Artículo de tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer un nuevo nombre a un Artículo
     *
     * @param nombre Nuevo nombre del Artículo de tipo String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el material de un Artículo
     *
     * @return Material del Artículo de tipo String
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Método para establecer un nuevo material al Artículo
     *
     * @param material Nuevo material de tipo String
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Método para obtener el color de un Artículo
     *
     * @return Color del Artículo de tipo String
     */
    public String getColor() {
        return color;
    }

    /**
     * Método para establecer un nuevo color a un Artículo
     *
     * @param color Nuevo color de tipo String
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método para obtener el precio de un Artículo
     *
     * @return Precio de un Artículo de tipo double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método para establecer un nuevo precio a un Artículo
     *
     * @param _precio Nuevo precio de tipo double
     * @throws ArticuloException Si el precio que se introduce es negativo
     */
    private void setPrecio(double _precio) throws ArticuloException {

        if (_precio > 0) {

            this.precio = _precio;

        } else {

            // this.precio = 0; mejor no asignarlo porque es primitivo y ya
            // lo pondría a 0 directamente
            throw new ArticuloException("El precio del artículo no puede ser negativo");

        }

    }

    /**
     * Método para obtener el stock de un Artículo
     *
     * @return Stock de un Artículo de tipo int
     */
    public int getStock() {
        return stock;
    }

    /**
     * Método para establecer un nuevo stock a un Artículo
     *
     * @param _stock Nuevo stock de tipo int
     * @throws ArticuloException Si el stock que se introduce es negativo
     */
    private void setStock(int _stock) throws ArticuloException {

        if (_stock > 0) {

            this.stock = _stock;

        } else {

            this.stock = 0;
            throw new ArticuloException("El stock no puede ser negativo");

        }

    }

}
