package clases;

import excepciones.ArticuloException;

/**
 * Clase Zapato
 *
 * @author Fran
 */
public class Zapato extends Articulo {

    private int numero;
    private String tipo;

    /**
     * Constructor de la clase
     *
     * @param _codigo Código del zapato de tipo String
     * @param _nombre Nombre del zapato de tipo String
     * @param _material Material del zapato de tipo String
     * @param _color Color del zapato de tipo String
     * @param _precio Precio del zapato de tipo double
     * @param _stock Stock del zapato de tipo int
     * @param _numero Número del zapato de tipo int
     * @param _tipo Tipo de zapato de tipo String
     * @throws ArticuloException Si el precio introducido o el stock es negativo
     */
    public Zapato(String _codigo, String _nombre, String _material, String _color, double _precio, int _stock, int _numero, String _tipo) throws ArticuloException {

        super(_codigo, _nombre, _material, _color, _precio, _stock);
        this.numero = _numero;
        this.tipo = _tipo;

    }

    /**
     * Método toString de la clase
     *
     * @return Información del zapato en tipo cadena
     */
    @Override
    public String toString() {
        return super.toString() + ", Número: " + this.numero + ", Tipo: " + this.tipo;
    }

    /**
     * Método mostrarInfo de la clase. Muestra por pantalla la información del
     * zapato
     */
    @Override
    public void mostrarInfo() {

        System.out.println("*** Información del Zapato ***");
        System.out.println("Código: " + super.getCodigo());
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Material: " + super.getMaterial());
        System.out.println("Color: " + super.getColor());
        System.out.println("Número: " + this.getNumero());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Precio: " + super.getPrecio() + "€");
        System.out.println("Stock: " + super.getStock());

    }

    /**
     * Método para obtener el número del zapato
     *
     * @return Número del zapato de tipo int
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para establecer un nuevo número al zapato
     *
     * @param numero Nuevo número de tipo int
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo para obtener el tipo de zapato
     *
     * @return Tipo de zapato de tipo String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo para establecer un nuevo tipo de zapato
     *
     * @param tipo Nuevo tipo de tipo String
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
