package clases;

import excepciones.ArticuloException;

/**
 * Clase Bolso
 *
 * @author Fran
 */
public class Bolso extends Articulo {

    /**
     * Enumerado de los tipos de bolso disponibles
     */
    public enum TipoBolso {

        BANDOLERA, MOCHILA, FIESTA;

    }

    private String marca;
    private TipoBolso tipo;

    /**
     * Constructor de la clase
     *
     * @param _codigo Código del bolso de tipo String
     * @param _nombre Nombre del bolso de tipo String
     * @param _material Material del bolso de tipo String
     * @param _color Color del bolso de tipo String
     * @param _precio Precio del bolso de tipo double
     * @param _stock Stock del bolso de tipo int
     * @param _marca Marca del bolso de tipo String
     * @param _tipo Tipo de bolso de tipo TipoBolso (Bandolera, Mochila, Fiesta)
     * @throws ArticuloException Si se introduce un precio o stock negativo, o
     * un tipo de bolso no válido
     */
    public Bolso(String _codigo, String _nombre, String _material, String _color, double _precio, int _stock, String _marca, String _tipo) throws ArticuloException {

        super(_codigo, _nombre, _material, _color, _precio, _stock);
        this.marca = _marca;
        setTipo(_tipo);

    }

    /**
     * Metodo toString de la clase
     *
     * @return Información del bolso en una cadena
     */
    @Override
    public String toString() {
        return super.toString() + ", Marca: " + this.marca + ", Tipo: " + this.tipo;
    }

    /**
     * Método mostrarInfo de la clase. Muestra por pantalla la información del
     * bolso
     */
    @Override
    public void mostrarInfo() {

        System.out.println("*** Información del Bolso ***");
        System.out.println("Código: " + super.getCodigo());
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Material: " + super.getMaterial());
        System.out.println("Color: " + super.getColor());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Precio: " + super.getPrecio() + "€");
        System.out.println("Stock: " + super.getStock());

    }

    /**
     * Método para obtener la marca del bolso
     *
     * @return Marca del bolso de tipo String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para establecer una nueva marca al bolso
     *
     * @param marca Nueva marca de tipo String
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para obtener el tipo de bolso
     *
     * @return Tipo de bolso de tipo String
     */
    public String getTipo() {
        return this.tipo.toString();
    }

    /**
     * Método para establecer un nuevo tipo de bolso
     *
     * @param _tipo Nuevo tipo de tipo String
     * @throws ArticuloException Si el tipo de bolso no se encuentra entre
     * Bandolera, Mochila o Fiesta
     */
    public void setTipo(String _tipo) throws ArticuloException {

        try {

            this.tipo = TipoBolso.valueOf(convierteCadena(_tipo));

        } catch (IllegalArgumentException ex) {

            throw new ArticuloException("El tipo de bolso elegido no es válido");

        }
    }

    /**
     * Método privado de la clase que convierte una cadena en vocal y le quita
     * las tildes que pueda llevar
     *
     * @param entrada Cadena a convertir
     * @return Cadena en mayúscula y sin tildes
     */
    private String convierteCadena(String entrada) {

        String cadena = entrada.toUpperCase();

        String cadenaUtil = cadena.replace("Á", "A").replace("É", "E").replace("Í", "I")
                .replace("Ó", "O").replace("Ú", "U");

        return cadenaUtil;

    }

}
