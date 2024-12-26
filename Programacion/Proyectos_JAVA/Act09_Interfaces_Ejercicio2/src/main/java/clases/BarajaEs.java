package clases;

/**
 * Clase Baraja Española
 *
 * @author Fran
 */
public class BarajaEs {

    public enum Palo {

        OROS, BASTOS, COPAS, ESPADAS;

    }

    private Palo palo;
    private int numero;

    /**
     * Constructor de la clase
     *
     * @param _palo Palo de la carta a crear (Oros, Bastos, Copas, Espadas)
     * @param _numero Número de la carta a crear del 1 al 12
     */
    public BarajaEs(Palo _palo, int _numero) {

        this.palo = _palo;

        if (_numero >= 1 && _numero <= 12) {

            this.numero = _numero;

        } else {

            System.out.println("El número de la baraja debe estar entre 1 y 12");

        }

    }

    /**
     * Método toString() de la clase
     *
     * @return Información de la carta (Número y palo)
     */
    @Override
    public String toString() {
        return "Número: " + this.numero + ", palo: " + this.palo;
    }

    /**
     * Método equals de la clase
     *
     * @param obj Objeto a comparar
     * @return true si es la misma carta, false en caso contrario
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
        BarajaEs other = (BarajaEs) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return this.palo == other.palo;
    }

    /**
     * Método que genera una carta al azar
     *
     * @return Carta de un número y palo generado aleatoriamente
     */
    public static BarajaEs generaCarta() {

        int palo = (int) (Math.floor(Math.random() * (4 - 1 + 1) + 1));
        int numero = (int) (Math.floor(Math.random() * (12 - 1 + 1) + 1));

        Palo paloSeleccionado;

        if (palo == 1) {

            paloSeleccionado = Palo.BASTOS;

        } else if (palo == 2) {

            paloSeleccionado = Palo.COPAS;

        } else if (palo == 3) {

            paloSeleccionado = Palo.ESPADAS;

        } else {

            paloSeleccionado = Palo.OROS;

        }

        BarajaEs cartaAleatoria = new BarajaEs(paloSeleccionado, numero);

        return cartaAleatoria;

    }

    /**
     * Método para obtener el palo de la carta
     *
     * @return Palo de la carta
     */
    public Palo getPalo() {
        return palo;
    }

    /**
     * Método para establecer un nuevo palo a la carta
     *
     * @param palo Nuevo palo
     */
    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    /**
     * Método para obtener el número de la carta
     *
     * @return Número de la carta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para establecer un nuevo número a la carta
     *
     * @param numero Nuevo número del 1 al 12
     */
    public void setNumero(int numero) {

        if (numero >= 1 && numero <= 12) {

            this.numero = numero;

        } else {

            System.out.println("El número debe ser entre 1 y 12");

        }

    }

}
