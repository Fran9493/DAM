package utilidades;

/**
 * Clase útil para comprobar si es correcto un Dni
 * @author Fran
 */
public class Dni {

    /**
     * Método para comprobar Dni
     * @param dni
     * @return True si el dni es válido (8 caracteres y una letra), o false en el caso contrario
     */
    public static boolean compruebaDni(String dni) {

        char dniChar[] = new char[dni.length()];
        dniChar = dni.toCharArray();
        boolean salida = true;

        if (dni.length() != 9) {

            salida = false;

        } else {

            for (int i = 0; i < dniChar.length; i++) {

                if (i < 8 && !Character.isDigit(dniChar[i])) {

                    salida = false;

                }

                if (i == 8 && !Character.isLetter(dniChar[i])) {

                    salida = false;

                }

            }

        }

        return salida;

    }

}
