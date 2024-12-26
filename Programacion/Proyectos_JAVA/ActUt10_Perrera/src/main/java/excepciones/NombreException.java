package excepciones;

/**
 * Clase exception de nombre. Usada cuando un nombre es incorrecto
 * @author Fran
 */
public class NombreException extends Exception {

    /**
     * Constructor de la clase
     * @param message Mensaje que queremos mostrar cuando se procuzca la excepción
     */
    public NombreException(String message) {
        super(message);
    }

}
