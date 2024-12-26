package utilidades;

/**
 *
 * @author Fran
 */
public class Dni {

    //Método para comprobar que introducen el dni correcto
    //Devuelve true si el dni tiene los 8 primeros caracteres numéricos y el último es una letra,
    //en cualquier otro caso devuelve false
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
