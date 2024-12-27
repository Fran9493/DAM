package com.mycompany.garciacutillasfranciscojoseactut07clases;

/**
 *
 * @author Fran
 */
public class Punto {

    private static final int MINALEATORIO = -100;
    private static final int MAXALEATORIO = 100;

    private int x;
    private int y;

    public Punto(int _x, int _y) {

        this.x = _x;
        this.y = _y;

    }

    //Este método imprime por pantalla las coordenadas del punto
    public void imprime() {

        System.out.println("(" + this.x + "," + this.y + ")");

    }

    //Este método permite modificar las dos coordenadas del punto a la vez
    public void setXY(int _x, int _y) {

        this.x = _x;
        this.y = _y;

    }

    //Este método permite desplazar el punto tanto en x como en y
    public void desplaza(int dx, int dy) {

        this.x += dx;
        this.y += dy;

    }

    //Este método devuelve como resultado la distancia entre el punto, y otro punto pasado como parámetro
    public double distancia(Punto p) {

        double resultado = Math.sqrt((Math.pow(p.getX() - this.x, 2)) + (Math.pow(p.getY() - this.y, 2)));

        return resultado;

    }

    //Este método genera un punto aleatorio en el rango que se haya introducido en las constantes
    //presentes en los atributos de la clase Punto
    public static Punto nuevoPuntoAleatorio() {

        int xAleatorio = (int) (Math.random() * ((MAXALEATORIO - MINALEATORIO) + 1)) + MINALEATORIO;
        int yAleatorio = (int) (Math.random() * ((MAXALEATORIO - MINALEATORIO) + 1)) + MINALEATORIO;

        return new Punto(xAleatorio, yAleatorio);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
