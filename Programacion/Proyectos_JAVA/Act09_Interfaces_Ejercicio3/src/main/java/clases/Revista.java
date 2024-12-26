package clases;

/**
 * Clase Revista que hereda de Publicación
 *
 * @author Fran
 */
public class Revista extends Publicacion {

    private int numero;

    /**
     * Constructor de la clase
     *
     * @param _codigo Código de la revista
     * @param _titulo Título de la revista
     * @param _anoPublicacion Año de publicación de la revista
     * @param _numero Número de la revista
     */
    public Revista(int _codigo, String _titulo, int _anoPublicacion, int _numero) {

        super(_codigo, _titulo, _anoPublicacion);
        this.numero = _numero;

    }

    /**
     * Método toString() de la clase
     *
     * @return Información de la revista en una cadena
     */
    @Override
    public String toString() {
        return super.toString() + ", Número: " + this.numero;
    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return True si dos revistas coinciden en código, título, año de
     * publicación y número, False en caso contrario
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
        Revista other = (Revista) obj;
        if (super.getCodigo() != other.getCodigo()) {
            return false;
        }
        if (super.getAnoPublicacion() != other.getAnoPublicacion()) {
            return false;
        }
        if (!super.getTitulo().equals(other.getTitulo())) {
            return false;
        }

        return this.numero == other.getNumero();

    }

    /**
     * Método que devuelve el número de la revista
     *
     * @return Número de la revista
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para establecer un nuevo número a la revista
     *
     * @param numero Nuevo número a establecer
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

}
