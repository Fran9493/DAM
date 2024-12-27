package excepciones;

/**
 * Clase exception de raza. Usada cuando una raza no es correcta
 * @author Fran
 */
public class RazaException extends IllegalArgumentException {

    private String raza;

    /**
     * Constructor de la clase
     * @param _raza raza a la que hacemos referencia en la excepción
     */ 
    public RazaException(String _raza) {

        this.raza = _raza;

    }

    /**
     * Método que devuelve el mensaje de error
     * @return Mensaje de error cuando una raza no es correcta
     */
    @Override
    public String getMessage() {

        return "La raza " + this.raza + " no es válida";

    }

}
