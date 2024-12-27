package excepciones;

/**
 * Clase exception de fecha. Usada cuando una fecha se introduce de forma incorrecta
 * @author Fran
 */
public class FechaException extends Exception {

    /**
     * Constructor de la clase
     * @param message Mensaje que queremos mostrar cuando se procuzca la excepción
     */
    public FechaException(String message) {
        super(message);
    }

}
