package excepciones;

/**
 * Clase exception de perrera. Usada cuando una perrera tiene un error
 * @author Fran
 */
public class PerreraException extends Exception {

     /**
     * Constructor de la clase
     * @param message Mensaje que queremos mostrar cuando se procuzca la excepción
     */
    public PerreraException(String message) {
        super(message);
    }

}
