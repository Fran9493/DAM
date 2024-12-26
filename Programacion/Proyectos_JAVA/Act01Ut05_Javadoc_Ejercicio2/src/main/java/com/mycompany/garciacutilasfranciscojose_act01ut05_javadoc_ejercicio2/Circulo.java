package com.mycompany.garciacutilasfranciscojose_act01ut05_javadoc_ejercicio2;

/**
 * Esta clase permite crear un círculo con dimensiones y color deseados
 * 
 * @author Fran
 * @version 1.0
 */
public class Circulo {

    private double radio;
    private String color;
    private int centroX, centroY;
    
    /**
     * Atributo Radio por defecto. Es una constante de tipo int cuyo valor es de 50
     */
    public final static int RADIO_POR_DEFECTO = 50;

    /**
     * Constructor de la clase sin parámetros de entrada.
     * Crea un círculo con el radio por defecto, color negro y centro en coordenada x=100 e y=100
     */
    public Circulo() {
        this.radio = RADIO_POR_DEFECTO;
        color = "negro";
        centroX = 100;
        centroY = 100;
    }

    /**
     * Constructor de la clase que recibe como entrada el radio, color, coordenada x y coordenada y
     * 
     * @param r Radio del círculo
     * @param c Color del círculo
     * @param px Coordenada x del centro del círculo
     * @param py Coordenada y del centro del círculo
     */
    public Circulo(double r, String c, int px, int py) {
        radio = r;
        color = c;
        centroX = px;
        centroY = py;
    }

    /**
     * Método que devuelve el radio del círculo
     * @return Radio del círculo
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Método que devuelve el color del círculo
     * @return Color del círculo
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que devuelve la coordenada x del centro del círculo
     * @return Coordenada x del centro del círculo
     */    
    public int getCentroX() {
        return centroX;
    }

    /**
     * Método que devuelve la coordenada y del centro del círculo
     * @return Coordenada y del centro del círculo
     */
    public int getCentroY() {
        return centroY;
    }

    /**
     * Método para establecer un nuevo radio al círculo
     * @param nuevoRadio Nuevo radio de tipo double
     */
    public void setRadio(double nuevoRadio) {
        this.radio = nuevoRadio;
    }

    /**
     * Método para establecer un nuevo color al círculo
     * @param nuevoColor Nuevo color de tipo String
     */
    public void setColor(String nuevoColor) {
        color = nuevoColor;
    }

    /**
     * Método para establecer un nuevo centro al círculo
     * @param px Coordenada x de tipo int
     * @param py Coordenada y de tipo int
     */
    public void setCentro(int px, int py) {
        centroX = px;
        centroY = py;
    }
    
    /**
     * Método para desplazar el círculo 10 unidades hacia la derecha
     */
    public void aLaDerecha() {
        centroX += 10;
    }

    /**
     * Método para hacer crecer el círculo. Con él se consigue que el círculo crezca
     * su radio actual por 1.3
     */
    public void crece() {
        radio = radio * 1.3;
    }

    /**
     * Método para hacer el círculo más pequeño. Con él se consigue que el círculo 
     * decrezca su radio entre 1.3
     */
    public void decrece() {
        radio = radio / 1.3;
    }

    /**
     * Método que devuelve el área del círculo
     * @return área del círculo
     */
    public double area() {
        return Math.PI * radio * radio;
    }

    /**
     * Método que devuelve el perímetro del círculo
     * @return perímetro del círculo
     */
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    /**
     * Método que devuelve en un String la información del radio, color y coordenadas del
     * centro del círculo
     * @return Información del círculo en forma de String
     */
    public String toString() {
        String res = "Circulo de radio " + radio;
        res += ", color " + color + " y centro (" + centroX + "," + centroY + ")";
        return res;
    }
}
