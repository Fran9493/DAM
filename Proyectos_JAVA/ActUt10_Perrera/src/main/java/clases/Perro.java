package clases;

import excepciones.FechaException;
import excepciones.NombreException;
import excepciones.RazaException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Clase Perro. Con ella podemos crear objetos de tipo Perro
 *
 * @author Fran
 */
public class Perro {

    public enum Raza {

        CANICHE, BODEGUERO, PITBULL, BOXER, MASTIN, LABRADOR;

    }

    private int codigo;
    private String nombre;
    private LocalDate fechaNac;
    private Raza razaPerro;

    /**
     * Constructor de la clase
     *
     * @param _codigo Código del perro
     * @param _nombre Nombre del perro
     * @param _fechaNac Fecha de nacimiento del perro del tipo dd/MM/yyyy
     * @param _razaPerro Raza del perro (Caniche, Bodeguero, Pítbull, Bóxer,
     * Mastín, Labrador)
     * @throws RazaException Si la raza no está entre las permitidas como
     * parámetro
     * @throws FechaException Si la fecha no es de tipo dd/MM/yyyy
     * @throws NombreException Si el nombre tiene menos de 3 caracteres
     */
    public Perro(int _codigo, String _nombre, String _fechaNac, String _razaPerro) throws RazaException, FechaException, NombreException {

        this.codigo = _codigo;
        setNombre(_nombre);
        setFechaNac(_fechaNac);
        setRazaPerro(_razaPerro);

    }

    /**
     * Método toString() de la clase
     *
     * @return Información del perro en forma de cadena
     */
    @Override
    public String toString() {
        return "Código: " + this.codigo + ", Nombre: " + this.nombre + ", Fecha de nacimiento: "
                + fechaNac.getDayOfMonth() + "/" + fechaNac.getMonthValue() + "/" + fechaNac.getYear()
                + ", Raza: " + this.razaPerro;
    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return True si dos perros tienen el mismo código, False en caso
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perro other = (Perro) obj;
        return this.codigo == other.codigo;
    }

    /**
     * Método que imprime por pantalla la información del perro
     */
    public void imprimir() {

        System.out.println("*** Información del perro ***");
        System.out.println("Código: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de nacimiento: " + fechaNac.getDayOfMonth() + "/" + fechaNac.getMonthValue() + "/" + fechaNac.getYear());
        System.out.println("Edad del Perro: " + devuelveEdad());
        System.out.println("Raza: " + this.razaPerro);

    }

    /**
     * Método que devuelve la edad del perro en años
     *
     * @return Edad del perro en años de tipo int
     */
    public int devuelveEdad() {

        Period diferencia = Period.between(fechaNac, LocalDate.now());
        int edad = diferencia.getYears();
        return edad;

    }

    /**
     * Método para obtener el código del perro
     *
     * @return Código del perro de tipo int
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método para establecer un nuevo código al perro
     *
     * @param codigo Nuevo código de tipo int
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para obtener el nombre del perro
     *
     * @return Nombre del perro de tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer un nuevo nombre al perro
     *
     * @param _nombre Nombre de tipo String
     * @throws NombreException Si el nombre tiene menos de 3 caracteres
     */
    public void setNombre(String _nombre) throws NombreException {

        if (_nombre.length() >= 3) {

            this.nombre = _nombre;

        } else {

            throw new NombreException("El nombre debe de tener al menos 3 caracteres");

        }

    }

    /**
     * Método para establecer una nueva fecha de nacimiento al perro
     *
     * @param _fechaNac Nueva fecha de nacimiento en tipo String con formato
     * dd/MM/yyyy
     * @throws FechaException Si la fecha introducida no es del tipo dd/MM/yyyy
     */
    public void setFechaNac(String _fechaNac) throws FechaException {

        try {

            LocalDate fechaRecibida = fechaEsp(_fechaNac);

            if (fechaRecibida.isBefore(LocalDate.now())) {

                this.fechaNac = fechaRecibida;

            } else {

                throw new FechaException("Error. La fecha de nacimiento no puede ser posterior a la actual");

            }

        } catch (DateTimeParseException fechaEx) {

            throw new FechaException("Error. El formato de la fecha debe ser dd/MM/yyyy");

        }

    }

    /**
     * Método que devuelve la fecha de nacimiento del perro
     *
     * @return Fecha de nacimiento del perro de tipo LocalDate
     */
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    /**
     * Método que devuelve la raza del perro
     *
     * @return Raza del perro de tipo Raza
     */
    public Raza getRazaPerro() {
        return razaPerro;
    }

    /**
     * Método para establecer una nueva raza al perro
     *
     * @param _razaPerro Nueva raza de tipo String
     * @throws RazaException Si la raza no es correcta (Caniche, Bodeguero,
     * Pítbull, Bóxer, Mastín, Labrador)
     */
    public void setRazaPerro(String _razaPerro) throws RazaException {

        try {

            this.razaPerro = Raza.valueOf(convierteCadena(_razaPerro));

        } catch (IllegalArgumentException ex) {

            throw new RazaException(_razaPerro);

        }
    }

    /**
     * Método privado de la clase que convierte una cadena a Mayúsculas y si
     * lleva tildes se las quita
     *
     * @param entrada String a convertir
     * @return String en mayúsculas sin tildes
     */
    private String convierteCadena(String entrada) {

        String cadena = entrada.toUpperCase();

        String cadenaUtil = cadena.replace("Á", "A").replace("É", "E").replace("Í", "I")
                .replace("Ó", "O").replace("Ú", "U");

        return cadenaUtil;

    }

    /**
     * Método privado de la clase que convierte una fecha tipo String en una
     * tipo LocalDate
     *
     * @param fecha Fecha de tipo String formato dd/MM/yyyy
     * @return Fecha tipo LocalDate formato yyyy-MM-dd
     */
    private LocalDate fechaEsp(String fecha) {

        DateTimeFormatter fechaCadena = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(fecha, fechaCadena);

    }

}
