package clases;

import excepciones.FechaException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Clase Tienda
 *
 * @author Fran
 */
public class Tienda {

    private String nombreTienda;
    private LocalDate fechaApertura;
    private ArrayList<Articulo> articuloTienda;

    /**
     * Constructor de la clase con todos los parámetros
     *
     * @param _nombreTienda Nombre de la tienda de tipo String
     * @param _fechaApertura Fecha de apertura de la tienda de tipo String
     * formato dd/MM/yyyy
     * @param _articuloTienda Artículos de la tienda de tipo ArrayList
     * @throws FechaException Si la fecha de apertura es mayor a 90 días después
     * de la fecha actual
     */
    public Tienda(String _nombreTienda, String _fechaApertura, ArrayList<Articulo> _articuloTienda) throws FechaException {

        creaTienda(_nombreTienda, _fechaApertura, _articuloTienda);

    }

    /**
     * Constructor de la clase sin la fecha de apertura. Se establece fecha
     * actual
     *
     * @param _nombreTienda Nombre de la tienda de tipo String
     * @param _articuloTienda Artículos de la tienda de tipo ArrayList
     * @throws FechaException Si la fecha de apertura es mayor a 90 días después
     * de la fecha actual
     */
    public Tienda(String _nombreTienda, ArrayList<Articulo> _articuloTienda) throws FechaException {

        creaTienda(_nombreTienda, fechaAct(), _articuloTienda);

    }

    /**
     * Método auxiliar para crear la tienda en el constructor
     *
     * @param _nombreTienda Nombre de la tienda
     * @param _fechaApertura Fecha de apertura
     * @param _articuloTienda Artículos de la tienda
     * @throws FechaException Si la fecha de apertura es mayor a 90 días después
     * de la fecha actual
     */
    private void creaTienda(String _nombreTienda, String _fechaApertura, ArrayList<Articulo> _articuloTienda) throws FechaException {

        this.nombreTienda = _nombreTienda;
        setFechaApertura(_fechaApertura);
        this.articuloTienda = new ArrayList<>(_articuloTienda);

    }

    /**
     * Método que calcula el valor total de género del que dispone
     *
     * @return Valor total del género de tipo double
     */
    public double valorTienda() {

        double total = 0;

        for (Articulo a : articuloTienda) {

            total += a.totalValor();

        }

        return total;

    }

    /**
     * Método que muestra la información de la tienda por pantalla
     */
    public void muestraInfo() {

        System.out.println("*** Artículos de la tienda ***");

        for (Articulo a : articuloTienda) {

            System.out.println(a + ", Tipo de Objeto: " + a.getClass().getSimpleName());

        }

    }

    /**
     * Método auxiliar para convertir fechas de tipo dd/MM/yyyy a tipo LocalDate
     *
     * @param fecha Fecha de tipo String dd/MM/yyyy
     * @return Fecha de tipo LocalDate yyyy-MM-dd
     */
    private LocalDate fechaEsp(String fecha) {

        DateTimeFormatter fechaCadena = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(fecha, fechaCadena);

    }

    /**
     * Método auxiliar para calcular la fecha actual de tipo String dd/MM/yyyy
     *
     * @return Fecha actual en String dd/MM/yyyy
     */
    private String fechaAct() {

        LocalDate fechaLocalDate = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = fechaLocalDate.format(formato);

        return fecha;

    }

    /**
     * Método auxiliar para calcular la fecha entre un día pasado por parámetro
     * y la fecha actual
     *
     * @param fecha Fecha de tipo LocalDate
     * @return Diferencia entre fecha actual y la pasada por parámetro en días
     */
    private static long diferenciaDias(LocalDate fecha) {

        LocalDate fechaAct = LocalDate.now();
        LocalDate fechaIn = fecha;

        long dias = ChronoUnit.DAYS.between(fechaAct, fechaIn);

        return dias;

    }

    /**
     * Método para obtener el nombre de la tienda
     *
     * @return Nombre de la tienda de tipo String
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * Método para establecer un nuevo nombre a la tienda
     *
     * @param nombreTienda Nuevo nombre de la tienda de tipo String
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    /**
     * Método para obtener la fecha de apertura de la tienda
     *
     * @return Fecha de apertura de la tienda de tipo LocalDate
     */
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método para establecer una nueva fecha de apertura de la tienda
     *
     * @param _fechaApertura Nueva fecha de apertura de tipo String dd/MM/yyyy
     * @throws FechaException Si la fecha introducida no es del tipo dd/MM/yyyy
     */
    public void setFechaApertura(String _fechaApertura) throws FechaException {

        try {

            LocalDate fechaRecibida = fechaEsp(_fechaApertura);

            if (diferenciaDias(fechaEsp(_fechaApertura)) < 90) {

                this.fechaApertura = fechaRecibida;

            } else {

                throw new FechaException("Error. La fecha de apertura tiene que ser como máximo 90 días posterior a la fecha actual");

            }

        } catch (DateTimeParseException fechaEx) {

            throw new FechaException("Error. El formato de la fecha debe ser dd/MM/yyyy");

        }

    }

    /**
     * Método para obtener los artículos de la tienda
     *
     * @return Artículos de la tienda de tipo ArrayList
     */
    public ArrayList<Articulo> getArticuloTienda() {
        return articuloTienda;
    }

    /**
     * Método para establecer nuevos artículos a la tienda
     *
     * @param articuloTienda Nuevos artículos de la tienda de tipo ArrayList
     */
    public void setArticuloTienda(ArrayList<Articulo> articuloTienda) {
        this.articuloTienda = articuloTienda;
    }

}
